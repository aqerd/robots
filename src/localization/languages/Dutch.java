package localization.languages;

import localization.Localizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Dutch implements Localizer {
    private static final Logger LOG = Logger.getLogger(Dutch.class.getName());
    private static final Map<String, String> texts;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("file", "Bestand");
        map.put("close", "Sluiten");
        map.put("viewMode", "Weergavemodus");
        map.put("systemScheme", "Systeemschema");
        map.put("universalScheme", "Universeel schema");
        map.put("tests", "Tests");
        map.put("logMessage", "Logbericht");
        map.put("confirmExit", "Weet u zeker dat u wilt afsluiten?");
        map.put("language", "Taal");

        map.put("appTitle", "Robots");
        map.put("logProtocolWorks", "Logprotocol werkt");
        map.put("newLogEntry", "Nieuwe logregel");
        map.put("languageSwitchedLog", "Taal gewijzigd naar: {0}");
        map.put("lookAndFeelError", "Fout bij toepassen van uiterlijk");

        map.put("logWindowTitle", "Logvenster");
        map.put("gameWindowTitle", "Spelvenster");
        map.put("coordinatesWindowTitle", "Robotcoördinaten");

        texts = Map.copyOf(map);
    }

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "klik");
        UIManager.put("AbstractDocument.additionText", "toevoegen");
        UIManager.put("AbstractDocument.deletionText", "verwijderen");
        UIManager.put("AbstractDocument.redoText", "Opnieuw");
        UIManager.put("AbstractDocument.styleChangeText", "stijlwijziging");
        UIManager.put("AbstractDocument.undoText", "Ongedaan maken");
        UIManager.put("AbstractUndoableEdit.redoText", "Opnieuw");
        UIManager.put("AbstractUndoableEdit.undoText", "Ongedaan maken");
        UIManager.put("ColorChooser.cancelText", "Annuleren");
        UIManager.put("ColorChooser.hsbBlueText", "B");
        UIManager.put("ColorChooser.hsbBrightnessText", "Helderheid");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "G");
        UIManager.put("ColorChooser.hsbHueText", "Tint");
        UIManager.put("ColorChooser.hsbMnemonic", "T");
        UIManager.put("ColorChooser.hsbNameText", "HSB");
        UIManager.put("ColorChooser.hsbRedText", "R");
        UIManager.put("ColorChooser.hsbSaturationText", "Verzadiging");
        UIManager.put("ColorChooser.okText", "OK");
        UIManager.put("ColorChooser.previewText", "Voorbeeld");
        UIManager.put("ColorChooser.resetMnemonic", "R");
        UIManager.put("ColorChooser.resetText", "Reset");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "B");
        UIManager.put("ColorChooser.rgbBlueText", "Blauw");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "G");
        UIManager.put("ColorChooser.rgbGreenText", "Groen");
        UIManager.put("ColorChooser.rgbMnemonic", "R");
        UIManager.put("ColorChooser.rgbNameText", "RGB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "R");
        UIManager.put("ColorChooser.rgbRedText", "Rood");
        UIManager.put("ColorChooser.sampleText", "Voorbeeld:");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "S");
        UIManager.put("ColorChooser.swatchesNameText", "Stalen");
        UIManager.put("ColorChooser.swatchesRecentText", "Recent:");
        UIManager.put("ComboBox.togglePopupText", "Popup wisselen");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Alle bestanden");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonText", "Annuleren");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Bestandsselectie annuleren");
        UIManager.put("FileChooser.directoryDescriptionText", "Map");
        UIManager.put("FileChooser.directoryOpenButtonMnemonic", "O");
        UIManager.put("FileChooser.directoryOpenButtonText", "Openen");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "Geselecteerde map openen");
        UIManager.put("FileChooser.fileDescriptionText", "Bestand");
        UIManager.put("FileChooser.helpButtonMnemonic", "H");
        UIManager.put("FileChooser.helpButtonText", "Help");
        UIManager.put("FileChooser.helpButtonToolTipText", "Help");
        UIManager.put("FileChooser.newFolderErrorText", "Fout bij aanmaken van nieuwe map");
        UIManager.put("FileChooser.openButtonMnemonic", "O");
        UIManager.put("FileChooser.openButtonText", "Openen");
        UIManager.put("FileChooser.openButtonToolTipText", "Geselecteerd bestand openen");
        UIManager.put("FileChooser.openDialogTitleText", "Openen");
        UIManager.put("FileChooser.saveButtonMnemonic", "S");
        UIManager.put("FileChooser.saveButtonText", "Opslaan");
        UIManager.put("FileChooser.saveButtonToolTipText", "Geselecteerd bestand opslaan");
        UIManager.put("FileChooser.saveDialogTitleText", "Opslaan");
        UIManager.put("FileChooser.updateButtonMnemonic", "U");
        UIManager.put("FileChooser.updateButtonText", "Bijwerken");
        UIManager.put("FileChooser.updateButtonToolTipText", "Bestandslijst bijwerken");
        UIManager.put("FileChooser.detailsViewActionLabelText", "Details");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Details");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Details");
        UIManager.put("FileChooser.fileAttrHeaderText", "Kenmerken");
        UIManager.put("FileChooser.fileDateHeaderText", "Gewijzigd op");
        UIManager.put("FileChooser.fileNameHeaderText", "Naam");
        UIManager.put("FileChooser.fileNameLabelText", "Bestandsnaam:");
        UIManager.put("FileChooser.fileSizeHeaderText", "Grootte");
        UIManager.put("FileChooser.fileTypeHeaderText", "Type");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Bestandstypen:");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Home");
        UIManager.put("FileChooser.homeFolderToolTipText", "Startmap");
        UIManager.put("FileChooser.listViewActionLabelText", "Lijst");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lijst");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lijst");
        UIManager.put("FileChooser.lookInLabelText", "Zoeken in:");
        UIManager.put("FileChooser.newFolderAccessibleName", "Nieuwe map");
        UIManager.put("FileChooser.newFolderActionLabelText", "Nieuwe map");
        UIManager.put("FileChooser.newFolderToolTipText", "Nieuwe map aanmaken");
        UIManager.put("FileChooser.refreshActionLabelText", "Vernieuwen");
        UIManager.put("FileChooser.saveInLabelText", "Opslaan in:");
        UIManager.put("FileChooser.upFolderAccessibleName", "Eén niveau omhoog");
        UIManager.put("FileChooser.upFolderToolTipText", "Eén niveau omhoog gaan");
        UIManager.put("FileChooser.viewMenuLabelText", "Weergave");
        UIManager.put("FormView.browseFileButtonText", "Bladeren...");
        UIManager.put("FormView.resetButtonText", "Resetten");
        UIManager.put("FormView.submitButtonText", "Verzenden");
        UIManager.put("InternalFrame.closeButtonToolTip", "Sluiten");
        UIManager.put("InternalFrame.iconButtonToolTip", "Minimaliseren");
        UIManager.put("InternalFrame.maxButtonToolTip", "Maximaliseren");
        UIManager.put("InternalFrame.restoreButtonToolTip", "Herstellen");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "Sluiten");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "Sluiten");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "Minimaliseren");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "Maximaliseren");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "Maximaliseren");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "Minimaliseren");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "Verplaatsen");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "Herstellen");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "Grootte");
        UIManager.put("MetalTitlePane.closeMnemonic", "S");
        UIManager.put("MetalTitlePane.closeTitle", "Sluiten");
        UIManager.put("MetalTitlePane.iconifyMnemonic", "M");
        UIManager.put("MetalTitlePane.iconifyTitle", "Minimaliseren");
        UIManager.put("MetalTitlePane.maximizeMnemonic", "X");
        UIManager.put("MetalTitlePane.maximizeTitle", "Maximaliseren");
        UIManager.put("MetalTitlePane.restoreMnemonic", "H");
        UIManager.put("MetalTitlePane.restoreTitle", "Herstellen");
        UIManager.put("OptionPane.cancelButtonMnemonic", "C");
        UIManager.put("OptionPane.cancelButtonText", "Annuleren");
        UIManager.put("OptionPane.inputDialogTitle", "Invoer");
        UIManager.put("OptionPane.messageDialogTitle", "Bericht");
        UIManager.put("OptionPane.noButtonMnemonic", "N");
        UIManager.put("OptionPane.noButtonText", "Nee");
        UIManager.put("OptionPane.okButtonMnemonic", "O");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.titleText", "Bericht");
        UIManager.put("OptionPane.yesButtonMnemonic", "J");
        UIManager.put("OptionPane.yesButtonText", "Ja");
        UIManager.put("PrintingDialog.abortButtonDisplayedMnemonicIndex", "0");
        UIManager.put("PrintingDialog.abortButtonMnemonic", "A");
        UIManager.put("PrintingDialog.abortButtonText", "Afbreken");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "Afdrukken onderbreken");
        UIManager.put("PrintingDialog.contentAbortingText", "Afdrukken wordt afgebroken...");
        UIManager.put("PrintingDialog.contentInitialText", "Bezig met afdrukken...");
        UIManager.put("PrintingDialog.titleProgressText", "Afdrukken");
        UIManager.put("ProgressMonitor.progressText", "Voortgang...");
        UIManager.put("SplitPane.leftButtonText", "Links");
        UIManager.put("SplitPane.rightButtonText", "Rechts");
    }
}
