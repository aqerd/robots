package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import log.Logger;
import entity.Robot;

public class MainApplicationFrame extends JFrame {
    private final JDesktopPane desktopPane = new JDesktopPane();
    private final Map<String, StatefulWindow> windows = new HashMap<>();

    public MainApplicationFrame() {
        LocalizationManager.applyLocalization(Locale.getDefault());

        int inset = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset,
                screenSize.width - inset * 2,
                screenSize.height - inset * 2);

        setContentPane(desktopPane);
        Robot robotModel = new Robot();
        LogWindow logWindow = createLogWindow();
        addStatefulWindow(logWindow);

        // Создание и добавление окна с визуализацией игры
        GameVisualizer visualizer = new GameVisualizer(robotModel);
        GameWindow gameWindow = new GameWindow(visualizer);
        addStatefulWindow(gameWindow);

        // Создание и добавление окна с координатами робота
        CoordinatesWindow coordinatesWindow = new CoordinatesWindow(robotModel);
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

    protected LogWindow createLogWindow() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        logWindow.setLocation(10, 10);
        logWindow.setSize(300, 800);
        Logger.debug("Протокол работает");
        return logWindow;
    }

    protected void addStatefulWindow(StatefulWindow window) {
        windows.put(window.getWindowId(), window);
        desktopPane.add((JInternalFrame) window);
        ((JInternalFrame) window).setVisible(true);
    }

    private void closeHandler() {
        int n = JOptionPane.showConfirmDialog(this, "Вы уверены, что хотите выйти?", getTitle(), JOptionPane.YES_NO_OPTION);
        if (n != JOptionPane.YES_OPTION)
            return;

        WindowState.saveStates(windows);
        dispose();
        System.exit(0);
    }

    private JMenuBar generateMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem close = new JMenuItem("Закрыть", KeyEvent.VK_C);
        close.addActionListener((event) -> closeHandler());
        fileMenu.add(close);

        JMenu lookAndFeelMenu = new JMenu("Режим отображения");
        lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
        JMenuItem systemLookAndFeel = new JMenuItem("Системная схема", KeyEvent.VK_S);
        systemLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            this.invalidate();
        });
        lookAndFeelMenu.add(systemLookAndFeel);
        JMenuItem crossplatformLookAndFeel = new JMenuItem("Универсальная схема", KeyEvent.VK_U);
        crossplatformLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            this.invalidate();
        });
        lookAndFeelMenu.add(crossplatformLookAndFeel);

        JMenu testMenu = new JMenu("Тесты");
        testMenu.setMnemonic(KeyEvent.VK_T);
        JMenuItem addLogMessageItem = new JMenuItem("Сообщение в лог", KeyEvent.VK_S);
        addLogMessageItem.addActionListener((event) -> Logger.debug("Новая строка"));
        testMenu.add(addLogMessageItem);

        JMenu langMenu = createLanguageMenu();

        menuBar.add(fileMenu);
        menuBar.add(lookAndFeelMenu);
        menuBar.add(testMenu);
        menuBar.add(langMenu);
        return menuBar;
    }

    private JMenu createLanguageMenu() {
        JMenu languageMenu = new JMenu("Language");
        languageMenu.setMnemonic(KeyEvent.VK_L);

        for (Locale locale : LocalizationManager.getAvailableLocales()) {
            JMenuItem item = new JMenuItem(LocalizationManager.getDisplayName(locale));
            item.addActionListener(event -> {
                LocalizationManager.applyLocalization(locale);
                SwingUtilities.updateComponentTreeUI(this);
                Logger.debug("Language switched: " + locale);
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
            // just ignore
        }
    }
}