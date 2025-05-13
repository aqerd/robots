package localization;

import localization.languages.*;

import java.util.*;

public class LocalizationManager {
    private static final Map<Locale, Localizer> localizers = new LinkedHashMap<>();

    static {
        register(new Locale("en", "US"), new English());
        register(new Locale("ru", "RU"), new Russian());
        register(new Locale("ar", "SA"), new Arabic());
        register(new Locale("zh", "CN"), new Chinese());
        register(new Locale("nl", "NL"), new Dutch());
        register(new Locale("fr", "FR"), new French());
        register(new Locale("de", "DE"), new German());
        register(new Locale("ja", "JP"), new Japanese());
        register(new Locale("ko", "KR"), new Korean());
        register(new Locale("pt", "BR"), new Portuguese());
        register(new Locale("es", "ES"), new Spanish());
    }

    public static void register(Locale locale, Localizer localizer) {
        localizers.put(locale, localizer);
    }

    public static Localizer getLocalizer(Locale locale) {
        return localizers.get(locale);
    }

    public static void applyLocalization(Locale locale) {
        Localizer localizer = getLocalizer(locale);
        if (localizer != null) {
            localizer.apply();
        }
    }

    public static Set<Locale> getAvailableLocales() {
        return localizers.keySet();
    }

    public static String getDisplayName(Locale locale) {
        return locale.getDisplayLanguage(locale).substring(0, 1).toUpperCase() + locale.getDisplayLanguage(locale).substring(1);
    }
}
