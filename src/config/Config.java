package config;

import log.Logger;
import java.io.File;
import java.nio.file.Paths;

public class Config {
    public static final String CONFIG_DIR_NAME = ".robots-oop";
    public static final String USER_HOME = System.getProperty("user.home");
    public static final String CONFIG_PATH = Paths.get(USER_HOME, CONFIG_DIR_NAME).toString();
    public static final String LANGUAGES_SUBDIR = "languages";
    public static final String BUNDLE_BASE_NAME = "messages";

    public static void ensureConfigDirectoryExists() {
        File configDir = new File(CONFIG_PATH);
        if (!configDir.exists()) {
            if (configDir.mkdirs()) {
                Logger.debug("Конфигурационная директория создана: " + CONFIG_PATH);
            } else {
                Logger.error("Не удалось создать конфигурационную директорию: " + CONFIG_PATH);
            }
        }

        File languagesDir = new File(Paths.get(CONFIG_PATH, LANGUAGES_SUBDIR).toString());
        if (!languagesDir.exists()) {
            if (languagesDir.mkdirs()) {
                Logger.error("Директория для языковых файлов создана: " + languagesDir.getAbsolutePath());
            } else {
                Logger.error("Не удалось создать директорию для языковых файлов: " + languagesDir.getAbsolutePath());
            }
        }
    }

    public static String getFramesConfigPath() {
        return Paths.get(CONFIG_PATH, "frames.properties").toString();
    }
}
