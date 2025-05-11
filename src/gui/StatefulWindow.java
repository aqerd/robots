package gui;

import java.util.Properties;

public interface StatefulWindow {
    String getWindowId();
    void saveState(Properties props);
    void loadState(Properties props);
}