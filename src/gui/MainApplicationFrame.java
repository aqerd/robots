package gui;

import log.Logger;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Properties;
import static java.lang.Math.round;

public class MainApplicationFrame extends JFrame {
    private final JDesktopPane desktopPane = new JDesktopPane();
    private int oldWidth = -1;
    private int oldHeight = -1;
    private static final String USER_HOME = System.getProperty("user.home");
    private static final String CONFIG_ROOT = ".robots-oop";
    private static final String CONFIG_FILE_NAME = "state-save.properties";
    private Properties configProperties;

    public MainApplicationFrame() {
        setRussianLocale();
        int inset = 500;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        Rectangle screenBounds = gd.getDefaultConfiguration().getBounds();
        Dimension screenSize = new Dimension(screenBounds.width, screenBounds.height);
        setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2);
        setContentPane(desktopPane);
        loadWindowConfiguration();
        GameWindow gameWindow = new GameWindow();
        addWindow(gameWindow);
        LogWindow logWindow = createLogWindow();
        addWindow(logWindow);
        restoreInternalFramesGeometry();
        setJMenuBar(generateMenuBar());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeInternalFrames();
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                handleExit();
            }
        });
    }

    private void setRussianLocale() {
        Locale.setDefault(new Locale("ru", "RU"));
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.cancelButtonText", "Отмена");
        UIManager.put("OptionPane.okButtonText", "ОК");
        UIManager.put("FileChooser.openDialogTitleText", "Открыть файл");
        UIManager.put("FileChooser.saveDialogTitleText", "Сохранить файл");
        UIManager.put("FileChooser.cancelButtonText", "Отмена");
        UIManager.put("FileChooser.openButtonText", "Открыть");
        UIManager.put("FileChooser.saveButtonText", "Сохранить");
        UIManager.put("FileChooser.lookInLabelText", "Смотреть в");
        UIManager.put("FileChooser.fileNameLabelText", "Имя файла");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Тип файлов");
        UIManager.put("FileChooser.upFolderToolTipText", "На уровень выше");
        UIManager.put("FileChooser.homeFolderToolTipText", "Домой");
        UIManager.put("FileChooser.newFolderToolTipText", "Новая папка");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Список");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Детали");
    }

    void resizeInternalFrames() {
        SwingUtilities.invokeLater(() -> {
            int width = desktopPane.getWidth();
            int height = desktopPane.getHeight();

            if (width == 0 || height == 0 || oldWidth <= 0 || oldHeight <= 0) {
                Logger.debug("Размер desktopPane некорректен или не инициализирован.");
                oldWidth = width;
                oldHeight = height;
                return;
            }
            Logger.debug("Изменяем размеры окон: (" + width + ", " + height + ")");

            for (JInternalFrame frame : desktopPane.getAllFrames()) {
                double widthRatio = (double) frame.getWidth() / oldWidth;
                double heightRatio = (double) frame.getHeight() / oldHeight;
                double xRatio = (double) frame.getX() / oldWidth;
                double yRatio = (double) frame.getY() / oldHeight;

                int newWidth = (int) round(width * widthRatio);
                int newHeight = (int) round(height * heightRatio);
                int newX = (int) round(width * xRatio);
                int newY = (int) round(height * yRatio);

                newWidth = Math.min(newWidth, width - newX);
                newHeight = Math.min(newHeight, height - newY);

                frame.setBounds(newX, newY, newWidth, newHeight);
                frame.revalidate();
                frame.repaint();
            }

            oldWidth = width;
            oldHeight = height;

            desktopPane.revalidate();
            desktopPane.repaint();
        });
    }

    protected LogWindow createLogWindow() {
        LogWindow logWindow = new LogWindow(Logger.getDefaultLogSource());
        logWindow.setLocation(10, 10);
        logWindow.setSize(300, 300);
        setMinimumSize(logWindow.getSize());
        logWindow.pack();
        Logger.debug("Протокол инициализирован.");
        return logWindow;
    }

    protected void addWindow(JInternalFrame frame) {
        desktopPane.add(frame);
        frame.setVisible(true);
    }

    JMenuBar generateMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createLookAndFeelMenu());
        menuBar.add(createTestMenu());
        menuBar.add(createApplicationMenu());
        return menuBar;
    }

    private JMenu createLookAndFeelMenu() {
        JMenu lookAndFeelMenu = new JMenu("Режим отображения");
        lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
        lookAndFeelMenu.getAccessibleContext().setAccessibleDescription("Управление режимом отображения приложения");

        lookAndFeelMenu.add(createSystemLookAndFeelMenuItem());
        lookAndFeelMenu.add(createCrossPlatformLookAndFeelMenuItem());
        return lookAndFeelMenu;
    }

    JMenuItem createSystemLookAndFeelMenuItem() {
        JMenuItem systemLookAndFeel = new JMenuItem("Системная схема", KeyEvent.VK_S);
        systemLookAndFeel.addActionListener(e -> {
            setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            this.invalidate();
        });
        return systemLookAndFeel;
    }

    JMenuItem createCrossPlatformLookAndFeelMenuItem() {
        JMenuItem crossplatformLookAndFeel = new JMenuItem("Универсальная схема", KeyEvent.VK_S);
        crossplatformLookAndFeel.addActionListener(e -> {
            setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            this.invalidate();
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

    JMenuItem createLogMessageMenuItem() {
        JMenuItem addLogMessageItem = new JMenuItem("Сообщение в лог", KeyEvent.VK_S);
        addLogMessageItem.addActionListener(e -> Logger.debug("Строка для логирования"));
        return addLogMessageItem;
    }

    private JMenu createApplicationMenu() {
        JMenu appMenu = new JMenu("Приложение");
        appMenu.setMnemonic(KeyEvent.VK_A);
        JMenuItem exitItem = new JMenuItem("Выход", KeyEvent.VK_Q);
        exitItem.setToolTipText("Закрыть приложение");
        exitItem.addActionListener(e -> handleExit());
        appMenu.add(exitItem);
        return appMenu;
    }

    private void handleExit() {
        int result = JOptionPane.showConfirmDialog(
                this,
                "Вы действительно хотите выйти из приложения?",
                "Подтверждение выхода",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (result == JOptionPane.YES_OPTION) {
            saveWindowConfiguration();
            System.exit(0); // TODO сделать безопаснее
        }
    }

    private void setLookAndFeel(String className) {
        try {
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            Logger.error("Ошибка при установке схемы оформления: " + e.getMessage());
        }
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public static File loadFile() {
        Path configDir = Paths.get(USER_HOME, CONFIG_ROOT);
        Path configFilePath = configDir.resolve(CONFIG_FILE_NAME);
        File configFile = configFilePath.toFile();

        if (!configDir.toFile().exists()) {
            boolean created = configDir.toFile().mkdirs();
            if (!created) {
                Logger.error("Не удалось создать директорию: " + configDir);
            }
        }
        return configFile;
    }

    private void saveWindowConfiguration() {
        Properties props = new Properties();

        props.setProperty("MainFrame.extendedState", String.valueOf(getExtendedState()));

        setExtendedState(JFrame.NORMAL);
        props.setProperty("MainFrame.x", String.valueOf(getX()));
        props.setProperty("MainFrame.y", String.valueOf(getY()));
        props.setProperty("MainFrame.width", String.valueOf(getWidth()));
        props.setProperty("MainFrame.height", String.valueOf(getHeight()));

        JInternalFrame[] frames = desktopPane.getAllFrames();
        for (int i = 0; i < frames.length; i++) {
            JInternalFrame frame = frames[i];
            String prefix = "frame." + frame.getClass().getSimpleName() + "." + i;
            props.setProperty(prefix + ".x", String.valueOf(frame.getX()));
            props.setProperty(prefix + ".y", String.valueOf(frame.getY()));
            props.setProperty(prefix + ".width", String.valueOf(frame.getWidth()));
            props.setProperty(prefix + ".height", String.valueOf(frame.getHeight()));

            boolean isIconified = false;
            boolean isMaximized = false;
            try {
                isIconified = frame.isIcon();
                isMaximized = frame.isMaximum();
            } catch (Exception e) {
                Logger.error("Ошибка при считывании состояний окна " + frame.getTitle() + ": " + e.getMessage());
            }
            props.setProperty(prefix + ".icon", String.valueOf(isIconified));
            props.setProperty(prefix + ".maximized", String.valueOf(isMaximized));
        }

        File configFile = loadFile();
        try (FileOutputStream fos = new FileOutputStream(configFile)) {
            props.store(fos, "Window configuration");
            Logger.debug("Конфигурация окон сохранена в " + configFile.getAbsolutePath());
        } catch (IOException e) {
            Logger.error("Ошибка сохранения конфигурации: " + e.getMessage());
        }
    }

    private void loadWindowConfiguration() {
        File configFile = loadFile();
        if (!configFile.exists()) {
            Logger.debug("Конфигурационный файл отсутствует. Используются настройки по умолчанию.");
            return;
        }

        configProperties = new Properties();
        try (FileInputStream fis = new FileInputStream(configFile)) {
            configProperties.load(fis);
            Logger.debug("Конфигурация окон загружена из " + configFile.getAbsolutePath());
        } catch (IOException e) {
            Logger.error("Ошибка загрузки конфигурации: " + e.getMessage());
            return;
        }

        try {
            int savedExtendedState = Integer.parseInt(configProperties.getProperty("MainFrame.extendedState", String.valueOf(JFrame.NORMAL)));
            int x = Integer.parseInt(configProperties.getProperty("MainFrame.x", "50"));
            int y = Integer.parseInt(configProperties.getProperty("MainFrame.y", "50"));
            int w = Integer.parseInt(configProperties.getProperty("MainFrame.width", "800"));
            int h = Integer.parseInt(configProperties.getProperty("MainFrame.height", "600"));

            setBounds(x, y, w, h);
            setExtendedState(savedExtendedState);
        } catch (NumberFormatException e) {
            Logger.error("Неверный формат данных в конфигурационном файле: " + e.getMessage());
        }
    }

    private void restoreInternalFramesGeometry() {
        if (configProperties == null) {
            return;
        }
        JInternalFrame[] frames = desktopPane.getAllFrames();
        for (int i = 0; i < frames.length; i++) {
            JInternalFrame frame = frames[i];
            String prefix = "frame." + frame.getClass().getSimpleName() + "." + i;

            int x = Integer.parseInt(configProperties.getProperty(prefix + ".x", "100"));
            int y = Integer.parseInt(configProperties.getProperty(prefix + ".y", "100"));
            int w = Integer.parseInt(configProperties.getProperty(prefix + ".width", "400"));
            int h = Integer.parseInt(configProperties.getProperty(prefix + ".height", "300"));

            frame.setBounds(x, y, w, h);

            boolean icon = Boolean.parseBoolean(configProperties.getProperty(prefix + ".icon", "false"));
            boolean maximized = Boolean.parseBoolean(configProperties.getProperty(prefix + ".maximized", "false"));
            try {
                frame.setIcon(icon);
                frame.setMaximum(maximized);
            } catch (Exception e) {
                Logger.error("Ошибка при восстановлении состояний окна " + frame.getTitle() + ": " + e.getMessage());
            }
        }
    }
}
