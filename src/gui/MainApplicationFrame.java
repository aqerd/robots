package gui;

import entity.robots.BaseRobot;
import entity.RobotModel;
import gui.factory.Menu;
import gui.factory.Window;
import gui.windows.Coordinates;
import gui.windows.Game;
import gui.windows.Log;
import log.Logger;
import utils.LocalizationManager;
import utils.StatefulWindow;
import utils.WindowState;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainApplicationFrame extends JFrame {
	private final JDesktopPane desktopPane = new JDesktopPane();
	private final Map<String, StatefulWindow> windows = new HashMap<>();

	private RobotModel robotModel;
	private GameVisualizer visualizer;
	private Game gameWindow;
	private Coordinates coordinatesWindow;

	public MainApplicationFrame() {
		setTitle(LocalizationManager.getLocalizedText("appTitle"));

		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2);

		setContentPane(desktopPane);

		this.robotModel = new BaseRobot();

		Log logWindow = Window.createLogWindow();
		addStatefulWindow(logWindow);

		this.visualizer = new GameVisualizer(this.robotModel);
		this.gameWindow = Window.createGameWindow(this.visualizer);
		addStatefulWindow(this.gameWindow);

		this.coordinatesWindow = Window.createCoordinatesWindow(this.robotModel);
		addStatefulWindow(this.coordinatesWindow);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				closeHandler();
			}
		});

		setJMenuBar(generateMenuBar());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		WindowState.loadStates(windows);
	}

	public void setApplicationLocale(Locale locale) {
		LocalizationManager.setLocale(locale);

		setTitle(LocalizationManager.getLocalizedText("appTitle"));

		if (getJMenuBar() != null) {
			setJMenuBar(generateMenuBar());
		}

		for (StatefulWindow sw : windows.values()) {
			if (sw instanceof JInternalFrame) {
				JInternalFrame iframe = (JInternalFrame) sw;
				String titleKey = sw.getTitleKey();
				if (titleKey != null && !titleKey.isEmpty()) {
					iframe.setTitle(LocalizationManager.getLocalizedText(titleKey));
				}
			}
		}

		SwingUtilities.updateComponentTreeUI(this);
		Logger.debug(LocalizationManager.getLocalizedText("languageSwitchedLog", locale.getDisplayName(locale)));
	}

	protected void addStatefulWindow(StatefulWindow window) {
		windows.put(window.getWindowId(), window);
		desktopPane.add((JInternalFrame) window);
		((JInternalFrame) window).setVisible(true);
	}

	public void setRobotModel(RobotModel newModel) {
		if (this.gameWindow != null) {
			desktopPane.remove(this.gameWindow);
			windows.remove(this.gameWindow.getWindowId());
		}
		if (this.coordinatesWindow != null) {
			desktopPane.remove(this.coordinatesWindow);
			windows.remove(this.coordinatesWindow.getWindowId());
		}

		this.robotModel = newModel;

		this.visualizer = new GameVisualizer(this.robotModel);
		
		this.gameWindow = Window.createGameWindow(this.visualizer);
		addStatefulWindow(this.gameWindow);
		
		this.coordinatesWindow = Window.createCoordinatesWindow(this.robotModel);
		addStatefulWindow(this.coordinatesWindow);

		desktopPane.revalidate();
		desktopPane.repaint();
	}

	public void closeHandler() {
		int n = JOptionPane.showConfirmDialog(this,
				LocalizationManager.getLocalizedText("confirmExit"),
				getTitle(),
				JOptionPane.YES_NO_OPTION);
		if (n != JOptionPane.YES_OPTION)
			return;

		WindowState.saveStates(windows);
		dispose();
		System.exit(0);
	}

	private JMenuBar generateMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = Menu.createFileMenu(this);
		JMenu lookAndFeelMenu = Menu.createLookAndFeelMenu(this);
		JMenu testMenu = Menu.createTestMenu();
		JMenu langMenu = Menu.createLanguageMenu(this);
		JMenu robotMenu = Menu.createRobotMenu(this);

		menuBar.add(fileMenu);
		menuBar.add(lookAndFeelMenu);
		menuBar.add(testMenu);
		menuBar.add(langMenu);
		menuBar.add(robotMenu);

		return menuBar;
	}

	public void setLookAndFeel(String className) {
		try {
			UIManager.setLookAndFeel(className);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			Logger.error(LocalizationManager.getLocalizedText("lookAndFeelError") + ": " + e.getMessage());
		}
	}
}
