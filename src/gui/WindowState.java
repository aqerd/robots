package gui;

import log.Logger;
import javax.swing.*;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import static gui.MainApplicationFrame.loadFile;

public class WindowState {
    public static void saveWindowConfiguration(JFrame mainFrame, JDesktopPane desktopPane) {
        Properties props = new Properties();
        props.setProperty("MainFrame.extendedState", String.valueOf(mainFrame.getExtendedState()));
        mainFrame.setExtendedState(JFrame.NORMAL);
        props.setProperty("MainFrame.x", String.valueOf(mainFrame.getX()));
        props.setProperty("MainFrame.y", String.valueOf(mainFrame.getY()));
        props.setProperty("MainFrame.width", String.valueOf(mainFrame.getWidth()));
        props.setProperty("MainFrame.height", String.valueOf(mainFrame.getHeight()));
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

            // TODO-DONE сделать интерфейс
            if (frame instanceof SavableInternalFrame) {
                ((SavableInternalFrame) frame).saveState(props, prefix);
            }
        }

        File configFile = loadFile();
        try (FileOutputStream fos = new FileOutputStream(configFile)) {
            props.store(fos, "Window configuration");
            Logger.debug("Конфигурация окон сохранена в " + configFile.getAbsolutePath());
        } catch (IOException e) {
            Logger.error("Ошибка сохранения конфигурации: " + e.getMessage());
        }
    }

    public static void loadWindowConfiguration(JFrame mainFrame, Properties configProperties) {
        File configFile = loadFile();
        if (!configFile.exists()) {
            Logger.debug("Конфигурационный файл отсутствует. Используются настройки по умолчанию.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(configFile)) {
            configProperties.load(fis);
            Logger.debug("Конфигурация окон загружена из " + configFile.getAbsolutePath());
        } catch (IOException e) {
            Logger.error("Ошибка загрузки конфигурации: " + e.getMessage());
            return;
        }

        configProperties.forEach((key, value) -> Logger.debug(key + " = " + value));

        try {
            int savedExtendedState = Integer.parseInt(configProperties.getProperty("MainFrame.extendedState", String.valueOf(JFrame.NORMAL)));
            int x = Integer.parseInt(configProperties.getProperty("MainFrame.x", "50"));
            int y = Integer.parseInt(configProperties.getProperty("MainFrame.y", "50"));
            int w = Integer.parseInt(configProperties.getProperty("MainFrame.width", "800"));
            int h = Integer.parseInt(configProperties.getProperty("MainFrame.height", "600"));

            mainFrame.setBounds(x, y, w, h);
            mainFrame.setExtendedState(savedExtendedState);
        } catch (NumberFormatException e) {
            Logger.error("Неверный формат данных в конфигурационном файле для главного окна: " + e.getMessage());
        }
    }

    public static void restoreInternalFramesGeometryAndState(JDesktopPane desktopPane, Properties configProperties) {
        if (configProperties == null) {
            return;
        }
        JInternalFrame[] frames = desktopPane.getAllFrames();
        for (int i = 0; i < frames.length; i++) {
            JInternalFrame frame = frames[i];
            String prefix = "frame." + frame.getClass().getSimpleName() + "." + i;

            // TODO-DONE сделать интерфейс
            try {
                int x = Integer.parseInt(configProperties.getProperty(prefix + ".x", String.valueOf(frame.getX())));
                int y = Integer.parseInt(configProperties.getProperty(prefix + ".y", String.valueOf(frame.getY())));
                int w = Integer.parseInt(configProperties.getProperty(prefix + ".width", String.valueOf(frame.getWidth())));
                int h = Integer.parseInt(configProperties.getProperty(prefix + ".height", String.valueOf(frame.getHeight())));
                frame.setBounds(x, y, w, h);
            } catch (NumberFormatException e) {
                Logger.error("Неверный формат данных для геометрии окна " + frame.getTitle() + ": " + e.getMessage());
            }

            boolean icon = Boolean.parseBoolean(configProperties.getProperty(prefix + ".icon", "false"));
            boolean maximized = Boolean.parseBoolean(configProperties.getProperty(prefix + ".maximized", "false"));
            // TODO-DONE сделать интерфейс
            try {
                frame.setMaximum(maximized);
                frame.setIcon(icon);
            } catch (PropertyVetoException | RuntimeException e) {
                Logger.error("Ошибка при восстановлении состояний окна " + frame.getTitle() + ": " + e.getMessage());
            }
            if (frame instanceof SavableInternalFrame) {
                ((SavableInternalFrame) frame).loadState(configProperties, prefix);
            }
        }
    }
}
