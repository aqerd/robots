package gui;

import javax.swing.*;
import java.util.Properties;

public interface SavableInternalFrame {
    JInternalFrame getInternalFrame();
    void saveState(Properties props, String prefix);
    void loadState(Properties props, String prefix);
}
