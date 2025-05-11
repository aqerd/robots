package localization;


public interface Localizer {
    void apply();

    String getText(String key);
}
