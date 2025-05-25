package utils;

import config.Settings;
import log.Logger;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.MissingResourceException;
import java.util.concurrent.ConcurrentHashMap;

public class LocalizationManager {
	private static Locale currentLocale = Locale.getDefault();
	private static ResourceBundle bundle;
	private static final Map<String, MessageFormat> messageFormatCache = new ConcurrentHashMap<>();

	private static final List<Locale> AVAILABLE_LOCALES = List.of(
		new Locale("en", "US"),
		new Locale("ru", "RU"),
		new Locale("ar", "SA"),
		new Locale("zh", "CN"),
		new Locale("fr", "FR"),
		new Locale("es", "ES")
	);

	static {
		Settings.ensureConfigDirectoryExists();
		setLocale(currentLocale);
	}

	public static void setLocale(Locale locale) {
		currentLocale = locale;
		messageFormatCache.clear();
		try {
			File languageDir = new File(Settings.RESOURCES_DIR_NAME, Settings.LANGUAGES_SUBDIR);
			URL[] urls = {languageDir.toURI().toURL()};
			ClassLoader loader = new URLClassLoader(urls);
			bundle = ResourceBundle.getBundle(Settings.BUNDLE_BASE_NAME, currentLocale, loader);
			Logger.debug("ResourceBundle for " + getDisplayName(currentLocale) + " is loaded");
		} catch (Exception e) {
			Logger.error("Error loading resource bundle for locale " + locale + " (" + getDisplayName(locale) + "): " + e.getMessage());
		}
	}

	public static String getLocalizedText(String key, Object... params) {
		if (bundle == null) {
			Logger.error("ResourceBundle is not loaded. Cannot get text for key: " + key);
			return key;
		}
		try {
			String pattern = bundle.getString(key);
			if (params.length == 0) {
				return pattern;
			}
			MessageFormat messageFormat = messageFormatCache.computeIfAbsent(pattern, p -> new MessageFormat(p, currentLocale));
			return messageFormat.format(params);
		} catch (MissingResourceException e) {
			Logger.error("Missing resource for key: " + key + " in locale: " + currentLocale + " (" + getDisplayName(currentLocale) + ")");
			return key;
		} catch (IllegalArgumentException e) {
			Logger.error("Invalid format for key: " + key + " or incorrect arguments provided. Error: " + e.getMessage());
			return key;
		}
	}

	public static List<Locale> getAvailableLocales() {
		return AVAILABLE_LOCALES;
	}

	public static String getDisplayName(Locale locale) {
		String displayName = locale.getDisplayLanguage(locale);
		if (displayName.isEmpty()) {
			return locale.toString();
		}
		return displayName.substring(0, 1).toUpperCase(locale) + displayName.substring(1);
	}
}
