package localization.languages;

import localization.Localizer;

import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class French implements Localizer {
    private static final Logger LOG = Logger.getLogger(French.class.getName());
    private static final Map<String, String> texts = Map.of(
            "file", "Fichier",
            "close", "Fermer",
            "viewMode", "Mode d'affichage",
            "systemScheme", "Thème système",
            "universalScheme", "Thème universel",
            "tests", "Tests",
            "logMessage", "Message de journal",
            "confirmExit", "Voulez-vous vraiment quitter ?",
            "language", "Langue"
    );

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "Cliquer");
        UIManager.put("AbstractDocument.additionText", "Ajout");
        UIManager.put("AbstractDocument.deletionText", "Suppression");
        UIManager.put("AbstractDocument.redoText", "Rétablir");
        UIManager.put("AbstractDocument.styleChangeText", "Changement de style");
        UIManager.put("AbstractDocument.undoText", "Annuler");
        UIManager.put("AbstractUndoableEdit.redoText", "Rétablir");
        UIManager.put("AbstractUndoableEdit.undoText", "Annuler");
        UIManager.put("ColorChooser.cancelText", "Annuler");
        UIManager.put("ColorChooser.hsbBlueText", "B");
        UIManager.put("ColorChooser.hsbBrightnessText", "Luminosité");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "V");
        UIManager.put("ColorChooser.hsbHueText", "Teinte");
        UIManager.put("ColorChooser.hsbMnemonic", "84");
        UIManager.put("ColorChooser.hsbNameText", "TSL");
        UIManager.put("ColorChooser.hsbRedText", "R");
        UIManager.put("ColorChooser.hsbSaturationText", "Saturation");
        UIManager.put("ColorChooser.okText", "OK");
        UIManager.put("ColorChooser.previewText", "Aperçu");
        UIManager.put("ColorChooser.resetMnemonic", "82");
        UIManager.put("ColorChooser.resetText", "Réinitialiser");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "66");
        UIManager.put("ColorChooser.rgbBlueText", "Bleu");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "1");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "78");
        UIManager.put("ColorChooser.rgbGreenText", "Vert");
        UIManager.put("ColorChooser.rgbMnemonic", "71");
        UIManager.put("ColorChooser.rgbNameText", "RVB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "68");
        UIManager.put("ColorChooser.rgbRedText", "Rouge");
        UIManager.put("ColorChooser.sampleText", "Exemple de texte");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "83");
        UIManager.put("ColorChooser.swatchesNameText", "Nuancier");
        UIManager.put("ColorChooser.swatchesRecentText", "Récents :");
        UIManager.put("ComboBox.togglePopupText", "Afficher la liste");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Tous les fichiers");
        UIManager.put("FileChooser.cancelButtonText", "Annuler");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Fermer la fenêtre");
        UIManager.put("FileChooser.directoryDescriptionText", "Dossier");
        UIManager.put("FileChooser.directoryOpenButtonText", "Ouvrir");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "Ouvrir le dossier sélectionné");
        UIManager.put("FileChooser.fileDescriptionText", "Tous les fichiers");
        UIManager.put("FileChooser.helpButtonText", "Aide");
        UIManager.put("FileChooser.helpButtonToolTipText", "Afficher l'aide");
        UIManager.put("FileChooser.newFolderErrorText", "Erreur de création du dossier");
        UIManager.put("FileChooser.openButtonText", "Ouvrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Ouvrir le fichier sélectionné");
        UIManager.put("FileChooser.openDialogTitleText", "Ouvrir");
        UIManager.put("FileChooser.saveButtonText", "Enregistrer");
        UIManager.put("FileChooser.saveButtonToolTipText", "Enregistrer le fichier sélectionné");
        UIManager.put("FileChooser.saveDialogTitleText", "Enregistrer");
        UIManager.put("FileChooser.updateButtonText", "Mettre à jour");
        UIManager.put("FileChooser.updateButtonToolTipText", "Actualiser la liste des dossiers");
        UIManager.put("FileChooser.detailsViewActionLabelText", "Tableau");
        UIManager.put("FileChooser.fileAttrHeaderText", "Attributs");
        UIManager.put("FileChooser.fileDateHeaderText", "Modifié");
        UIManager.put("FileChooser.fileNameHeaderText", "Nom");
        UIManager.put("FileChooser.fileNameLabelText", "Nom du fichier:");
        UIManager.put("FileChooser.fileSizeHeaderText", "Taille");
        UIManager.put("FileChooser.fileTypeHeaderText", "Type");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Types de fichiers:");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Accueil");
        UIManager.put("FileChooser.listViewActionLabelText", "Liste");
        UIManager.put("FileChooser.lookInLabelText", "Regarder dans:");
        UIManager.put("FileChooser.newFolderAccessibleName", "Nouveau dossier");
        UIManager.put("FileChooser.newFolderToolTipText", "Créer un nouveau dossier");
        UIManager.put("FileChooser.refreshActionLabelText", "Rafraîchir");
        UIManager.put("FileChooser.saveInLabelText", "Enregistrer dans:");
        UIManager.put("FileChooser.upFolderToolTipText", "Monter d’un niveau");
        UIManager.put("FileChooser.viewMenuLabelText", "Affichage");
        UIManager.put("FormView.browseFileButtonText", "Parcourir...");
        UIManager.put("FormView.resetButtonText", "Réinitialiser");
        UIManager.put("FormView.submitButtonText", "Soumettre");
        UIManager.put("InternalFrame.closeButtonToolTip", "Fermer");
        UIManager.put("InternalFrame.iconButtonToolTip", "Minimiser");
        UIManager.put("InternalFrame.maxButtonToolTip", "Agrandir");
        UIManager.put("InternalFrame.restoreButtonToolTip", "Restaurer");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "Fermer");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "Fermer");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "Minimiser");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "Agrandir");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "Agrandir");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "Minimiser");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "Déplacer");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "Restaurer");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "Taille");
        UIManager.put("MetalTitlePane.closeTitle", "Fermer");
        UIManager.put("MetalTitlePane.iconifyTitle", "Minimiser");
        UIManager.put("MetalTitlePane.maximizeTitle", "Agrandir");
        UIManager.put("MetalTitlePane.restoreTitle", "Restaurer");
        UIManager.put("OptionPane.cancelButtonText", "Annuler");
        UIManager.put("OptionPane.inputDialogTitle", "Entrée");
        UIManager.put("OptionPane.messageDialogTitle", "Message");
        UIManager.put("OptionPane.noButtonText", "Non");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.titleText", "Choisissez une valeur");
        UIManager.put("OptionPane.yesButtonText", "Oui");
        UIManager.put("PrintingDialog.abortButtonText", "Annuler");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "Annuler l'impression");
        UIManager.put("PrintingDialog.contentAbortingText", "Annulation de l'impression...");
        UIManager.put("PrintingDialog.contentInitialText", "Impression en cours...");
        UIManager.put("PrintingDialog.titleProgressText", "Impression");
        UIManager.put("ProgressMonitor.progressText", "Traitement...");
        UIManager.put("SplitPane.leftButtonText", "Bouton gauche");
        UIManager.put("SplitPane.rightButtonText", "Bouton droit");
    }
}