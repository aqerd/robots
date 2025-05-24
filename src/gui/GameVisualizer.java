package gui;

import log.Logger;
import entity.RobotModel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class GameVisualizer extends JPanel implements Observer {
	private final RobotModel model;

	public GameVisualizer(RobotModel model) {
		this.model = model;
		if (model instanceof Observable) {
			((Observable) model).addObserver(this);
		} else {
			Logger.warn("RobotModel instance passed to GameVisualizer is not Observable.");
		}
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setTargetPosition(e.getPoint());
			}
		});
		setDoubleBuffered(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		AffineTransform originalTransform = g2d.getTransform();

		drawRobot(g2d, model);

		g2d.setTransform(originalTransform);
		drawTarget(g2d, (int) model.getTargetX(), (int) model.getTargetY());
	}

	private void drawRobot(Graphics2D g, RobotModel robotModel) {
		int x = (int) robotModel.getRobotX();
		int y = (int) robotModel.getRobotY();
		double direction = robotModel.getRobotDirection();
		Image robotImage = robotModel.getImage();

		AffineTransform t = AffineTransform.getRotateInstance(direction, x, y);
		g.setTransform(t);

		if (robotImage != null) {
			int imgWidth = robotImage.getWidth(this);
			int imgHeight = robotImage.getHeight(this);
			g.drawImage(robotImage, x - imgWidth / 2, y - imgHeight / 2, this);
		} else {
			g.setColor(Color.MAGENTA);
			fillOval(g, x, y, 30, 10);
			g.setColor(Color.BLACK);
			drawOval(g, x, y, 30, 10);
			g.setColor(Color.WHITE);
			fillOval(g, x + 10, y, 5, 5);
			g.setColor(Color.BLACK);
			drawOval(g, x + 10, y, 5, 5);
		}
	}

	private void drawTarget(Graphics2D g, int x, int y) {
		g.setColor(Color.GREEN);
		fillOval(g, x, y, 5, 5);
		g.setColor(Color.BLACK);
		drawOval(g, x, y, 5, 5);
	}

	private static void fillOval(Graphics g, int centerX, int centerY, int diam1, int diam2) {
		g.fillOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
	}

	private static void drawOval(Graphics g, int centerX, int centerY, int diam1, int diam2) {
		g.drawOval(centerX - diam1 / 2, centerY - diam2 / 2, diam1, diam2);
	}
}
