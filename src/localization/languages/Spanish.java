package localization.languages;

import localization.Localizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Spanish implements Localizer {
    private static final Logger LOG = Logger.getLogger(Spanish.class.getName());
    private static final Map<String, String> texts;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("file", "Archivo");
        map.put("close", "Cerrar");
        map.put("viewMode", "Modo de vista");
        map.put("systemScheme", "Esquema del sistema");
        map.put("universalScheme", "Esquema universal");
        map.put("tests", "Pruebas");
        map.put("logMessage", "Mensaje de registro");
        map.put("confirmExit", "¿Estás seguro de que deseas salir?");
        map.put("language", "Idioma");

        map.put("appTitle", "Robots");
        map.put("logProtocolWorks", "Protocolo de registro funcionando");
        map.put("newLogEntry", "Nueva entrada de registro");
        map.put("languageSwitchedLog", "Idioma cambiado a: {0}");
        map.put("lookAndFeelError", "Error al aplicar apariencia");

        map.put("logWindowTitle", "Ventana de registro");
        map.put("gameWindowTitle", "Ventana del juego");
        map.put("coordinatesWindowTitle", "Coordenadas del robot");

        texts = Map.copyOf(map);
    }

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "clic");
        UIManager.put("AbstractDocument.additionText", "adición");
        UIManager.put("AbstractDocument.deletionText", "eliminación");
        UIManager.put("AbstractDocument.redoText", "Rehacer");
        UIManager.put("AbstractDocument.styleChangeText", "cambio de estilo");
        UIManager.put("AbstractDocument.undoText", "Deshacer");
        UIManager.put("AbstractUndoableEdit.redoText", "Rehacer");
        UIManager.put("AbstractUndoableEdit.undoText", "Deshacer");
        UIManager.put("ColorChooser.cancelText", "Cancelar");
        UIManager.put("ColorChooser.hsbBlueText", "A");
        UIManager.put("ColorChooser.hsbBrightnessText", "Brillo");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "V");
        UIManager.put("ColorChooser.hsbHueText", "Tono");
        UIManager.put("ColorChooser.hsbMnemonic", "T");
        UIManager.put("ColorChooser.hsbNameText", "HSB");
        UIManager.put("ColorChooser.hsbRedText", "R");
        UIManager.put("ColorChooser.hsbSaturationText", "Saturación");
        UIManager.put("ColorChooser.okText", "Aceptar");
        UIManager.put("ColorChooser.previewText", "Vista previa");
        UIManager.put("ColorChooser.resetMnemonic", "R");
        UIManager.put("ColorChooser.resetText", "Restablecer");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "A");
        UIManager.put("ColorChooser.rgbBlueText", "Azul");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "V");
        UIManager.put("ColorChooser.rgbGreenText", "Verde");
        UIManager.put("ColorChooser.rgbMnemonic", "R");
        UIManager.put("ColorChooser.rgbNameText", "RGB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "R");
        UIManager.put("ColorChooser.rgbRedText", "Rojo");
        UIManager.put("ColorChooser.sampleText", "Muestra:");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "M");
        UIManager.put("ColorChooser.swatchesNameText", "Muestras");
        UIManager.put("ColorChooser.swatchesRecentText", "Recientes:");
        UIManager.put("ComboBox.togglePopupText", "Alternar lista");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos los archivos");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar selección de archivo");
        UIManager.put("FileChooser.directoryDescriptionText", "Carpeta");
        UIManager.put("FileChooser.directoryOpenButtonMnemonic", "A");
        UIManager.put("FileChooser.directoryOpenButtonText", "Abrir");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "Abrir carpeta seleccionada");
        UIManager.put("FileChooser.fileDescriptionText", "Archivo");
        UIManager.put("FileChooser.helpButtonMnemonic", "A");
        UIManager.put("FileChooser.helpButtonText", "Ayuda");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ayuda");
        UIManager.put("FileChooser.newFolderErrorText", "Error al crear nueva carpeta");
        UIManager.put("FileChooser.openButtonMnemonic", "O");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir archivo seleccionado");
        UIManager.put("FileChooser.openDialogTitleText", "Abrir");
        UIManager.put("FileChooser.saveButtonMnemonic", "G");
        UIManager.put("FileChooser.saveButtonText", "Guardar");
        UIManager.put("FileChooser.saveButtonToolTipText", "Guardar archivo seleccionado");
        UIManager.put("FileChooser.saveDialogTitleText", "Guardar");
        UIManager.put("FileChooser.updateButtonMnemonic", "U");
        UIManager.put("FileChooser.updateButtonText", "Actualizar");
        UIManager.put("FileChooser.updateButtonToolTipText", "Actualizar lista de archivos");
        UIManager.put("FileChooser.detailsViewActionLabelText", "Detalles");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalles");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        UIManager.put("FileChooser.fileAttrHeaderText", "Atributos");
        UIManager.put("FileChooser.fileDateHeaderText", "Fecha de modificación");
        UIManager.put("FileChooser.fileNameHeaderText", "Nombre");
        UIManager.put("FileChooser.fileNameLabelText", "Nombre del archivo:");
        UIManager.put("FileChooser.fileSizeHeaderText", "Tamaño");
        UIManager.put("FileChooser.fileTypeHeaderText", "Tipo");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Archivos del tipo:");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Inicio");
        UIManager.put("FileChooser.homeFolderToolTipText", "Carpeta de inicio");
        UIManager.put("FileChooser.listViewActionLabelText", "Lista");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.lookInLabelText", "Buscar en:");
        UIManager.put("FileChooser.newFolderAccessibleName", "Nueva carpeta");
        UIManager.put("FileChooser.newFolderActionLabelText", "Nueva carpeta");
        UIManager.put("FileChooser.newFolderToolTipText", "Crear nueva carpeta");
        UIManager.put("FileChooser.refreshActionLabelText", "Actualizar");
        UIManager.put("FileChooser.saveInLabelText", "Guardar en:");
        UIManager.put("FileChooser.upFolderAccessibleName", "Subir un nivel");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir un nivel");
        UIManager.put("FileChooser.viewMenuLabelText", "Ver");
        UIManager.put("FormView.browseFileButtonText", "Examinar...");
        UIManager.put("FormView.resetButtonText", "Restablecer");
        UIManager.put("FormView.submitButtonText", "Enviar");
        UIManager.put("InternalFrame.closeButtonToolTip", "Cerrar");
        UIManager.put("InternalFrame.iconButtonToolTip", "Minimizar");
        UIManager.put("InternalFrame.maxButtonToolTip", "Maximizar");
        UIManager.put("InternalFrame.restoreButtonToolTip", "Restaurar");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "Cerrar");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "Cerrar");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "Minimizar");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "Maximizar");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "Maximizar");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "Minimizar");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "Mover");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "Restaurar");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "Tamaño");
        UIManager.put("MetalTitlePane.closeMnemonic", "C");
        UIManager.put("MetalTitlePane.closeTitle", "Cerrar");
        UIManager.put("MetalTitlePane.iconifyMnemonic", "M");
        UIManager.put("MetalTitlePane.iconifyTitle", "Minimizar");
        UIManager.put("MetalTitlePane.maximizeMnemonic", "X");
        UIManager.put("MetalTitlePane.maximizeTitle", "Maximizar");
        UIManager.put("MetalTitlePane.restoreMnemonic", "R");
        UIManager.put("MetalTitlePane.restoreTitle", "Restaurar");
        UIManager.put("OptionPane.cancelButtonMnemonic", "C");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.inputDialogTitle", "Entrada");
        UIManager.put("OptionPane.messageDialogTitle", "Mensaje");
        UIManager.put("OptionPane.noButtonMnemonic", "N");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.okButtonMnemonic", "O");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        UIManager.put("OptionPane.titleText", "Mensaje");
        UIManager.put("OptionPane.yesButtonMnemonic", "S");
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("PrintingDialog.abortButtonDisplayedMnemonicIndex", "0");
        UIManager.put("PrintingDialog.abortButtonMnemonic", "A");
        UIManager.put("PrintingDialog.abortButtonText", "Abortar");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "Abortar impresión");
        UIManager.put("PrintingDialog.contentAbortingText", "Abortando impresión...");
        UIManager.put("PrintingDialog.contentInitialText", "Imprimiendo...");
        UIManager.put("PrintingDialog.titleProgressText", "Impresión");
        UIManager.put("ProgressMonitor.progressText", "Progreso...");
        UIManager.put("SplitPane.leftButtonText", "Izquierda");
        UIManager.put("SplitPane.rightButtonText", "Derecha");
    }
}
