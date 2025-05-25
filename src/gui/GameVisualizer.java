package gui;

import entity.RobotModel;
import entity.Target;
import log.Logger;
import utils.LocalizationManager;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
			Logger.warn(LocalizationManager.getLocalizedText("warnRobotModelNotObservable"));
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

		model.draw(g2d, this);

		g2d.setTransform(originalTransform);

		Target targetToDraw = new Target((int) model.getTargetX(), (int) model.getTargetY());
		targetToDraw.draw(g2d);
	}
}
