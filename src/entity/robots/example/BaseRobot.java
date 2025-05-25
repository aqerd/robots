package entity.robots.example;

import entity.robots.RobotModel;

import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class BaseRobot extends Observable implements RobotModel {
	private volatile double robotX = 100;
	private volatile double robotY = 100;
	private volatile double robotDirection = 0;

	private volatile double targetX = 150;
	private volatile double targetY = 100;

	private static final double maxVelocity = 1.2;
	private static final double maxAngularVelocity = 0.01;

	public BaseRobot() {
		Timer timer = new Timer("Robot timer", true);
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

		g.setColor(Color.MAGENTA);
		g.fillOval(robotXCoord - 30 / 2, robotYCoord - 10 / 2, 30, 10);
		g.setColor(Color.BLACK);
		g.drawOval(robotXCoord - 30 / 2, robotYCoord - 10 / 2, 30, 10);
		g.setColor(Color.WHITE);
		g.fillOval(robotXCoord + 10 - 5 / 2, robotYCoord - 5 / 2, 5, 5);
		g.setColor(Color.BLACK);
		g.drawOval(robotXCoord + 10 - 5 / 2, robotYCoord - 5 / 2, 5, 5);
	}
}
