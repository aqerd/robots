package localization.languages;

import localization.Localizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Russian implements Localizer {
    private static final Logger LOG = Logger.getLogger(Russian.class.getName());
    private static final Map<String, String> texts;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("file", "Файл");
        map.put("close", "Закрыть");
        map.put("viewMode", "Режим отображения");
        map.put("systemScheme", "Системная схема");
        map.put("universalScheme", "Универсальная схема");
        map.put("tests", "Тесты");
        map.put("logMessage", "Сообщение в лог");
        map.put("confirmExit", "Вы уверены, что хотите выйти?");
        map.put("language", "Язык");

        map.put("appTitle", "Роботы");
        map.put("logProtocolWorks", "Протокол работает");
        map.put("newLogEntry", "Новая строка для лога");
        map.put("languageSwitchedLog", "Язык переключен на: {0}");
        map.put("lookAndFeelError", "Ошибка применения темы оформления");

        map.put("logWindowTitle", "Логи");
        map.put("gameWindowTitle", "Игровое поле");
        map.put("coordinatesWindowTitle", "Координаты робота");

        texts = Map.copyOf(map);
    }

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "нажатие");
        UIManager.put("AbstractDocument.additionText", "добавление");
        UIManager.put("AbstractDocument.deletionText", "удаление");
        UIManager.put("AbstractDocument.redoText", "Повторить");
        UIManager.put("AbstractDocument.styleChangeText", "изменение стиля");
        UIManager.put("AbstractDocument.undoText", "Отменить");
        UIManager.put("AbstractUndoableEdit.redoText", "Повторить");
        UIManager.put("AbstractUndoableEdit.undoText", "Отменить");
        UIManager.put("ColorChooser.cancelText", "Отмена");
        UIManager.put("ColorChooser.hsbBlueText", "B");
        UIManager.put("ColorChooser.hsbBrightnessText", "Яркость");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "G");
        UIManager.put("ColorChooser.hsbHueText", "Оттенок");
        UIManager.put("ColorChooser.hsbMnemonic", "H");
        UIManager.put("ColorChooser.hsbNameText", "HSB");
        UIManager.put("ColorChooser.hsbRedText", "R");
        UIManager.put("ColorChooser.hsbSaturationText", "Насыщенность");
        UIManager.put("ColorChooser.okText", "OK");
        UIManager.put("ColorChooser.previewText", "Просмотр");
        UIManager.put("ColorChooser.resetMnemonic", "б");
        UIManager.put("ColorChooser.resetText", "Сброс");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "С");
        UIManager.put("ColorChooser.rgbBlueText", "Синий");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "З");
        UIManager.put("ColorChooser.rgbGreenText", "Зеленый");
        UIManager.put("ColorChooser.rgbMnemonic", "R");
        UIManager.put("ColorChooser.rgbNameText", "RGB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "К");
        UIManager.put("ColorChooser.rgbRedText", "Красный");
        UIManager.put("ColorChooser.sampleText", "Образец:");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "О");
        UIManager.put("ColorChooser.swatchesNameText", "Образцы");
        UIManager.put("ColorChooser.swatchesRecentText", "Недавние:");
        UIManager.put("ComboBox.togglePopupText", "Развернуть список");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Все файлы");
        UIManager.put("FileChooser.cancelButtonMnemonic", "т");
        UIManager.put("FileChooser.cancelButtonText", "Отмена");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Отменить выбор файла");
        UIManager.put("FileChooser.directoryDescriptionText", "Папка");
        UIManager.put("FileChooser.directoryOpenButtonMnemonic", "О");
        UIManager.put("FileChooser.directoryOpenButtonText", "Открыть");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "Открыть выбранную директорию");
        UIManager.put("FileChooser.fileDescriptionText", "Файл");
        UIManager.put("FileChooser.helpButtonMnemonic", "П");
        UIManager.put("FileChooser.helpButtonText", "Помощь");
        UIManager.put("FileChooser.helpButtonToolTipText", "Справка");
        UIManager.put("FileChooser.newFolderErrorText", "Ошибка создания новой папки");
        UIManager.put("FileChooser.openButtonMnemonic", "О");
        UIManager.put("FileChooser.openButtonText", "Открыть");
        UIManager.put("FileChooser.openButtonToolTipText", "Открыть выбранный файл");
        UIManager.put("FileChooser.openDialogTitleText", "Открыть");
        UIManager.put("FileChooser.saveButtonMnemonic", "С");
        UIManager.put("FileChooser.saveButtonText", "Сохранить");
        UIManager.put("FileChooser.saveButtonToolTipText", "Сохранить выбранный файл");
        UIManager.put("FileChooser.saveDialogTitleText", "Сохранить");
        UIManager.put("FileChooser.updateButtonMnemonic", "б");
        UIManager.put("FileChooser.updateButtonText", "Обновить");
        UIManager.put("FileChooser.updateButtonToolTipText", "Обновить список файлов");
        UIManager.put("FileChooser.detailsViewActionLabelText", "Таблица");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Таблица");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Таблица");
        UIManager.put("FileChooser.fileAttrHeaderText", "Атрибуты");
        UIManager.put("FileChooser.fileDateHeaderText", "Дата изменения");
        UIManager.put("FileChooser.fileNameHeaderText", "Имя");
        UIManager.put("FileChooser.fileNameLabelText", "Имя файла:");
        UIManager.put("FileChooser.fileSizeHeaderText", "Размер");
        UIManager.put("FileChooser.fileTypeHeaderText", "Тип");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Тип файлов:");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Домой");
        UIManager.put("FileChooser.homeFolderToolTipText", "Домашняя папка");
        UIManager.put("FileChooser.listViewActionLabelText", "Список");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Список");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Список");
        UIManager.put("FileChooser.lookInLabelText", "Папка:");
        UIManager.put("FileChooser.newFolderAccessibleName", "Новая папка");
        UIManager.put("FileChooser.newFolderActionLabelText", "Новая папка");
        UIManager.put("FileChooser.newFolderToolTipText", "Создать новую папку");
        UIManager.put("FileChooser.refreshActionLabelText", "Обновить");
        UIManager.put("FileChooser.saveInLabelText", "Сохранить в:");
        UIManager.put("FileChooser.upFolderAccessibleName", "Вверх");
        UIManager.put("FileChooser.upFolderToolTipText", "На один уровень вверх");
        UIManager.put("FileChooser.viewMenuLabelText", "Вид");
        UIManager.put("FormView.browseFileButtonText", "Обзор...");
        UIManager.put("FormView.resetButtonText", "Сброс");
        UIManager.put("FormView.submitButtonText", "Отправить");
        UIManager.put("InternalFrame.closeButtonToolTip", "Закрыть");
        UIManager.put("InternalFrame.iconButtonToolTip", "Свернуть");
        UIManager.put("InternalFrame.maxButtonToolTip", "Развернуть");
        UIManager.put("InternalFrame.restoreButtonToolTip", "Восстановить");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "Закрыть");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "Закрыть");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "Свернуть");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "Развернуть");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "Развернуть");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "Свернуть");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "Переместить");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "Восстановить");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "Размер");
        UIManager.put("MetalTitlePane.closeMnemonic", "З");
        UIManager.put("MetalTitlePane.closeTitle", "Закрыть");
        UIManager.put("MetalTitlePane.iconifyMnemonic", "С");
        UIManager.put("MetalTitlePane.iconifyTitle", "Свернуть");
        UIManager.put("MetalTitlePane.maximizeMnemonic", "Р");
        UIManager.put("MetalTitlePane.maximizeTitle", "Развернуть");
        UIManager.put("MetalTitlePane.restoreMnemonic", "В");
        UIManager.put("MetalTitlePane.restoreTitle", "Восстановить");
        UIManager.put("OptionPane.cancelButtonMnemonic", "т");
        UIManager.put("OptionPane.cancelButtonText", "Отмена");
        UIManager.put("OptionPane.inputDialogTitle", "Ввод");
        UIManager.put("OptionPane.messageDialogTitle", "Сообщение");
        UIManager.put("OptionPane.noButtonMnemonic", "Н");
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.okButtonMnemonic", "O");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.titleText", "Сообщение");
        UIManager.put("OptionPane.yesButtonMnemonic", "Д");
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("PrintingDialog.abortButtonDisplayedMnemonicIndex", "0");
        UIManager.put("PrintingDialog.abortButtonMnemonic", "П");
        UIManager.put("PrintingDialog.abortButtonText", "Прервать");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "Прервать печать");
        UIManager.put("PrintingDialog.contentAbortingText", "Прерывание печати...");
        UIManager.put("PrintingDialog.contentInitialText", "Печать...");
        UIManager.put("PrintingDialog.titleProgressText", "Печать");
        UIManager.put("ProgressMonitor.progressText", "Прогресс...");
        UIManager.put("SplitPane.leftButtonText", "Влево");
        UIManager.put("SplitPane.rightButtonText", "Вправо");
    }
}
