package gui.factory;

import entity.robots.RobotModel;
import gui.GameVisualizer;
import gui.windows.Coordinates;
import gui.windows.Game;
import gui.windows.Log;
import log.Logger;
import utils.LocalizationManager;

public class Window {
	public static Log createLogWindow() {
		Log logWindow = new Log(Logger.getDefaultLogSource());
		logWindow.setTitle(LocalizationManager.getLocalizedText(logWindow.getTitleKey()));
		logWindow.setBounds(0, 100, 320, 640);
		Logger.debug(LocalizationManager.getLocalizedText("logProtocolWorks"));
		return logWindow;
	}

	public static Game createGameWindow(GameVisualizer visualizer) {
		Game gameWindow = new Game(visualizer);
		gameWindow.setTitle(LocalizationManager.getLocalizedText(gameWindow.getTitleKey()));
		gameWindow.setBounds(320, 0, 1188, 750);
		return gameWindow;
	}

	public static Coordinates createCoordinatesWindow(RobotModel robot) {
		Coordinates coordinatesWindow = new Coordinates(robot);
		coordinatesWindow.setTitle(LocalizationManager.getLocalizedText(coordinatesWindow.getTitleKey()));
		coordinatesWindow.setBounds(0, 0, 320, 100);
		return coordinatesWindow;
	}
}