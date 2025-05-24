package gui;

import log.Logger;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

public class ApplicationMenu extends JMenuBar {
	private final MainApplicationFrame mainFrame;

	public ApplicationMenu(MainApplicationFrame mainFrame) {
		this.mainFrame = mainFrame;
		add(createLookAndFeelMenu());
		add(createTestMenu());
	}

	private JMenu createLookAndFeelMenu() {
		JMenu lookAndFeelMenu = new JMenu("Режим отображения");
		lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
		lookAndFeelMenu.getAccessibleContext().setAccessibleDescription("Управление режимом отображения приложения");
		lookAndFeelMenu.add(createSystemLookAndFeelMenuItem());
		lookAndFeelMenu.add(createCrossPlatformLookAndFeelMenuItem());
		return lookAndFeelMenu;
	}

	private JMenuItem createSystemLookAndFeelMenuItem() {
		JMenuItem systemLookAndFeel = new JMenuItem("Системная схема", KeyEvent.VK_S);
		systemLookAndFeel.addActionListener((_) -> {
			setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame.invalidate();
		});
		return systemLookAndFeel;
	}

	private JMenuItem createCrossPlatformLookAndFeelMenuItem() {
		JMenuItem crossplatformLookAndFeel = new JMenuItem("Универсальная схема", KeyEvent.VK_S);
		crossplatformLookAndFeel.addActionListener((_) -> {
			setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			mainFrame.invalidate();
		});
		return crossplatformLookAndFeel;
	}

	private JMenu createTestMenu() {
		JMenu testMenu = new JMenu("Тесты");
		testMenu.setMnemonic(KeyEvent.VK_T);
		testMenu.getAccessibleContext().setAccessibleDescription("Тестовые команды");

		testMenu.add(createLogMessageMenuItem());
		return testMenu;
	}

	private JMenuItem createLogMessageMenuItem() {
		JMenuItem addLogMessageItem = new JMenuItem("Сообщение в лог", KeyEvent.VK_S);
		addLogMessageItem.addActionListener((_) -> {
			Logger.debug("Новая строка");
		});
		return addLogMessageItem;
	}

	private void setLookAndFeel(String className) {
		try {
			UIManager.setLookAndFeel(className);
			SwingUtilities.updateComponentTreeUI(mainFrame);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			Logger.error("Ошибка при установке схемы оформления: " + e.getMessage());
		}
	}
}
