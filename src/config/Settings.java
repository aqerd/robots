package config;

import log.Logger;
import java.io.File;
import java.nio.file.Paths;
import utils.LocalizationManager;

public class Settings {
	public static final String RESOURCES_DIR_NAME = "resources";
	public static final String LANGUAGES_SUBDIR = "languages";
	public static final String BUNDLE_BASE_NAME = "messages";

	public static void ensureConfigDirectoryExists() {
		File resourcesDir = new File(RESOURCES_DIR_NAME);
		String resAbsPath = resourcesDir.getAbsolutePath();
		if (!resourcesDir.exists()) {
			if (resourcesDir.mkdirs()) {
				Logger.debug(LocalizationManager.getLocalizedText("resourcesDirCreated", resAbsPath));
			} else {
				Logger.error(LocalizationManager.getLocalizedText("resourcesDirCreationFailed", resAbsPath));
			}
		}

		File languagesDir = new File(Paths.get(RESOURCES_DIR_NAME, LANGUAGES_SUBDIR).toString());
		String langAbsPath = languagesDir.getAbsolutePath();
		if (!languagesDir.exists()) {
			if (languagesDir.mkdirs()) {
				Logger.debug(LocalizationManager.getLocalizedText("languagesDirCreated", langAbsPath));
			} else {
				Logger.error(LocalizationManager.getLocalizedText("languagesDirCreationFailed", langAbsPath));
			}
		}
	}

	public static String getFramesConfigPath() {
		return Paths.get(RESOURCES_DIR_NAME, "frames.properties").toString();
	}
}
