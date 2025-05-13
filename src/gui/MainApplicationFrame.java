package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
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

import localization.LocalizationManager;
import localization.Localizer;
import log.Logger;
import entity.Robot;

public class MainApplicationFrame extends JFrame {
    private final JDesktopPane desktopPane = new JDesktopPane();
    private final Map<String, StatefulWindow> windows = new HashMap<>();
    private Localizer localizer;

    public MainApplicationFrame() {
        this.localizer = LocalizationManager.getLocalizer(Locale.getDefault());
        LocalizationManager.applyLocalization(Locale.getDefault());
        setTitle(localizer.getText("appTitle"));

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
        this.localizer = LocalizationManager.getLocalizer(locale);
        LocalizationManager.applyLocalization(locale);

        setTitle(localizer.getText("appTitle"));

        if (getJMenuBar() != null) {
            setJMenuBar(generateMenuBar());
        }

        for (StatefulWindow sw : windows.values()) {
            if (sw instanceof JInternalFrame) {
                JInternalFrame iframe = (JInternalFrame) sw;
                String titleKey = sw.getTitleKey();
                if (titleKey != null && !titleKey.isEmpty()) {
                    iframe.setTitle(localizer.getText(titleKey));
                }
            }
        }

        SwingUtilities.updateComponentTreeUI(this);
        Logger.debug(MessageFormat.format(localizer.getText("languageSwitchedLog"), locale.toString()));
    }

    protected LogWindow createLogWindow() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        logWindow.setTitle(localizer.getText(logWindow.getTitleKey()));
        logWindow.setLocation(10, 10);
        logWindow.setSize(300, 800);
        Logger.debug(localizer.getText("logProtocolWorks"));
        return logWindow;
    }

    protected GameWindow createGameWindow(GameVisualizer visualizer) {
        GameWindow gameWindow = new GameWindow(visualizer);
        gameWindow.setTitle(localizer.getText(gameWindow.getTitleKey()));
        return gameWindow;
    }

    protected CoordinatesWindow createCoordinatesWindow(Robot robot) {
        CoordinatesWindow coordinatesWindow = new CoordinatesWindow(robot);
        coordinatesWindow.setTitle(localizer.getText(coordinatesWindow.getTitleKey()));
        return coordinatesWindow;
    }

    protected void addStatefulWindow(StatefulWindow window) {
        windows.put(window.getWindowId(), window);
        desktopPane.add((JInternalFrame) window);
        ((JInternalFrame) window).setVisible(true);
    }

    private void closeHandler() {
        int n = JOptionPane.showConfirmDialog(this,
                localizer.getText("confirmExit"),
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

        JMenu fileMenu = new JMenu(localizer.getText("file"));
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem close = new JMenuItem(localizer.getText("close"), KeyEvent.VK_C);
        close.addActionListener((event) -> closeHandler());
        fileMenu.add(close);

        JMenu lookAndFeelMenu = new JMenu(localizer.getText("viewMode"));
        lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
        JMenuItem systemLookAndFeel = new JMenuItem(localizer.getText("systemScheme"), KeyEvent.VK_S);
        systemLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        });
        lookAndFeelMenu.add(systemLookAndFeel);
        JMenuItem crossplatformLookAndFeel = new JMenuItem(localizer.getText("universalScheme"), KeyEvent.VK_U);
        crossplatformLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        });
        lookAndFeelMenu.add(crossplatformLookAndFeel);

        JMenu testMenu = new JMenu(localizer.getText("tests"));
        testMenu.setMnemonic(KeyEvent.VK_T);
        JMenuItem addLogMessageItem = new JMenuItem(localizer.getText("logMessage"), KeyEvent.VK_S);
        addLogMessageItem.addActionListener((event) -> Logger.debug(localizer.getText("newLogEntry")));
        testMenu.add(addLogMessageItem);

        JMenu langMenu = createLanguageMenu();

        menuBar.add(fileMenu);
        menuBar.add(lookAndFeelMenu);
        menuBar.add(testMenu);
        menuBar.add(langMenu);
        return menuBar;
    }

    private JMenu createLanguageMenu() {
        JMenu languageMenu = new JMenu(localizer.getText("language"));
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
        } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException e) {
            Logger.error(localizer.getText("lookAndFeelError") + ": " + e.getMessage());
        }
    }
}
