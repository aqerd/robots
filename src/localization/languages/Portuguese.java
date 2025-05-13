package localization.languages;

import localization.Localizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Portuguese implements Localizer {
    private static final Logger LOG = Logger.getLogger(Portuguese.class.getName());
    private static final Map<String, String> texts;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("file", "Arquivo");
        map.put("close", "Fechar");
        map.put("viewMode", "Modo de visualização");
        map.put("systemScheme", "Esquema do sistema");
        map.put("universalScheme", "Esquema universal");
        map.put("tests", "Testes");
        map.put("logMessage", "Mensagem de log");
        map.put("confirmExit", "Tem certeza de que deseja sair?");
        map.put("language", "Idioma");

        map.put("appTitle", "Robôs");
        map.put("logProtocolWorks", "Protocolo de log funcionando");
        map.put("newLogEntry", "Nova entrada de log");
        map.put("languageSwitchedLog", "Idioma alterado para: {0}");
        map.put("lookAndFeelError", "Erro ao aplicar aparência");

        map.put("logWindowTitle", "Janela de Log");
        map.put("gameWindowTitle", "Janela de Jogo");
        map.put("coordinatesWindowTitle", "Coordenadas do robô");

        texts = Map.copyOf(map);
    }

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "clicar");
        UIManager.put("AbstractDocument.additionText", "adicionar");
        UIManager.put("AbstractDocument.deletionText", "excluir");
        UIManager.put("AbstractDocument.redoText", "Refazer");
        UIManager.put("AbstractDocument.styleChangeText", "alteração de estilo");
        UIManager.put("AbstractDocument.undoText", "Desfazer");
        UIManager.put("AbstractUndoableEdit.redoText", "Refazer");
        UIManager.put("AbstractUndoableEdit.undoText", "Desfazer");
        UIManager.put("ColorChooser.cancelText", "Cancelar");
        UIManager.put("ColorChooser.hsbBlueText", "Azul");
        UIManager.put("ColorChooser.hsbBrightnessText", "Brilho");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "Verde");
        UIManager.put("ColorChooser.hsbHueText", "Matiz");
        UIManager.put("ColorChooser.hsbMnemonic", "H");
        UIManager.put("ColorChooser.hsbNameText", "HSB");
        UIManager.put("ColorChooser.hsbRedText", "Vermelho");
        UIManager.put("ColorChooser.hsbSaturationText", "Saturação");
        UIManager.put("ColorChooser.okText", "OK");
        UIManager.put("ColorChooser.previewText", "Pré-visualizar");
        UIManager.put("ColorChooser.resetMnemonic", "R");
        UIManager.put("ColorChooser.resetText", "Redefinir");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "B");
        UIManager.put("ColorChooser.rgbBlueText", "Azul");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "G");
        UIManager.put("ColorChooser.rgbGreenText", "Verde");
        UIManager.put("ColorChooser.rgbMnemonic", "R");
        UIManager.put("ColorChooser.rgbNameText", "RGB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "R");
        UIManager.put("ColorChooser.rgbRedText", "Vermelho");
        UIManager.put("ColorChooser.sampleText", "Exemplo:");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "S");
        UIManager.put("ColorChooser.swatchesNameText", "Amostras");
        UIManager.put("ColorChooser.swatchesRecentText", "Recentes:");
        UIManager.put("ComboBox.togglePopupText", "Alternar popup");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos os arquivos");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar seleção de arquivo");
        UIManager.put("FileChooser.directoryDescriptionText", "Pasta");
        UIManager.put("FileChooser.directoryOpenButtonMnemonic", "O");
        UIManager.put("FileChooser.directoryOpenButtonText", "Abrir");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "Abrir a pasta selecionada");
        UIManager.put("FileChooser.fileDescriptionText", "Arquivo");
        UIManager.put("FileChooser.helpButtonMnemonic", "A");
        UIManager.put("FileChooser.helpButtonText", "Ajuda");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ajuda");
        UIManager.put("FileChooser.newFolderErrorText", "Erro ao criar nova pasta");
        UIManager.put("FileChooser.openButtonMnemonic", "A");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir arquivo selecionado");
        UIManager.put("FileChooser.openDialogTitleText", "Abrir");
        UIManager.put("FileChooser.saveButtonMnemonic", "S");
        UIManager.put("FileChooser.saveButtonText", "Salvar");
        UIManager.put("FileChooser.saveButtonToolTipText", "Salvar arquivo selecionado");
        UIManager.put("FileChooser.saveDialogTitleText", "Salvar");
        UIManager.put("FileChooser.updateButtonMnemonic", "U");
        UIManager.put("FileChooser.updateButtonText", "Atualizar");
        UIManager.put("FileChooser.updateButtonToolTipText", "Atualizar lista de arquivos");
        UIManager.put("FileChooser.detailsViewActionLabelText", "Detalhes");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.fileAttrHeaderText", "Atributos");
        UIManager.put("FileChooser.fileDateHeaderText", "Data de modificação");
        UIManager.put("FileChooser.fileNameHeaderText", "Nome");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo:");
        UIManager.put("FileChooser.fileSizeHeaderText", "Tamanho");
        UIManager.put("FileChooser.fileTypeHeaderText", "Tipo");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipos de arquivo:");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Início");
        UIManager.put("FileChooser.homeFolderToolTipText", "Pasta inicial");
        UIManager.put("FileChooser.listViewActionLabelText", "Lista");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.lookInLabelText", "Procurar em:");
        UIManager.put("FileChooser.newFolderAccessibleName", "Nova pasta");
        UIManager.put("FileChooser.newFolderActionLabelText", "Nova pasta");
        UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");
        UIManager.put("FileChooser.refreshActionLabelText", "Atualizar");
        UIManager.put("FileChooser.saveInLabelText", "Salvar em:");
        UIManager.put("FileChooser.upFolderAccessibleName", "Subir um nível");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir um nível");
        UIManager.put("FileChooser.viewMenuLabelText", "Exibição");
        UIManager.put("FormView.browseFileButtonText", "Procurar...");
        UIManager.put("FormView.resetButtonText", "Resetar");
        UIManager.put("FormView.submitButtonText", "Enviar");
        UIManager.put("InternalFrame.closeButtonToolTip", "Fechar");
        UIManager.put("InternalFrame.iconButtonToolTip", "Minimizar");
        UIManager.put("InternalFrame.maxButtonToolTip", "Maximizar");
        UIManager.put("InternalFrame.restoreButtonToolTip", "Restaurar");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "Fechar");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "Fechar");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "Minimizar");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "Maximizar");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "Maximizar");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "Minimizar");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "Mover");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "Restaurar");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "Tamanho");
        UIManager.put("MetalTitlePane.closeMnemonic", "C");
        UIManager.put("MetalTitlePane.closeTitle", "Fechar");
        UIManager.put("MetalTitlePane.iconifyMnemonic", "I");
        UIManager.put("MetalTitlePane.iconifyTitle", "Minimizar");
        UIManager.put("MetalTitlePane.maximizeMnemonic", "M");
        UIManager.put("MetalTitlePane.maximizeTitle", "Maximizar");
        UIManager.put("MetalTitlePane.restoreMnemonic", "R");
        UIManager.put("MetalTitlePane.restoreTitle", "Restaurar");
        UIManager.put("OptionPane.cancelButtonMnemonic", "C");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.inputDialogTitle", "Entrada");
        UIManager.put("OptionPane.messageDialogTitle", "Mensagem");
        UIManager.put("OptionPane.noButtonMnemonic", "N");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.okButtonMnemonic", "O");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.titleText", "Mensagem");
        UIManager.put("OptionPane.yesButtonMnemonic", "S");
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("PrintingDialog.abortButtonDisplayedMnemonicIndex", "0");
        UIManager.put("PrintingDialog.abortButtonMnemonic", "A");
        UIManager.put("PrintingDialog.abortButtonText", "Abortar");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "Cancelar impressão");
        UIManager.put("PrintingDialog.contentAbortingText", "Impressão sendo cancelada...");
        UIManager.put("PrintingDialog.contentInitialText", "Imprimindo...");
        UIManager.put("PrintingDialog.titleProgressText", "Impressão");
        UIManager.put("ProgressMonitor.progressText", "Progresso...");
        UIManager.put("SplitPane.leftButtonText", "Esquerda");
        UIManager.put("SplitPane.rightButtonText", "Direita");
    }
}
