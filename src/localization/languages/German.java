package localization.languages;

import localization.Localizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class German implements Localizer {
    private static final Logger LOG = Logger.getLogger(German.class.getName());
    private static final Map<String, String> texts;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("file", "Datei");
        map.put("close", "Schließen");
        map.put("viewMode", "Ansichtsmodus");
        map.put("systemScheme", "System-Schema");
        map.put("universalScheme", "Universal-Schema");
        map.put("tests", "Tests");
        map.put("logMessage", "Protokollnachricht");
        map.put("confirmExit", "Sind Sie sicher, dass Sie beenden möchten?");
        map.put("language", "Sprache");

        map.put("appTitle", "Roboter");
        map.put("logProtocolWorks", "Protokollprotokoll funktioniert");
        map.put("newLogEntry", "Neuer Logeintrag");
        map.put("languageSwitchedLog", "Sprache gewechselt zu: {0}");
        map.put("lookAndFeelError", "Fehler beim Anwenden des Aussehens");

        map.put("logWindowTitle", "Protokollfenster");
        map.put("gameWindowTitle", "Spiel-Fenster");
        map.put("coordinatesWindowTitle", "Roboterkoordinaten");

        texts = Map.copyOf(map);
    }

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "Klicken");
        UIManager.put("AbstractDocument.additionText", "Hinzufügen");
        UIManager.put("AbstractDocument.deletionText", "Löschen");
        UIManager.put("AbstractDocument.redoText", "Wiederholen");
        UIManager.put("AbstractDocument.styleChangeText", "Stiländerung");
        UIManager.put("AbstractDocument.undoText", "Rückgängig");
        UIManager.put("AbstractUndoableEdit.redoText", "Wiederholen");
        UIManager.put("AbstractUndoableEdit.undoText", "Rückgängig");
        UIManager.put("ColorChooser.cancelText", "Abbrechen");
        UIManager.put("ColorChooser.hsbBlueText", "Blau");
        UIManager.put("ColorChooser.hsbBrightnessText", "Helligkeit");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "Grün");
        UIManager.put("ColorChooser.hsbHueText", "Farbton");
        UIManager.put("ColorChooser.hsbMnemonic", "H");
        UIManager.put("ColorChooser.hsbNameText", "HSB");
        UIManager.put("ColorChooser.hsbRedText", "Rot");
        UIManager.put("ColorChooser.hsbSaturationText", "Sättigung");
        UIManager.put("ColorChooser.okText", "OK");
        UIManager.put("ColorChooser.previewText", "Vorschau");
        UIManager.put("ColorChooser.resetMnemonic", "R");
        UIManager.put("ColorChooser.resetText", "Zurücksetzen");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "B");
        UIManager.put("ColorChooser.rgbBlueText", "Blau");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "G");
        UIManager.put("ColorChooser.rgbGreenText", "Grün");
        UIManager.put("ColorChooser.rgbMnemonic", "R");
        UIManager.put("ColorChooser.rgbNameText", "RGB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "R");
        UIManager.put("ColorChooser.rgbRedText", "Rot");
        UIManager.put("ColorChooser.sampleText", "Beispiel:");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "S");
        UIManager.put("ColorChooser.swatchesNameText", "Farben");
        UIManager.put("ColorChooser.swatchesRecentText", "Kürzlich:");
        UIManager.put("ComboBox.togglePopupText", "Popup umschalten");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Alle Dateien");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonText", "Abbrechen");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Dateiauswahl abbrechen");
        UIManager.put("FileChooser.directoryDescriptionText", "Ordner");
        UIManager.put("FileChooser.directoryOpenButtonMnemonic", "O");
        UIManager.put("FileChooser.directoryOpenButtonText", "Öffnen");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "Ausgewählten Ordner öffnen");
        UIManager.put("FileChooser.fileDescriptionText", "Datei");
        UIManager.put("FileChooser.helpButtonMnemonic", "H");
        UIManager.put("FileChooser.helpButtonText", "Hilfe");
        UIManager.put("FileChooser.helpButtonToolTipText", "Hilfe");
        UIManager.put("FileChooser.newFolderErrorText", "Fehler beim Erstellen eines neuen Ordners");
        UIManager.put("FileChooser.openButtonMnemonic", "O");
        UIManager.put("FileChooser.openButtonText", "Öffnen");
        UIManager.put("FileChooser.openButtonToolTipText", "Ausgewählte Datei öffnen");
        UIManager.put("FileChooser.openDialogTitleText", "Öffnen");
        UIManager.put("FileChooser.saveButtonMnemonic", "S");
        UIManager.put("FileChooser.saveButtonText", "Speichern");
        UIManager.put("FileChooser.saveButtonToolTipText", "Ausgewählte Datei speichern");
        UIManager.put("FileChooser.saveDialogTitleText", "Speichern");
        UIManager.put("FileChooser.updateButtonMnemonic", "U");
        UIManager.put("FileChooser.updateButtonText", "Aktualisieren");
        UIManager.put("FileChooser.updateButtonToolTipText", "Dateiliste aktualisieren");
        UIManager.put("FileChooser.detailsViewActionLabelText", "Details");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Details");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Details");
        UIManager.put("FileChooser.fileAttrHeaderText", "Attribute");
        UIManager.put("FileChooser.fileDateHeaderText", "Geändert am");
        UIManager.put("FileChooser.fileNameHeaderText", "Name");
        UIManager.put("FileChooser.fileNameLabelText", "Dateiname:");
        UIManager.put("FileChooser.fileSizeHeaderText", "Größe");
        UIManager.put("FileChooser.fileTypeHeaderText", "Typ");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Dateitypen:");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Start");
        UIManager.put("FileChooser.homeFolderToolTipText", "Startordner");
        UIManager.put("FileChooser.listViewActionLabelText", "Liste");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Liste");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Liste");
        UIManager.put("FileChooser.lookInLabelText", "Suchen in:");
        UIManager.put("FileChooser.newFolderAccessibleName", "Neuer Ordner");
        UIManager.put("FileChooser.newFolderActionLabelText", "Neuer Ordner");
        UIManager.put("FileChooser.newFolderToolTipText", "Neuen Ordner erstellen");
        UIManager.put("FileChooser.refreshActionLabelText", "Aktualisieren");
        UIManager.put("FileChooser.saveInLabelText", "Speichern in:");
        UIManager.put("FileChooser.upFolderAccessibleName", "Eine Ebene höher");
        UIManager.put("FileChooser.upFolderToolTipText", "Eine Ebene höher");
        UIManager.put("FileChooser.viewMenuLabelText", "Ansicht");
        UIManager.put("FormView.browseFileButtonText", "Durchsuchen...");
        UIManager.put("FormView.resetButtonText", "Zurücksetzen");
        UIManager.put("FormView.submitButtonText", "Absenden");
        UIManager.put("InternalFrame.closeButtonToolTip", "Schließen");
        UIManager.put("InternalFrame.iconButtonToolTip", "Minimieren");
        UIManager.put("InternalFrame.maxButtonToolTip", "Maximieren");
        UIManager.put("InternalFrame.restoreButtonToolTip", "Wiederherstellen");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "Schließen");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "Schließen");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "Minimieren");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "Maximieren");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "Maximieren");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "Minimieren");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "Verschieben");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "Wiederherstellen");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "Größe");
        UIManager.put("MetalTitlePane.closeMnemonic", "S");
        UIManager.put("MetalTitlePane.closeTitle", "Schließen");
        UIManager.put("MetalTitlePane.iconifyMnemonic", "M");
        UIManager.put("MetalTitlePane.iconifyTitle", "Minimieren");
        UIManager.put("MetalTitlePane.maximizeMnemonic", "X");
        UIManager.put("MetalTitlePane.maximizeTitle", "Maximieren");
        UIManager.put("MetalTitlePane.restoreMnemonic", "W");
        UIManager.put("MetalTitlePane.restoreTitle", "Wiederherstellen");
        UIManager.put("OptionPane.cancelButtonMnemonic", "C");
        UIManager.put("OptionPane.cancelButtonText", "Abbrechen");
        UIManager.put("OptionPane.inputDialogTitle", "Eingabe");
        UIManager.put("OptionPane.messageDialogTitle", "Nachricht");
        UIManager.put("OptionPane.noButtonMnemonic", "N");
        UIManager.put("OptionPane.noButtonText", "Nein");
        UIManager.put("OptionPane.okButtonMnemonic", "O");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.titleText", "Nachricht");
        UIManager.put("OptionPane.yesButtonMnemonic", "J");
        UIManager.put("OptionPane.yesButtonText", "Ja");
        UIManager.put("PrintingDialog.abortButtonDisplayedMnemonicIndex", "0");
        UIManager.put("PrintingDialog.abortButtonMnemonic", "A");
        UIManager.put("PrintingDialog.abortButtonText", "Abbrechen");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "Drucken abbrechen");
        UIManager.put("PrintingDialog.contentAbortingText", "Druckvorgang wird abgebrochen...");
        UIManager.put("PrintingDialog.contentInitialText", "Drucken...");
        UIManager.put("PrintingDialog.titleProgressText", "Drucken");
        UIManager.put("ProgressMonitor.progressText", "Fortschritt...");
        UIManager.put("SplitPane.leftButtonText", "Links");
        UIManager.put("SplitPane.rightButtonText", "Rechts");
    }
}
