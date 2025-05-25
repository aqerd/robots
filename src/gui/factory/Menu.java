package gui.factory;

import gui.MainApplicationFrame;
import utils.JarRobotLoader;
import utils.LocalizationManager;
import log.Logger;
import entity.robots.BaseRobot;
import entity.robots.Pub;
import entity.robots.CustomImageRobot;
import java.awt.event.KeyEvent;
import java.util.Locale;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Menu {
	public static JMenu createFileMenu(MainApplicationFrame frame) {
		JMenu fileMenu = new JMenu(LocalizationManager.getLocalizedText("file"));
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem closeItem = new JMenuItem(LocalizationManager.getLocalizedText("close"), KeyEvent.VK_C);
		closeItem.addActionListener((_) -> frame.closeHandler());
		fileMenu.add(closeItem);
		return fileMenu;
	}

	public static JMenu createLookAndFeelMenu(MainApplicationFrame frame) {
		JMenu lookAndFeelMenu = new JMenu(LocalizationManager.getLocalizedText("viewMode"));
		lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);

		JMenuItem systemLookAndFeelItem = new JMenuItem(LocalizationManager.getLocalizedText("systemScheme"), KeyEvent.VK_S);
		systemLookAndFeelItem.addActionListener((_) -> {
			frame.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		});
		lookAndFeelMenu.add(systemLookAndFeelItem);

		JMenuItem crossplatformLookAndFeelItem = new JMenuItem(LocalizationManager.getLocalizedText("universalScheme"), KeyEvent.VK_U);
		crossplatformLookAndFeelItem.addActionListener((_) -> {
			frame.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		});
		lookAndFeelMenu.add(crossplatformLookAndFeelItem);

		return lookAndFeelMenu;
	}

	public static JMenu createTestMenu() {
		JMenu testMenu = new JMenu(LocalizationManager.getLocalizedText("tests"));
		testMenu.setMnemonic(KeyEvent.VK_T);
		JMenuItem addLogMessageItem = new JMenuItem(LocalizationManager.getLocalizedText("logMessage"), KeyEvent.VK_S);
		addLogMessageItem.addActionListener((_) -> Logger.debug(LocalizationManager.getLocalizedText("newLogEntry")));
		testMenu.add(addLogMessageItem);
		return testMenu;
	}

	public static JMenu createLanguageMenu(MainApplicationFrame frame) {
		JMenu languageMenu = new JMenu(LocalizationManager.getLocalizedText("language"));
		languageMenu.setMnemonic(KeyEvent.VK_L);

		for (Locale locale : LocalizationManager.getAvailableLocales()) {
			JMenuItem item = new JMenuItem(LocalizationManager.getDisplayName(locale));
			item.addActionListener(_ -> {
				frame.setApplicationLocale(locale);
			});
			languageMenu.add(item);
		}
		return languageMenu;
	}

	public static JMenu createRobotMenu(MainApplicationFrame frame) {
		JMenu robotMenu = new JMenu(LocalizationManager.getLocalizedText("robotMenuTitle"));

		JMenuItem baseRobotItem = new JMenuItem(LocalizationManager.getLocalizedText("baseRobotMenuItem"));
		baseRobotItem.addActionListener(_ -> {
			Logger.info(LocalizationManager.getLocalizedText("logSelectedBaseRobot"));
			frame.setRobotModel(new BaseRobot());
		});
		robotMenu.add(baseRobotItem);

		JMenuItem imageRobotItem = new JMenuItem(LocalizationManager.getLocalizedText("pubRobotMenuItem"));
		imageRobotItem.addActionListener(_ -> {
			Logger.info(LocalizationManager.getLocalizedText("logSelectedImageRobot"));
			frame.setRobotModel(new Pub());
		});
		robotMenu.add(imageRobotItem);

		JMenuItem loadImageRobotItem = new JMenuItem(LocalizationManager.getLocalizedText("loadImageRobotMenuItem"));
		loadImageRobotItem.addActionListener(_ -> {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle(LocalizationManager.getLocalizedText("selectImageFileDialogTitle"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
				LocalizationManager.getLocalizedText("imageFileFilterDescription"), "jpg", "png", "webp", "gif");
			fileChooser.setFileFilter(filter);
			int returnValue = fileChooser.showOpenDialog(frame);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				Logger.info(LocalizationManager.getLocalizedText("logSelectedUserImageRobot", selectedFile.getAbsolutePath()));
				frame.setRobotModel(new CustomImageRobot(selectedFile.getAbsolutePath()));
			}
		});
		robotMenu.add(loadImageRobotItem);

		JMenuItem createRobotItem = new JMenuItem(LocalizationManager.getLocalizedText("createRobotMenuItem"));
		createRobotItem.addActionListener(_ -> {
			Logger.info(LocalizationManager.getLocalizedText("logSelectedCreateRobot"));
			// TODO: Реализовать логику создания нового робота
			// Например, открыть диалоговое окно для настройки параметров робота
			// и затем создать экземпляр соответствующего класса робота.
			// frame.setRobotModel(new SomeNewRobot());
		});
		robotMenu.add(createRobotItem);

		JMenuItem loadRobotItem = new JMenuItem(LocalizationManager.getLocalizedText("loadRobotFromJarMenuItem"));
		loadRobotItem.addActionListener(_ -> {
			JarRobotLoader.loadRobotFromJar(frame);
		});
		robotMenu.add(loadRobotItem);

		return robotMenu;
	}
}
