package gui;

import log.Logger;
import entity.Robot;
import localization.LocalizationManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainApplicationFrame extends JFrame {
    private final JDesktopPane desktopPane = new JDesktopPane();
    private final Map<String, StatefulWindow> windows = new HashMap<>();

    public MainApplicationFrame() {
        setTitle(LocalizationManager.getLocalizedText("appTitle"));

        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2);

        setContentPane(desktopPane);
        Robot robotModel = new Robot();

        LogWindow logWindow = createLogWindow();
        addStatefulWindow(logWindow);

        GameVisualizer visualizer = new GameVisualizer(robotModel);
        GameWindow gameWindow = createGameWindow(visualizer);
        addStatefulWindow(gameWindow);

        CoordinatesWindow coordinatesWindow = createCoordinatesWindow(robotModel);
        addStatefulWindow(coordinatesWindow);

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

    private void setApplicationLocale(Locale locale) {
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

    protected LogWindow createLogWindow() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        logWindow.setTitle(LocalizationManager.getLocalizedText(logWindow.getTitleKey()));
        logWindow.setBounds(10, 120, 320, 640);
        Logger.debug(LocalizationManager.getLocalizedText("logProtocolWorks"));
        return logWindow;
    }

    protected GameWindow createGameWindow(GameVisualizer visualizer) {
        GameWindow gameWindow = new GameWindow(visualizer);
        gameWindow.setTitle(LocalizationManager.getLocalizedText(gameWindow.getTitleKey()));
        gameWindow.setBounds(340, 10, 1188, 750);
        return gameWindow;
    }

    protected CoordinatesWindow createCoordinatesWindow(Robot robot) {
        CoordinatesWindow coordinatesWindow = new CoordinatesWindow(robot);
        coordinatesWindow.setTitle(LocalizationManager.getLocalizedText(coordinatesWindow.getTitleKey()));
        coordinatesWindow.setBounds(10, 10, 320, 100);
        return coordinatesWindow;
    }

    protected void addStatefulWindow(StatefulWindow window) {
        windows.put(window.getWindowId(), window);
        desktopPane.add((JInternalFrame) window);
        ((JInternalFrame) window).setVisible(true);
    }

    private void closeHandler() {
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

        JMenu fileMenu = new JMenu(LocalizationManager.getLocalizedText("file"));
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem close = new JMenuItem(LocalizationManager.getLocalizedText("close"), KeyEvent.VK_C);
        close.addActionListener((event) -> closeHandler());
        fileMenu.add(close);

        JMenu lookAndFeelMenu = new JMenu(LocalizationManager.getLocalizedText("viewMode"));
        lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
        JMenuItem systemLookAndFeel = new JMenuItem(LocalizationManager.getLocalizedText("systemScheme"), KeyEvent.VK_S);
        systemLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        });
        lookAndFeelMenu.add(systemLookAndFeel);
        JMenuItem crossplatformLookAndFeel = new JMenuItem(LocalizationManager.getLocalizedText("universalScheme"), KeyEvent.VK_U);
        crossplatformLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        });
        lookAndFeelMenu.add(crossplatformLookAndFeel);

        JMenu testMenu = new JMenu(LocalizationManager.getLocalizedText("tests"));
        testMenu.setMnemonic(KeyEvent.VK_T);
        JMenuItem addLogMessageItem = new JMenuItem(LocalizationManager.getLocalizedText("logMessage"), KeyEvent.VK_S);
        addLogMessageItem.addActionListener((event) -> Logger.debug(LocalizationManager.getLocalizedText("newLogEntry")));
        testMenu.add(addLogMessageItem);

        JMenu langMenu = createLanguageMenu();

        menuBar.add(fileMenu);
        menuBar.add(lookAndFeelMenu);
        menuBar.add(testMenu);
        menuBar.add(langMenu);
        return menuBar;
    }

    private JMenu createLanguageMenu() {
        JMenu languageMenu = new JMenu(LocalizationManager.getLocalizedText("language"));
        languageMenu.setMnemonic(KeyEvent.VK_L);

        for (Locale locale : LocalizationManager.getAvailableLocales()) {
            JMenuItem item = new JMenuItem(LocalizationManager.getDisplayName(locale));
            item.addActionListener(event -> {
                setApplicationLocale(locale);
            });
            languageMenu.add(item);
        }
        return languageMenu;
    }

    private void setLookAndFeel(String className) {
        try {
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            Logger.error(LocalizationManager.getLocalizedText("lookAndFeelError") + ": " + e.getMessage());
        }
    }
}
