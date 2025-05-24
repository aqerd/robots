package utils;

import java.util.Properties;

public interface StatefulWindow {
	String getWindowId();
	String getTitleKey();
	void saveState(Properties props);
	void loadState(Properties props);
}
