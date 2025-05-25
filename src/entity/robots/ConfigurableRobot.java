package entity.robots;

import entity.RobotModel;
import log.Logger;
import utils.LocalizationManager;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class ConfigurableRobot extends Observable implements RobotModel {

    public enum Shape {
        CIRCLE, OVAL, SQUARE, TRIANGLE, STAR
    }

    private volatile double robotX = 100;
    private volatile double robotY = 100;
    private volatile double robotDirection = 0;

    private volatile double targetX = 150;
    private volatile double targetY = 100;

    private double maxVelocity;
    private double maxAngularVelocity;

    private int size;
    private Shape shape;
    private Color fillColor;
    private Color borderColor;
    private Color targetIndicatorColor;

    public ConfigurableRobot(int size, Shape shape, Color fillColor, Color borderColor, Color targetIndicatorColor, double maxVelocity, double maxAngularVelocity) {
        this.size = Math.max(10, Math.min(size, 100));
        this.shape = shape;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.targetIndicatorColor = targetIndicatorColor;
        this.maxVelocity = maxVelocity;
        this.maxAngularVelocity = maxAngularVelocity;

        Timer timer = new Timer("ConfigurableRobot timer", true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateModel();
            }
        }, 0, 10);
        Logger.info(LocalizationManager.getLocalizedText("logRobotCreatedCustom", shape, size, fillColor, borderColor, maxVelocity, maxAngularVelocity));
    }

    @Override
    public void updateModel() {
        double distance = Point.distance(robotX, robotY, targetX, targetY);
        if (distance < 0.5) {
            return;
        }

        double angleToTarget = Math.atan2(targetY - robotY, targetX - robotX);
        double angularVelocity = angleToTarget - robotDirection;

        while (angularVelocity > Math.PI) angularVelocity -= 2 * Math.PI;
        while (angularVelocity < -Math.PI) angularVelocity += 2 * Math.PI;
        
        angularVelocity = Math.max(-this.maxAngularVelocity, Math.min(this.maxAngularVelocity, angularVelocity));
        robotDirection += angularVelocity;
        
        while (robotDirection > Math.PI) robotDirection -= 2 * Math.PI;
        while (robotDirection < -Math.PI) robotDirection += 2 * Math.PI;

        robotX += this.maxVelocity * Math.cos(robotDirection);
        robotY += this.maxVelocity * Math.sin(robotDirection);

        setChanged();
        notifyObservers();
    }

    @Override
    public void draw(Graphics2D g, JPanel observer) {
        int rX = (int) getRobotX();
        int rY = (int) getRobotY();
        double dir = getRobotDirection();

        AffineTransform originalTransform = g.getTransform();

        AffineTransform robotTransform = AffineTransform.getRotateInstance(dir, rX, rY);
        g.transform(robotTransform);

        g.setColor(this.fillColor);
        float halfSize = size / 2.0f;

        AffineTransform shapeTransform = new AffineTransform();

        switch (this.shape) {
            case CIRCLE:
                g.fill(new Ellipse2D.Double(rX - halfSize, rY - halfSize, size, size));
                break;
            case OVAL:
                g.fill(new Ellipse2D.Double(rX - halfSize, rY - halfSize / 1.5, size, size / 1.5));
                break;
            case SQUARE:
                g.fill(new Rectangle2D.Double(rX - halfSize, rY - halfSize, size, size));
                break;
            case TRIANGLE:
                shapeTransform.rotate(Math.PI / 2, rX, rY);
                g.transform(shapeTransform);
                Polygon triangle = new Polygon();
                triangle.addPoint(rX, rY - (int)halfSize);
                triangle.addPoint(rX - (int)halfSize, rY + (int)(halfSize / 2));
                triangle.addPoint(rX + (int)halfSize, rY + (int)(halfSize / 2));
                g.fillPolygon(triangle);
                try {
                    g.transform(shapeTransform.createInverse());
                } catch (NoninvertibleTransformException e) {
                    Logger.error(LocalizationManager.getLocalizedText("errorInvertShapeTransform", e.getMessage()));
                }
                break;
            case STAR:
                shapeTransform.rotate(Math.PI / 2, rX, rY);
                g.transform(shapeTransform);
                Path2D star = createStar(rX, rY, halfSize, halfSize / 2, 5);
                g.fill(star);
                try {
                    g.transform(shapeTransform.createInverse());
                } catch (NoninvertibleTransformException e) {
                    Logger.error(LocalizationManager.getLocalizedText("errorInvertShapeTransform", e.getMessage()));
                }
                break;
        }

        g.setColor(this.borderColor);

        switch (this.shape) {
            case CIRCLE:
                g.draw(new Ellipse2D.Double(rX - halfSize, rY - halfSize, size, size));
                break;
            case OVAL:
                g.draw(new Ellipse2D.Double(rX - halfSize, rY - halfSize / 1.5, size, size / 1.5));
                break;
            case SQUARE:
                g.draw(new Rectangle2D.Double(rX - halfSize, rY - halfSize, size, size));
                break;
            case TRIANGLE:
                shapeTransform.setToIdentity();
                shapeTransform.rotate(Math.PI / 2, rX, rY);
                g.transform(shapeTransform);
                Polygon triangleBorder = new Polygon();
                triangleBorder.addPoint(rX, rY - (int)halfSize);
                triangleBorder.addPoint(rX - (int)halfSize, rY + (int)(halfSize / 2));
                triangleBorder.addPoint(rX + (int)halfSize, rY + (int)(halfSize / 2));
                g.drawPolygon(triangleBorder);
                try {
                    g.transform(shapeTransform.createInverse());
                } catch (NoninvertibleTransformException e) {
                    Logger.error(LocalizationManager.getLocalizedText("errorInvertShapeTransform", e.getMessage()));
                }
                break;
            case STAR:
                shapeTransform.setToIdentity();
                shapeTransform.rotate(Math.PI / 2, rX, rY);
                g.transform(shapeTransform);
                Path2D starBorder = createStar(rX, rY, halfSize, halfSize / 2, 5);
                g.draw(starBorder);
                try {
                    g.transform(shapeTransform.createInverse());
                } catch (NoninvertibleTransformException e) {
                    Logger.error("Failed to invert shape transform: " + e.getMessage());
                }
                break;
        }
        
        g.setTransform(originalTransform);
        g.transform(robotTransform);
        g.setColor(this.targetIndicatorColor != null ? this.targetIndicatorColor : Color.RED);
        int indicatorOffsetX = (int)(halfSize * 0.8);
        int indicatorOffsetY = 0;
        g.fillOval(rX + indicatorOffsetX - 2, rY + indicatorOffsetY - 2, 4, 4); 
        g.setTransform(originalTransform);
    }

    private Path2D createStar(double centerX, double centerY, double outerRadius, double innerRadius, int numPoints) {
        Path2D path = new Path2D.Double();
        double angleIncrement = Math.PI / numPoints;
        for (int i = 0; i < 2 * numPoints; i++) {
            double radius = (i % 2 == 0) ? outerRadius : innerRadius;
            double angle = i * angleIncrement - Math.PI / 2;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            if (i == 0) {
                path.moveTo(x, y);
            } else {
                path.lineTo(x, y);
            }
        }
        path.closePath();
        return path;
    }

    @Override public synchronized double getRobotX() {
        return robotX;
    }

    @Override public synchronized double getRobotY() {
        return robotY;
    }

    @Override public synchronized double getRobotDirection() {
        return robotDirection;
    }

    @Override public synchronized double getTargetX() {
        return targetX;
    }

    @Override public synchronized double getTargetY() {
        return targetY;
    }

    @Override public synchronized void setTargetPosition(Point p) {
        this.targetX = p.x;
        this.targetY = p.y;
        setChanged();
        notifyObservers();
    }
}
