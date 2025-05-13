package localization.languages;

import localization.Localizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Chinese implements Localizer {
    private static final Logger LOG = Logger.getLogger(Chinese.class.getName());
    private static final Map<String, String> texts;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("file", "文件");
        map.put("close", "关闭");
        map.put("viewMode", "视图模式");
        map.put("systemScheme", "系统方案");
        map.put("universalScheme", "通用方案");
        map.put("tests", "测试");
        map.put("logMessage", "日志消息");
        map.put("confirmExit", "您确定要退出吗？");
        map.put("language", "语言");

        map.put("appTitle", "机器人");
        map.put("logProtocolWorks", "日志协议运行中");
        map.put("newLogEntry", "新的日志条目");
        map.put("languageSwitchedLog", "语言已切换为: {0}");
        map.put("lookAndFeelError", "应用外观时出错");

        map.put("logWindowTitle", "日志窗口");
        map.put("gameWindowTitle", "游戏窗口");
        map.put("coordinatesWindowTitle", "机器人坐标");

        texts = Map.copyOf(map);
    }

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "点击");
        UIManager.put("AbstractDocument.additionText", "添加");
        UIManager.put("AbstractDocument.deletionText", "删除");
        UIManager.put("AbstractDocument.redoText", "重做");
        UIManager.put("AbstractDocument.styleChangeText", "样式更改");
        UIManager.put("AbstractDocument.undoText", "撤销");
        UIManager.put("AbstractUndoableEdit.redoText", "重做");
        UIManager.put("AbstractUndoableEdit.undoText", "撤销");
        UIManager.put("ColorChooser.cancelText", "取消");
        UIManager.put("ColorChooser.hsbBlueText", "蓝");
        UIManager.put("ColorChooser.hsbBrightnessText", "亮度");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "绿");
        UIManager.put("ColorChooser.hsbHueText", "色调");
        UIManager.put("ColorChooser.hsbMnemonic", "H");
        UIManager.put("ColorChooser.hsbNameText", "HSB");
        UIManager.put("ColorChooser.hsbRedText", "红");
        UIManager.put("ColorChooser.hsbSaturationText", "饱和度");
        UIManager.put("ColorChooser.okText", "确定");
        UIManager.put("ColorChooser.previewText", "预览");
        UIManager.put("ColorChooser.resetMnemonic", "R");
        UIManager.put("ColorChooser.resetText", "重置");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "B");
        UIManager.put("ColorChooser.rgbBlueText", "蓝色");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "G");
        UIManager.put("ColorChooser.rgbGreenText", "绿色");
        UIManager.put("ColorChooser.rgbMnemonic", "R");
        UIManager.put("ColorChooser.rgbNameText", "RGB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "R");
        UIManager.put("ColorChooser.rgbRedText", "红色");
        UIManager.put("ColorChooser.sampleText", "示例：");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "S");
        UIManager.put("ColorChooser.swatchesNameText", "色板");
        UIManager.put("ColorChooser.swatchesRecentText", "最近：");
        UIManager.put("ComboBox.togglePopupText", "切换弹出框");
        UIManager.put("FileChooser.acceptAllFileFilterText", "所有文件");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonText", "取消");
        UIManager.put("FileChooser.cancelButtonToolTipText", "取消文件选择");
        UIManager.put("FileChooser.directoryDescriptionText", "文件夹");
        UIManager.put("FileChooser.directoryOpenButtonMnemonic", "O");
        UIManager.put("FileChooser.directoryOpenButtonText", "打开");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "打开选中的文件夹");
        UIManager.put("FileChooser.fileDescriptionText", "文件");
        UIManager.put("FileChooser.helpButtonMnemonic", "H");
        UIManager.put("FileChooser.helpButtonText", "帮助");
        UIManager.put("FileChooser.helpButtonToolTipText", "帮助");
        UIManager.put("FileChooser.newFolderErrorText", "创建新文件夹出错");
        UIManager.put("FileChooser.openButtonMnemonic", "O");
        UIManager.put("FileChooser.openButtonText", "打开");
        UIManager.put("FileChooser.openButtonToolTipText", "打开选中文件");
        UIManager.put("FileChooser.openDialogTitleText", "打开");
        UIManager.put("FileChooser.saveButtonMnemonic", "S");
        UIManager.put("FileChooser.saveButtonText", "保存");
        UIManager.put("FileChooser.saveButtonToolTipText", "保存选中文件");
        UIManager.put("FileChooser.saveDialogTitleText", "保存");
        UIManager.put("FileChooser.updateButtonMnemonic", "U");
        UIManager.put("FileChooser.updateButtonText", "更新");
        UIManager.put("FileChooser.updateButtonToolTipText", "更新文件列表");
        UIManager.put("FileChooser.detailsViewActionLabelText", "详情");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "详情");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "详情");
        UIManager.put("FileChooser.fileAttrHeaderText", "属性");
        UIManager.put("FileChooser.fileDateHeaderText", "修改日期");
        UIManager.put("FileChooser.fileNameHeaderText", "名称");
        UIManager.put("FileChooser.fileNameLabelText", "文件名：");
        UIManager.put("FileChooser.fileSizeHeaderText", "大小");
        UIManager.put("FileChooser.fileTypeHeaderText", "类型");
        UIManager.put("FileChooser.filesOfTypeLabelText", "文件类型：");
        UIManager.put("FileChooser.homeFolderAccessibleName", "主文件夹");
        UIManager.put("FileChooser.homeFolderToolTipText", "主文件夹");
        UIManager.put("FileChooser.listViewActionLabelText", "列表");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "列表");
        UIManager.put("FileChooser.listViewButtonToolTipText", "列表");
        UIManager.put("FileChooser.lookInLabelText", "查找位置：");
        UIManager.put("FileChooser.newFolderAccessibleName", "新建文件夹");
        UIManager.put("FileChooser.newFolderActionLabelText", "新建文件夹");
        UIManager.put("FileChooser.newFolderToolTipText", "创建新文件夹");
        UIManager.put("FileChooser.refreshActionLabelText", "刷新");
        UIManager.put("FileChooser.saveInLabelText", "保存位置：");
        UIManager.put("FileChooser.upFolderAccessibleName", "上一级");
        UIManager.put("FileChooser.upFolderToolTipText", "返回上一级");
        UIManager.put("FileChooser.viewMenuLabelText", "视图");
        UIManager.put("FormView.browseFileButtonText", "浏览...");
        UIManager.put("FormView.resetButtonText", "重置");
        UIManager.put("FormView.submitButtonText", "提交");
        UIManager.put("InternalFrame.closeButtonToolTip", "关闭");
        UIManager.put("InternalFrame.iconButtonToolTip", "最小化");
        UIManager.put("InternalFrame.maxButtonToolTip", "最大化");
        UIManager.put("InternalFrame.restoreButtonToolTip", "还原");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "关闭");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "关闭");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "最小化");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "最大化");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "最大化");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "最小化");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "移动");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "还原");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "大小");
        UIManager.put("MetalTitlePane.closeMnemonic", "C");
        UIManager.put("MetalTitlePane.closeTitle", "关闭");
        UIManager.put("MetalTitlePane.iconifyMnemonic", "I");
        UIManager.put("MetalTitlePane.iconifyTitle", "最小化");
        UIManager.put("MetalTitlePane.maximizeMnemonic", "M");
        UIManager.put("MetalTitlePane.maximizeTitle", "最大化");
        UIManager.put("MetalTitlePane.restoreMnemonic", "R");
        UIManager.put("MetalTitlePane.restoreTitle", "还原");
        UIManager.put("OptionPane.cancelButtonMnemonic", "C");
        UIManager.put("OptionPane.cancelButtonText", "取消");
        UIManager.put("OptionPane.inputDialogTitle", "输入");
        UIManager.put("OptionPane.messageDialogTitle", "消息");
        UIManager.put("OptionPane.noButtonMnemonic", "N");
        UIManager.put("OptionPane.noButtonText", "否");
        UIManager.put("OptionPane.okButtonMnemonic", "O");
        UIManager.put("OptionPane.okButtonText", "确定");
        UIManager.put("OptionPane.titleText", "消息");
        UIManager.put("OptionPane.yesButtonMnemonic", "Y");
        UIManager.put("OptionPane.yesButtonText", "是");
        UIManager.put("PrintingDialog.abortButtonDisplayedMnemonicIndex", "0");
        UIManager.put("PrintingDialog.abortButtonMnemonic", "A");
        UIManager.put("PrintingDialog.abortButtonText", "中止");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "中止打印");
        UIManager.put("PrintingDialog.contentAbortingText", "正在中止打印...");
        UIManager.put("PrintingDialog.contentInitialText", "正在打印...");
        UIManager.put("PrintingDialog.titleProgressText", "打印");
        UIManager.put("ProgressMonitor.progressText", "进度...");
        UIManager.put("SplitPane.leftButtonText", "左");
        UIManager.put("SplitPane.rightButtonText", "右");
    }
}
