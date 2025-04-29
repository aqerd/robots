package entity;

import java.util.Observable;
import java.util.ArrayList;
import java.util.List;

public class Robot extends Observable {

    private double positionX;
    private double positionY;
    private double direction;
    private List<Double> pathX;
    private List<Double> pathY;
    private static final double MAX_VELOCITY = 5.0;
    private static final double MAX_ANGULAR_VELOCITY = 0.1;

    public Robot(double x, double y, double direction) {
        this.positionX = x;
        this.positionY = y;
        this.direction = direction;
        this.pathX = new ArrayList<>();
        this.pathY = new ArrayList<>();
        addPath(x, y);
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getDirection() {
        return direction;
    }

    public List<Double> getPathX() {
        return pathX;
    }

    public List<Double> getPathY() {
        return pathY;
    }

    private void addPath(double x, double y) {
        this.pathX.add(x);
        this.pathY.add(y);
    }

    public void move(double distance) {
        move(distance, 0, 10, 0, 0);
    }

    public void move(double distance, double angularVelocity, int time, int panelWidth, int panelHeight) {
        double newX = positionX + distance * Math.cos(direction);
        double newY = positionY + distance * Math.sin(direction);

        if (newX < 0) {
            newX = 0;
        }
        if (newY < 0) {
            newY = 0;
        }
        if (newX > panelWidth) {
            newX = panelWidth;
        }
        if (newY > panelHeight) {
            newY = panelHeight;
        }

        positionX = newX;
        positionY = newY;
        direction += angularVelocity * time;
        addPath(newX, newY);
        setChanged();
        notifyObservers();
    }

    public void turnLeft(double angle) {
        direction += angle;
        setChanged();
        notifyObservers();
    }

    public void turnRight(double angle) {
        direction -= angle;
        setChanged();
        notifyObservers();
    }

    public void setPosition(double x, double y, double direction) {
        this.positionX = x;
        this.positionY = y;
        this.direction = direction;
        addPath(x, y);
        setChanged();
        notifyObservers();
    }

    public void resetPath() {
        this.pathX.clear();
        this.pathY.clear();
        addPath(positionX, positionY);
        setChanged();
        notifyObservers();
    }

    public static double getMaxVelocity() {
        return MAX_VELOCITY;
    }

    public static double getMaxAngularVelocity() {
        return MAX_ANGULAR_VELOCITY;
    }
}
