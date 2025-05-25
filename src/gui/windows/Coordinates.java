package gui.windows;

import entity.RobotModel;
import log.Logger;
import utils.LocalizationManager;
import utils.StatefulWindow;
import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;

public class Coordinates extends JInternalFrame implements Observer, StatefulWindow {
	private final JLabel coordinatesLabel = new JLabel("Coordinates");

	public Coordinates(RobotModel model) {
		super("", true, true, true, true);
		if (model instanceof Observable) {
			((Observable) model).addObserver(this);
		} else {
			Logger.warn(LocalizationManager.getLocalizedText("warnRobotModelNotObservable"));
		}
		setLayout(new BorderLayout());
		add(coordinatesLabel, BorderLayout.CENTER);
		setSize(250, 100);
		setLocation(500, 10);
		setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof RobotModel model) {
			String text = String.format("<html>X = %.2f<br>Y = %.2f</html>", model.getRobotX(), model.getRobotY());
			coordinatesLabel.setText(text);
		}
	}

	@Override
	public String getWindowId() {
		return "Coordinates";
	}

	@Override
	public String getTitleKey() {
		return "coordinatesWindowTitle";
	}

	@Override
	public void saveState(Properties props) {
		props.setProperty(getWindowId() + ".x", String.valueOf(getX()));
		props.setProperty(getWindowId() + ".y", String.valueOf(getY()));
		props.setProperty(getWindowId() + ".width", String.valueOf(getWidth()));
		props.setProperty(getWindowId() + ".height", String.valueOf(getHeight()));
	}

	@Override
	public void loadState(Properties props) {
		int x = Integer.parseInt(props.getProperty(getWindowId() + ".x", "500"));
		int y = Integer.parseInt(props.getProperty(getWindowId() + ".y", "10"));
		int width = Integer.parseInt(props.getProperty(getWindowId() + ".width", "250"));
		int height = Integer.parseInt(props.getProperty(getWindowId() + ".height", "100"));
		setBounds(x, y, width, height);
	}
}
