package entity.robots;

import entity.RobotModel;
import log.Logger;
import utils.LocalizationManager;
import java.awt.Point;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Pub extends Observable implements RobotModel {
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

	public Pub() {
		try {
			String IMAGE_PATH = "/images/pub.png";
			URL imageURL = getClass().getResource(IMAGE_PATH);
			if (imageURL != null) {
				Image originalImage = ImageIO.read(imageURL);
				if (originalImage != null) {
					this.robotImage = originalImage.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
				} else {
					Logger.error(LocalizationManager.getLocalizedText("imageReadError", IMAGE_PATH));
					this.robotImage = null;
				}
			} else {
				this.robotImage = null;
			}
		} catch (IOException e) {
			Logger.error(LocalizationManager.getLocalizedText("imageLoadError", e.getMessage()));
			this.robotImage = null;
		}

		Timer timer = new Timer("Pub timer", true);
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
		}
	}
}
