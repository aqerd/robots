package localization;

import localization.languages.English;
import localization.languages.French;
import localization.languages.Russian;

import java.util.*;

public class LocalizationManager {
    private static final Map<Locale, Localizer> localizers = new LinkedHashMap<>();

    static {
        register(new Locale("ru", "RU"), new Russian());
        register(new Locale("en", "US"), new English());
        register(new Locale("fr", "FR"), new French());
    }

    public static void register(Locale locale, Localizer localizer) {
        localizers.put(locale, localizer);
    }

    public static void applyLocalization(Locale locale) {
        Localizer localizer = localizers.get(locale);
        if (localizer != null) {
            localizer.apply();
        }
    }

    public static Set<Locale> getAvailableLocales() {
        return localizers.keySet();
    }

    public static String getDisplayName(Locale locale) {
        return locale.getDisplayLanguage(locale);
    }
}
