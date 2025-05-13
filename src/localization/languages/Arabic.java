package localization.languages;

import localization.Localizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Arabic implements Localizer {
    private static final Logger LOG = Logger.getLogger(Arabic.class.getName());
    private static final Map<String, String> texts;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("file", "ملف");
        map.put("close", "إغلاق");
        map.put("viewMode", "وضع العرض");
        map.put("systemScheme", "النظام الافتراضي");
        map.put("universalScheme", "المخطط العام");
        map.put("tests", "الاختبارات");
        map.put("logMessage", "رسالة السجل");
        map.put("confirmExit", "هل أنت متأكد أنك تريد الخروج؟");
        map.put("language", "اللغة");

        map.put("appTitle", "الروبوتات");
        map.put("logProtocolWorks", "يعمل بروتوكول السجل");
        map.put("newLogEntry", "إدخال سجل جديد");
        map.put("languageSwitchedLog", "تم التبديل إلى اللغة: {0}");
        map.put("lookAndFeelError", "خطأ في تطبيق المظهر");

        map.put("logWindowTitle", "نافذة السجل");
        map.put("gameWindowTitle", "نافذة اللعبة");
        map.put("coordinatesWindowTitle", "إحداثيات الروبوت");

        texts = Map.copyOf(map);
    }

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "انقر");
        UIManager.put("AbstractDocument.additionText", "إضافة");
        UIManager.put("AbstractDocument.deletionText", "حذف");
        UIManager.put("AbstractDocument.redoText", "إعادة");
        UIManager.put("AbstractDocument.styleChangeText", "تغيير النمط");
        UIManager.put("AbstractDocument.undoText", "تراجع");
        UIManager.put("AbstractUndoableEdit.redoText", "إعادة");
        UIManager.put("AbstractUndoableEdit.undoText", "تراجع");
        UIManager.put("ColorChooser.cancelText", "إلغاء");
        UIManager.put("ColorChooser.hsbBlueText", "أزرق");
        UIManager.put("ColorChooser.hsbBrightnessText", "السطوع");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "أخضر");
        UIManager.put("ColorChooser.hsbHueText", "اللون");
        UIManager.put("ColorChooser.hsbMnemonic", "H");
        UIManager.put("ColorChooser.hsbNameText", "HSB");
        UIManager.put("ColorChooser.hsbRedText", "أحمر");
        UIManager.put("ColorChooser.hsbSaturationText", "التشبع");
        UIManager.put("ColorChooser.okText", "موافق");
        UIManager.put("ColorChooser.previewText", "معاينة");
        UIManager.put("ColorChooser.resetMnemonic", "R");
        UIManager.put("ColorChooser.resetText", "إعادة تعيين");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "B");
        UIManager.put("ColorChooser.rgbBlueText", "أزرق");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "G");
        UIManager.put("ColorChooser.rgbGreenText", "أخضر");
        UIManager.put("ColorChooser.rgbMnemonic", "R");
        UIManager.put("ColorChooser.rgbNameText", "RGB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "R");
        UIManager.put("ColorChooser.rgbRedText", "أحمر");
        UIManager.put("ColorChooser.sampleText", "عينة:");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "S");
        UIManager.put("ColorChooser.swatchesNameText", "لوحات");
        UIManager.put("ColorChooser.swatchesRecentText", "الأخيرة:");
        UIManager.put("ComboBox.togglePopupText", "تبديل القائمة");
        UIManager.put("FileChooser.acceptAllFileFilterText", "جميع الملفات");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonText", "إلغاء");
        UIManager.put("FileChooser.cancelButtonToolTipText", "إلغاء اختيار الملف");
        UIManager.put("FileChooser.directoryDescriptionText", "مجلد");
        UIManager.put("FileChooser.directoryOpenButtonMnemonic", "O");
        UIManager.put("FileChooser.directoryOpenButtonText", "فتح");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "فتح المجلد المحدد");
        UIManager.put("FileChooser.fileDescriptionText", "ملف");
        UIManager.put("FileChooser.helpButtonMnemonic", "H");
        UIManager.put("FileChooser.helpButtonText", "مساعدة");
        UIManager.put("FileChooser.helpButtonToolTipText", "مساعدة");
        UIManager.put("FileChooser.newFolderErrorText", "خطأ في إنشاء مجلد جديد");
        UIManager.put("FileChooser.openButtonMnemonic", "O");
        UIManager.put("FileChooser.openButtonText", "فتح");
        UIManager.put("FileChooser.openButtonToolTipText", "فتح الملف المحدد");
        UIManager.put("FileChooser.openDialogTitleText", "فتح");
        UIManager.put("FileChooser.saveButtonMnemonic", "S");
        UIManager.put("FileChooser.saveButtonText", "حفظ");
        UIManager.put("FileChooser.saveButtonToolTipText", "حفظ الملف المحدد");
        UIManager.put("FileChooser.saveDialogTitleText", "حفظ");
        UIManager.put("FileChooser.updateButtonMnemonic", "U");
        UIManager.put("FileChooser.updateButtonText", "تحديث");
        UIManager.put("FileChooser.updateButtonToolTipText", "تحديث قائمة الملفات");
        UIManager.put("FileChooser.detailsViewActionLabelText", "تفاصيل");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "تفاصيل");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "تفاصيل");
        UIManager.put("FileChooser.fileAttrHeaderText", "السمات");
        UIManager.put("FileChooser.fileDateHeaderText", "تاريخ التعديل");
        UIManager.put("FileChooser.fileNameHeaderText", "الاسم");
        UIManager.put("FileChooser.fileNameLabelText", "اسم الملف:");
        UIManager.put("FileChooser.fileSizeHeaderText", "الحجم");
        UIManager.put("FileChooser.fileTypeHeaderText", "النوع");
        UIManager.put("FileChooser.filesOfTypeLabelText", "أنواع الملفات:");
        UIManager.put("FileChooser.homeFolderAccessibleName", "الرئيسية");
        UIManager.put("FileChooser.homeFolderToolTipText", "المجلد الرئيسي");
        UIManager.put("FileChooser.listViewActionLabelText", "قائمة");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "قائمة");
        UIManager.put("FileChooser.listViewButtonToolTipText", "قائمة");
        UIManager.put("FileChooser.lookInLabelText", "استعراض:");
        UIManager.put("FileChooser.newFolderAccessibleName", "مجلد جديد");
        UIManager.put("FileChooser.newFolderActionLabelText", "مجلد جديد");
        UIManager.put("FileChooser.newFolderToolTipText", "إنشاء مجلد جديد");
        UIManager.put("FileChooser.refreshActionLabelText", "تحديث");
        UIManager.put("FileChooser.saveInLabelText", "حفظ في:");
        UIManager.put("FileChooser.upFolderAccessibleName", "أعلى مجلد");
        UIManager.put("FileChooser.upFolderToolTipText", "انتقال لأعلى مستوى");
        UIManager.put("FileChooser.viewMenuLabelText", "عرض");
        UIManager.put("FormView.browseFileButtonText", "استعراض...");
        UIManager.put("FormView.resetButtonText", "إعادة تعيين");
        UIManager.put("FormView.submitButtonText", "إرسال");
        UIManager.put("InternalFrame.closeButtonToolTip", "إغلاق");
        UIManager.put("InternalFrame.iconButtonToolTip", "تصغير");
        UIManager.put("InternalFrame.maxButtonToolTip", "تكبير");
        UIManager.put("InternalFrame.restoreButtonToolTip", "استعادة");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "إغلاق");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "إغلاق");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "تصغير");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "تكبير");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "تكبير");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "تصغير");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "نقل");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "استعادة");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "الحجم");
        UIManager.put("MetalTitlePane.closeMnemonic", "C");
        UIManager.put("MetalTitlePane.closeTitle", "إغلاق");
        UIManager.put("MetalTitlePane.iconifyMnemonic", "I");
        UIManager.put("MetalTitlePane.iconifyTitle", "تصغير");
        UIManager.put("MetalTitlePane.maximizeMnemonic", "M");
        UIManager.put("MetalTitlePane.maximizeTitle", "تكبير");
        UIManager.put("MetalTitlePane.restoreMnemonic", "R");
        UIManager.put("MetalTitlePane.restoreTitle", "استعادة");
        UIManager.put("OptionPane.cancelButtonMnemonic", "C");
        UIManager.put("OptionPane.cancelButtonText", "إلغاء");
        UIManager.put("OptionPane.inputDialogTitle", "إدخال");
        UIManager.put("OptionPane.messageDialogTitle", "رسالة");
        UIManager.put("OptionPane.noButtonMnemonic", "N");
        UIManager.put("OptionPane.noButtonText", "لا");
        UIManager.put("OptionPane.okButtonMnemonic", "O");
        UIManager.put("OptionPane.okButtonText", "موافق");
        UIManager.put("OptionPane.titleText", "رسالة");
        UIManager.put("OptionPane.yesButtonMnemonic", "Y");
        UIManager.put("OptionPane.yesButtonText", "نعم");
        UIManager.put("PrintingDialog.abortButtonDisplayedMnemonicIndex", "0");
        UIManager.put("PrintingDialog.abortButtonMnemonic", "A");
        UIManager.put("PrintingDialog.abortButtonText", "إلغاء");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "إلغاء الطباعة");
        UIManager.put("PrintingDialog.contentAbortingText", "جاري إلغاء الطباعة...");
        UIManager.put("PrintingDialog.contentInitialText", "جاري الطباعة...");
        UIManager.put("PrintingDialog.titleProgressText", "الطباعة");
        UIManager.put("ProgressMonitor.progressText", "التقدم...");
        UIManager.put("SplitPane.leftButtonText", "يسار");
        UIManager.put("SplitPane.rightButtonText", "يمين");
    }
}
