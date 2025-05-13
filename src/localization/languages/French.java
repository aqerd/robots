package localization.languages;

import localization.Localizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class French implements Localizer {
    private static final Logger LOG = Logger.getLogger(French.class.getName());
    private static final Map<String, String> texts;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("file", "Fichier");
        map.put("close", "Fermer");
        map.put("viewMode", "Mode d'affichage");
        map.put("systemScheme", "Thème système");
        map.put("universalScheme", "Thème universel");
        map.put("tests", "Tests");
        map.put("logMessage", "Message du journal");
        map.put("confirmExit", "Êtes-vous sûr de vouloir quitter ?");
        map.put("language", "Langue");

        map.put("appTitle", "Robots");
        map.put("logProtocolWorks", "Le protocole du journal fonctionne");
        map.put("newLogEntry", "Nouvelle entrée de journal");
        map.put("languageSwitchedLog", "Langue changée en : {0}");
        map.put("lookAndFeelError", "Erreur lors de l'application du thème");

        map.put("logWindowTitle", "Fenêtre du journal");
        map.put("gameWindowTitle", "Fenêtre de jeu");
        map.put("coordinatesWindowTitle", "Coordonnées du robot");

        texts = Map.copyOf(map);
    }

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "clic");
        UIManager.put("AbstractDocument.additionText", "ajout");
        UIManager.put("AbstractDocument.deletionText", "suppression");
        UIManager.put("AbstractDocument.redoText", "Rétablir");
        UIManager.put("AbstractDocument.styleChangeText", "changement de style");
        UIManager.put("AbstractDocument.undoText", "Annuler");
        UIManager.put("AbstractUndoableEdit.redoText", "Rétablir");
        UIManager.put("AbstractUndoableEdit.undoText", "Annuler");
        UIManager.put("ColorChooser.cancelText", "Annuler");
        UIManager.put("ColorChooser.hsbBlueText", "B");
        UIManager.put("ColorChooser.hsbBrightnessText", "Luminosité");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "V");
        UIManager.put("ColorChooser.hsbHueText", "Teinte");
        UIManager.put("ColorChooser.hsbMnemonic", "T");
        UIManager.put("ColorChooser.hsbNameText", "TSL");
        UIManager.put("ColorChooser.hsbRedText", "R");
        UIManager.put("ColorChooser.hsbSaturationText", "Saturation");
        UIManager.put("ColorChooser.okText", "OK");
        UIManager.put("ColorChooser.previewText", "Aperçu");
        UIManager.put("ColorChooser.resetMnemonic", "R");
        UIManager.put("ColorChooser.resetText", "Réinitialiser");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "B");
        UIManager.put("ColorChooser.rgbBlueText", "Bleu");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "V");
        UIManager.put("ColorChooser.rgbGreenText", "Vert");
        UIManager.put("ColorChooser.rgbMnemonic", "R");
        UIManager.put("ColorChooser.rgbNameText", "RVB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "R");
        UIManager.put("ColorChooser.rgbRedText", "Rouge");
        UIManager.put("ColorChooser.sampleText", "Échantillon :");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "P");
        UIManager.put("ColorChooser.swatchesNameText", "Palettes");
        UIManager.put("ColorChooser.swatchesRecentText", "Récentes :");
        UIManager.put("ComboBox.togglePopupText", "Afficher/Masquer la liste");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Tous les fichiers");
        UIManager.put("FileChooser.cancelButtonMnemonic", "A");
        UIManager.put("FileChooser.cancelButtonText", "Annuler");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Annuler la sélection du fichier");
        UIManager.put("FileChooser.directoryDescriptionText", "Dossier");
        UIManager.put("FileChooser.directoryOpenButtonMnemonic", "O");
        UIManager.put("FileChooser.directoryOpenButtonText", "Ouvrir");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "Ouvrir le dossier sélectionné");
        UIManager.put("FileChooser.fileDescriptionText", "Fichier");
        UIManager.put("FileChooser.helpButtonMnemonic", "D");
        UIManager.put("FileChooser.helpButtonText", "Aide");
        UIManager.put("FileChooser.helpButtonToolTipText", "Aide");
        UIManager.put("FileChooser.newFolderErrorText", "Erreur lors de la création du nouveau dossier");
        UIManager.put("FileChooser.openButtonMnemonic", "O");
        UIManager.put("FileChooser.openButtonText", "Ouvrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Ouvrir le fichier sélectionné");
        UIManager.put("FileChooser.openDialogTitleText", "Ouvrir");
        UIManager.put("FileChooser.saveButtonMnemonic", "E");
        UIManager.put("FileChooser.saveButtonText", "Enregistrer");
        UIManager.put("FileChooser.saveButtonToolTipText", "Enregistrer le fichier sélectionné");
        UIManager.put("FileChooser.saveDialogTitleText", "Enregistrer");
        UIManager.put("FileChooser.updateButtonMnemonic", "M");
        UIManager.put("FileChooser.updateButtonText", "Actualiser");
        UIManager.put("FileChooser.updateButtonToolTipText", "Actualiser la liste des fichiers");
        UIManager.put("FileChooser.detailsViewActionLabelText", "Détails");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Détails");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Détails");
        UIManager.put("FileChooser.fileAttrHeaderText", "Attributs");
        UIManager.put("FileChooser.fileDateHeaderText", "Date de modification");
        UIManager.put("FileChooser.fileNameHeaderText", "Nom");
        UIManager.put("FileChooser.fileNameLabelText", "Nom du fichier :");
        UIManager.put("FileChooser.fileSizeHeaderText", "Taille");
        UIManager.put("FileChooser.fileTypeHeaderText", "Type");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Type de fichiers :");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Accueil");
        UIManager.put("FileChooser.homeFolderToolTipText", "Dossier personnel");
        UIManager.put("FileChooser.listViewActionLabelText", "Liste");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Liste");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Liste");
        UIManager.put("FileChooser.lookInLabelText", "Regarder dans :");
        UIManager.put("FileChooser.newFolderAccessibleName", "Nouveau dossier");
        UIManager.put("FileChooser.newFolderActionLabelText", "Nouveau dossier");
        UIManager.put("FileChooser.newFolderToolTipText", "Créer un nouveau dossier");
        UIManager.put("FileChooser.refreshActionLabelText", "Actualiser");
        UIManager.put("FileChooser.saveInLabelText", "Enregistrer dans :");
        UIManager.put("FileChooser.upFolderAccessibleName", "Niveau supérieur");
        UIManager.put("FileChooser.upFolderToolTipText", "Aller au niveau supérieur");
        UIManager.put("FileChooser.viewMenuLabelText", "Affichage");
        UIManager.put("FormView.browseFileButtonText", "Parcourir...");
        UIManager.put("FormView.resetButtonText", "Réinitialiser");
        UIManager.put("FormView.submitButtonText", "Soumettre");
        UIManager.put("InternalFrame.closeButtonToolTip", "Fermer");
        UIManager.put("InternalFrame.iconButtonToolTip", "Réduire");
        UIManager.put("InternalFrame.maxButtonToolTip", "Agrandir");
        UIManager.put("InternalFrame.restoreButtonToolTip", "Restaurer");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "Fermer");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "Fermer");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "Réduire");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "Agrandir");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "Agrandir");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "Réduire");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "Déplacer");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "Restaurer");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "Taille");
        UIManager.put("MetalTitlePane.closeMnemonic", "F");
        UIManager.put("MetalTitlePane.closeTitle", "Fermer");
        UIManager.put("MetalTitlePane.iconifyMnemonic", "R");
        UIManager.put("MetalTitlePane.iconifyTitle", "Réduire");
        UIManager.put("MetalTitlePane.maximizeMnemonic", "A");
        UIManager.put("MetalTitlePane.maximizeTitle", "Agrandir");
        UIManager.put("MetalTitlePane.restoreMnemonic", "S");
        UIManager.put("MetalTitlePane.restoreTitle", "Restaurer");
        UIManager.put("OptionPane.cancelButtonMnemonic", "A");
        UIManager.put("OptionPane.cancelButtonText", "Annuler");
        UIManager.put("OptionPane.inputDialogTitle", "Saisie");
        UIManager.put("OptionPane.messageDialogTitle", "Message");
        UIManager.put("OptionPane.noButtonMnemonic", "N");
        UIManager.put("OptionPane.noButtonText", "Non");
        UIManager.put("OptionPane.okButtonMnemonic", "O");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.titleText", "Message");
        UIManager.put("OptionPane.yesButtonMnemonic", "O");
        UIManager.put("OptionPane.yesButtonText", "Oui");
        UIManager.put("PrintingDialog.abortButtonDisplayedMnemonicIndex", "0");
        UIManager.put("PrintingDialog.abortButtonMnemonic", "I");
        UIManager.put("PrintingDialog.abortButtonText", "Interrompre");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "Interrompre l'impression");
        UIManager.put("PrintingDialog.contentAbortingText", "Interruption de l'impression...");
        UIManager.put("PrintingDialog.contentInitialText", "Impression en cours...");
        UIManager.put("PrintingDialog.titleProgressText", "Impression");
        UIManager.put("ProgressMonitor.progressText", "Progression...");
        UIManager.put("SplitPane.leftButtonText", "Gauche");
        UIManager.put("SplitPane.rightButtonText", "Droite");
    }
}
