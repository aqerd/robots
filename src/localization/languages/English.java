package localization.languages;

import localization.Localizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class English implements Localizer {
    private static final Logger LOG = Logger.getLogger(English.class.getName());
    private static final Map<String, String> texts;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("file", "File");
        map.put("close", "Close");
        map.put("viewMode", "View Mode");
        map.put("systemScheme", "System Scheme");
        map.put("universalScheme", "Universal Scheme");
        map.put("tests", "Tests");
        map.put("logMessage", "Log Message");
        map.put("confirmExit", "Are you sure you want to exit?");
        map.put("language", "Language");

        map.put("appTitle", "Robots");
        map.put("logProtocolWorks", "Log protocol works");
        map.put("newLogEntry", "New log entry");
        map.put("languageSwitchedLog", "Language switched to: {0}");
        map.put("lookAndFeelError", "Error applying look and feel");

        map.put("logWindowTitle", "Log Window");
        map.put("gameWindowTitle", "Game Window");
        map.put("coordinatesWindowTitle", "Robot Coordinates");

        texts = Map.copyOf(map);
    }

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "click");
        UIManager.put("AbstractDocument.additionText", "addition");
        UIManager.put("AbstractDocument.deletionText", "deletion");
        UIManager.put("AbstractDocument.redoText", "Redo");
        UIManager.put("AbstractDocument.styleChangeText", "style change");
        UIManager.put("AbstractDocument.undoText", "Undo");
        UIManager.put("AbstractUndoableEdit.redoText", "Redo");
        UIManager.put("AbstractUndoableEdit.undoText", "Undo");
        UIManager.put("ColorChooser.cancelText", "Cancel");
        UIManager.put("ColorChooser.hsbBlueText", "B");
        UIManager.put("ColorChooser.hsbBrightnessText", "Brightness");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "G");
        UIManager.put("ColorChooser.hsbHueText", "Hue");
        UIManager.put("ColorChooser.hsbMnemonic", "H");
        UIManager.put("ColorChooser.hsbNameText", "HSB");
        UIManager.put("ColorChooser.hsbRedText", "R");
        UIManager.put("ColorChooser.hsbSaturationText", "Saturation");
        UIManager.put("ColorChooser.okText", "OK");
        UIManager.put("ColorChooser.previewText", "Preview");
        UIManager.put("ColorChooser.resetMnemonic", "R");
        UIManager.put("ColorChooser.resetText", "Reset");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "B");
        UIManager.put("ColorChooser.rgbBlueText", "Blue");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "G");
        UIManager.put("ColorChooser.rgbGreenText", "Green");
        UIManager.put("ColorChooser.rgbMnemonic", "R");
        UIManager.put("ColorChooser.rgbNameText", "RGB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "R");
        UIManager.put("ColorChooser.rgbRedText", "Red");
        UIManager.put("ColorChooser.sampleText", "Sample:");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "S");
        UIManager.put("ColorChooser.swatchesNameText", "Swatches");
        UIManager.put("ColorChooser.swatchesRecentText", "Recent:");
        UIManager.put("ComboBox.togglePopupText", "Toggle popup");
        UIManager.put("FileChooser.acceptAllFileFilterText", "All Files");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonText", "Cancel");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancel file selection");
        UIManager.put("FileChooser.directoryDescriptionText", "Folder");
        UIManager.put("FileChooser.directoryOpenButtonMnemonic", "O");
        UIManager.put("FileChooser.directoryOpenButtonText", "Open");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "Open selected directory");
        UIManager.put("FileChooser.fileDescriptionText", "File");
        UIManager.put("FileChooser.helpButtonMnemonic", "H");
        UIManager.put("FileChooser.helpButtonText", "Help");
        UIManager.put("FileChooser.helpButtonToolTipText", "Help");
        UIManager.put("FileChooser.newFolderErrorText", "Error creating new folder");
        UIManager.put("FileChooser.openButtonMnemonic", "O");
        UIManager.put("FileChooser.openButtonText", "Open");
        UIManager.put("FileChooser.openButtonToolTipText", "Open selected file");
        UIManager.put("FileChooser.openDialogTitleText", "Open");
        UIManager.put("FileChooser.saveButtonMnemonic", "S");
        UIManager.put("FileChooser.saveButtonText", "Save");
        UIManager.put("FileChooser.saveButtonToolTipText", "Save selected file");
        UIManager.put("FileChooser.saveDialogTitleText", "Save");
        UIManager.put("FileChooser.updateButtonMnemonic", "U");
        UIManager.put("FileChooser.updateButtonText", "Update");
        UIManager.put("FileChooser.updateButtonToolTipText", "Update file list");
        UIManager.put("FileChooser.detailsViewActionLabelText", "Details");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Details");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Details");
        UIManager.put("FileChooser.fileAttrHeaderText", "Attributes");
        UIManager.put("FileChooser.fileDateHeaderText", "Date Modified");
        UIManager.put("FileChooser.fileNameHeaderText", "Name");
        UIManager.put("FileChooser.fileNameLabelText", "File Name:");
        UIManager.put("FileChooser.fileSizeHeaderText", "Size");
        UIManager.put("FileChooser.fileTypeHeaderText", "Type");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Files of Type:");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Home");
        UIManager.put("FileChooser.homeFolderToolTipText", "Home Folder");
        UIManager.put("FileChooser.listViewActionLabelText", "List");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "List");
        UIManager.put("FileChooser.listViewButtonToolTipText", "List");
        UIManager.put("FileChooser.lookInLabelText", "Look In:");
        UIManager.put("FileChooser.newFolderAccessibleName", "New Folder");
        UIManager.put("FileChooser.newFolderActionLabelText", "New Folder");
        UIManager.put("FileChooser.newFolderToolTipText", "Create New Folder");
        UIManager.put("FileChooser.refreshActionLabelText", "Refresh");
        UIManager.put("FileChooser.saveInLabelText", "Save In:");
        UIManager.put("FileChooser.upFolderAccessibleName", "Up One Level");
        UIManager.put("FileChooser.upFolderToolTipText", "Go Up One Level");
        UIManager.put("FileChooser.viewMenuLabelText", "View");
        UIManager.put("FormView.browseFileButtonText", "Browse...");
        UIManager.put("FormView.resetButtonText", "Reset");
        UIManager.put("FormView.submitButtonText", "Submit");
        UIManager.put("InternalFrame.closeButtonToolTip", "Close");
        UIManager.put("InternalFrame.iconButtonToolTip", "Iconify");
        UIManager.put("InternalFrame.maxButtonToolTip", "Maximize");
        UIManager.put("InternalFrame.restoreButtonToolTip", "Restore");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "Close");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "Close");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "Iconify");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "Maximize");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "Maximize");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "Minimize");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "Move");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "Restore");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "Size");
        UIManager.put("MetalTitlePane.closeMnemonic", "C");
        UIManager.put("MetalTitlePane.closeTitle", "Close");
        UIManager.put("MetalTitlePane.iconifyMnemonic", "I");
        UIManager.put("MetalTitlePane.iconifyTitle", "Iconify");
        UIManager.put("MetalTitlePane.maximizeMnemonic", "M");
        UIManager.put("MetalTitlePane.maximizeTitle", "Maximize");
        UIManager.put("MetalTitlePane.restoreMnemonic", "R");
        UIManager.put("MetalTitlePane.restoreTitle", "Restore");
        UIManager.put("OptionPane.cancelButtonMnemonic", "C");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        UIManager.put("OptionPane.inputDialogTitle", "Input");
        UIManager.put("OptionPane.messageDialogTitle", "Message");
        UIManager.put("OptionPane.noButtonMnemonic", "N");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.okButtonMnemonic", "O");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.titleText", "Message");
        UIManager.put("OptionPane.yesButtonMnemonic", "Y");
        UIManager.put("OptionPane.yesButtonText", "Yes");
        UIManager.put("PrintingDialog.abortButtonDisplayedMnemonicIndex", "0");
        UIManager.put("PrintingDialog.abortButtonMnemonic", "A");
        UIManager.put("PrintingDialog.abortButtonText", "Abort");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "Abort printing");
        UIManager.put("PrintingDialog.contentAbortingText", "Aborting printing...");
        UIManager.put("PrintingDialog.contentInitialText", "Printing...");
        UIManager.put("PrintingDialog.titleProgressText", "Printing");
        UIManager.put("ProgressMonitor.progressText", "Progress...");
        UIManager.put("SplitPane.leftButtonText", "Left");
        UIManager.put("SplitPane.rightButtonText", "Right");
    }
}
