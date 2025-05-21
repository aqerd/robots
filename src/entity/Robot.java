package entity;

import java.awt.Point;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

// TODO interface для других роботов
public class Robot extends Observable {
    private volatile double robotX = 100;
    private volatile double robotY = 100;
    private volatile double robotDirection = 0;

    private volatile double targetX = 150;
    private volatile double targetY = 100;

    private static final double maxVelocity = 1.2;
    private static final double maxAngularVelocity = 0.01;

    public Robot() {
        Timer timer = new Timer("Robot timer", true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateModel();
            }
        }, 0, 10);
    }

    private void updateModel() {
        double distance = Point.distance(robotX, robotY, targetX, targetY);
        if (distance < 0.5) return;

        double angleToTarget = Math.atan2(targetY - robotY, targetX - robotX);
        double angularVelocity = angleToTarget - robotDirection;

        angularVelocity = Math.atan2(Math.sin(angularVelocity), Math.cos(angularVelocity));

        robotDirection += Math.max(-maxAngularVelocity, Math.min(maxAngularVelocity, angularVelocity));

        robotX += maxVelocity * Math.cos(robotDirection);
        robotY += maxVelocity * Math.sin(robotDirection);

        setChanged();
        notifyObservers();
    }

    public synchronized double getRobotX() {
        return robotX;
    }

    public synchronized double getRobotY() {
        return robotY;
    }

    public synchronized double getRobotDirection() {
        return robotDirection;
    }

    public synchronized double getTargetX() {
        return targetX;
    }

    public synchronized double getTargetY() {
        return targetY;
    }

    public synchronized void setTargetPosition(Point p) {
        this.targetX = p.x;
        this.targetY = p.y;
        setChanged();
        notifyObservers();
    }
}