package entity.robots;

import java.awt.Point;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import entity.RobotModel;
import log.Logger;
import utils.LocalizationManager;

public class CustomImageRobot extends Observable implements RobotModel {
    private static final int IMAGE_WIDTH = 64;
    private static final int IMAGE_HEIGHT = 64;

    private volatile double robotX = 100;
    private volatile double robotY = 100;
    private volatile double robotDirection = 0;

    private volatile double targetX = 150;
    private volatile double targetY = 100;

    private static final double MAX_VELOCITY = 1.2;
    private static final double MAX_ANGULAR_VELOCITY = 0.01;

    private Image robotImage;
    private String imagePath;

    public CustomImageRobot(String imagePath) {
        this.imagePath = imagePath;
        try {
            File imageFile = new File(this.imagePath);
            if (imageFile.exists()) {
                Image originalImage = ImageIO.read(imageFile);
                if (originalImage != null) {
                    this.robotImage = originalImage.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
                } else {
                    Logger.error(LocalizationManager.getLocalizedText("imageReadError", this.imagePath));
                    this.robotImage = null;
                }
            } else {
                Logger.error(LocalizationManager.getLocalizedText("imageFileNotExistError", this.imagePath));
                this.robotImage = null;
            }
        } catch (IOException e) {
            Logger.error(LocalizationManager.getLocalizedText("imageLoadErrorUser", this.imagePath, e.getMessage()));
            this.robotImage = null;
        }

        Timer timer = new Timer("CustomImageRobot timer", true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateModel();
            }
        }, 0, 10);
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
        
        angularVelocity = Math.max(-MAX_ANGULAR_VELOCITY, Math.min(MAX_ANGULAR_VELOCITY, angularVelocity));
        robotDirection += angularVelocity;
        
        while (robotDirection > Math.PI) robotDirection -= 2 * Math.PI;
        while (robotDirection < -Math.PI) robotDirection += 2 * Math.PI;

        robotX += MAX_VELOCITY * Math.cos(robotDirection);
        robotY += MAX_VELOCITY * Math.sin(robotDirection);

        setChanged();
        notifyObservers();
    }

    @Override
    public synchronized double getRobotX() {
        return robotX;
    }

    @Override
    public synchronized double getRobotY() {
        return robotY;
    }

    @Override
    public synchronized double getRobotDirection() {
        return robotDirection;
    }

    @Override
    public synchronized double getTargetX() {
        return targetX;
    }

    @Override
    public synchronized double getTargetY() {
        return targetY;
    }

    @Override
    public synchronized void setTargetPosition(Point p) {
        this.targetX = p.x;
        this.targetY = p.y;
        setChanged();
        notifyObservers();
    }

    @Override
    public void draw(Graphics2D g, JPanel observer) {
        int robotXCoord = (int) getRobotX();
        int robotYCoord = (int) getRobotY();
        double direction = getRobotDirection();

        AffineTransform t = AffineTransform.getRotateInstance(direction, robotXCoord, robotYCoord);
        g.setTransform(t);

        if (this.robotImage != null) {
            int imgWidth = this.robotImage.getWidth(observer);
            int imgHeight = this.robotImage.getHeight(observer);
            g.drawImage(this.robotImage, robotXCoord - imgWidth / 2, robotYCoord - imgHeight / 2, observer);
        } else {
            // Можно добавить отрисовку по умолчанию, если изображение не загружено
            g.setColor(java.awt.Color.RED);
            g.fillRect(robotXCoord - 10, robotYCoord - 10, 20, 20);
            g.setColor(java.awt.Color.BLACK);
            g.drawString("X", robotXCoord - 4, robotYCoord + 4);
        }
    }
}