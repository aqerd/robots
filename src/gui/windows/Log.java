package gui.windows;

import log.LogChangeListener;
import log.LogEntry;
import log.LogWindowSource;
import utils.StatefulWindow;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class Log extends JInternalFrame implements LogChangeListener, StatefulWindow {
	private LogWindowSource m_logSource;
	private TextArea m_logContent;

	public Log(LogWindowSource logSource) {
		super("", true, true, true, true);
		m_logSource = logSource;
		m_logSource.registerListener(this);
		m_logContent = new TextArea("");
		m_logContent.setSize(200, 500);

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(m_logContent, BorderLayout.CENTER);
		getContentPane().add(panel);
		pack();
		updateLogContent();
	}

	private void updateLogContent() {
		StringBuilder content = new StringBuilder();
		for (LogEntry entry : m_logSource.all()) {
			content.append(entry.getMessage()).append("\n");
		}
		m_logContent.setText(content.toString());
		m_logContent.invalidate();
	}

	@Override
	public void onLogChanged() {
		EventQueue.invokeLater(this::updateLogContent);
	}

	@Override
	public String getWindowId() {
		return "Log";
	}

	@Override
	public String getTitleKey() {
		return "logWindowTitle";
	}

	@Override
	public void saveState(Properties props) {
		props.setProperty(getWindowId() + ".x", String.valueOf(getX()));
		props.setProperty(getWindowId() + ".y", String.valueOf(getY()));
		props.setProperty(getWindowId() + ".width", String.valueOf(getWidth()));
		props.setProperty(getWindowId() + ".height", String.valueOf(getHeight()));
		props.setProperty(getWindowId() + ".isIcon", String.valueOf(isIcon()));
		props.setProperty(getWindowId() + ".isMaximum", String.valueOf(isMaximum()));
	}

	@Override
	public void loadState(Properties props) {
		int x = Integer.parseInt(props.getProperty(getWindowId() + ".x", "10"));
		int y = Integer.parseInt(props.getProperty(getWindowId() + ".y", "10"));
		int width = Integer.parseInt(props.getProperty(getWindowId() + ".width", "300"));
		int height = Integer.parseInt(props.getProperty(getWindowId() + ".height", "500"));
		boolean isIcon = Boolean.parseBoolean(props.getProperty(getWindowId() + ".isIcon", "false"));
		boolean isMaximum = Boolean.parseBoolean(props.getProperty(getWindowId() + ".isMaximum", "false"));

		setBounds(x, y, width, height);
		try {
			setIcon(isIcon);
			if (isMaximum) {
				setMaximum(true);
			}
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
}
