package gui;

import log.Logger;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.*;
import javax.swing.*;
import static java.lang.Math.round;
import java.util.Locale;

public class MainApplicationFrame extends JFrame {
    private final JDesktopPane desktopPane = new JDesktopPane();
    private int oldWidth = -1;
    private int oldHeight = -1;

    public MainApplicationFrame() {
        setRussianLocale();
        int inset = 50;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        Rectangle screenBounds = gd.getDefaultConfiguration().getBounds();
        Dimension screenSize = new Dimension(screenBounds.width, screenBounds.height);
        setBounds(inset, inset, screenSize.width, screenSize.height);
        setContentPane(desktopPane);

        GameWindow gameWindow = new GameWindow();
        gameWindow.setSize(screenSize.width, screenSize.height);
        addWindow(gameWindow);
        LogWindow logWindow = createLogWindow();
        addWindow(logWindow);

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

    // TODO Попробовать разобраться, как все стандартные предопределенные компоненты заставить работать на русском языке
    private void setRussianLocale() {
        Locale.setDefault(new Locale("ru", "RU"));
        // TODO Cделать так, чтобы диалог на основе JOptionPane выдавал текст на кнопках на русском языке
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
                Logger.debug("Размер desktopPane некорректен или ещё не инициализирован!");
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
        logWindow.setSize(300, 800);
        setMinimumSize(logWindow.getSize());
        logWindow.pack();
        Logger.debug("Протокол работает");
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
        systemLookAndFeel.addActionListener((event) -> {
            setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            this.invalidate();
        });
        return systemLookAndFeel;
    }

    JMenuItem createCrossPlatformLookAndFeelMenuItem() {
        JMenuItem crossplatformLookAndFeel = new JMenuItem("Универсальная схема", KeyEvent.VK_S);
        crossplatformLookAndFeel.addActionListener((event) -> {
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
        addLogMessageItem.addActionListener((event) -> {
            Logger.debug("Строка для логирования");
        });
        return addLogMessageItem;
    }

    // TODO Требуется добавить пункт меню, позволяющий закрыть приложение;
    private JMenu createApplicationMenu() {
        JMenu appMenu = new JMenu("Приложение");
        appMenu.setMnemonic(KeyEvent.VK_A);
        JMenuItem exitItem = new JMenuItem("Выход", KeyEvent.VK_Q);
        exitItem.setToolTipText("Закрыть приложение");
        exitItem.addActionListener((event) -> handleExit());
        appMenu.add(exitItem);
        return appMenu;
    }

    // TODO требуется собрать обработку события выхода из приложения в один метод и сделать так, чтобы в этом методе выдавался запрос на подтверждение выхода
    private void handleExit() {
        int result = JOptionPane.showConfirmDialog(
                this,
                "Вы действительно хотите выйти из приложения?",
                "Подтверждение выхода",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void setLookAndFeel(String className) {
        try {
            UIManager.setLookAndFeel(className);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException
                 | IllegalAccessException | UnsupportedLookAndFeelException e) {
            Logger.error("Ошибка при установке схемы оформления: " + e.getMessage());
        }
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }
}