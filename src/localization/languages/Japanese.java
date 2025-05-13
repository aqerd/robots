package localization.languages;

import localization.Localizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Japanese implements Localizer {
    private static final Logger LOG = Logger.getLogger(Japanese.class.getName());
    private static final Map<String, String> texts;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("file", "ファイル");
        map.put("close", "閉じる");
        map.put("viewMode", "表示モード");
        map.put("systemScheme", "システムスキーム");
        map.put("universalScheme", "ユニバーサルスキーム");
        map.put("tests", "テスト");
        map.put("logMessage", "ログメッセージ");
        map.put("confirmExit", "本当に終了しますか？");
        map.put("language", "言語");

        map.put("appTitle", "ロボット");
        map.put("logProtocolWorks", "ログプロトコルが動作中");
        map.put("newLogEntry", "新しいログエントリ");
        map.put("languageSwitchedLog", "言語を切り替えました: {0}");
        map.put("lookAndFeelError", "ルックアンドフィールの適用エラー");

        map.put("logWindowTitle", "ログウィンドウ");
        map.put("gameWindowTitle", "ゲームウィンドウ");
        map.put("coordinatesWindowTitle", "ロボットの座標");

        texts = Map.copyOf(map);
    }

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "クリック");
        UIManager.put("AbstractDocument.additionText", "追加");
        UIManager.put("AbstractDocument.deletionText", "削除");
        UIManager.put("AbstractDocument.redoText", "やり直し");
        UIManager.put("AbstractDocument.styleChangeText", "スタイル変更");
        UIManager.put("AbstractDocument.undoText", "元に戻す");
        UIManager.put("AbstractUndoableEdit.redoText", "やり直し");
        UIManager.put("AbstractUndoableEdit.undoText", "元に戻す");
        UIManager.put("ColorChooser.cancelText", "キャンセル");
        UIManager.put("ColorChooser.hsbBlueText", "青");
        UIManager.put("ColorChooser.hsbBrightnessText", "明度");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "緑");
        UIManager.put("ColorChooser.hsbHueText", "色相");
        UIManager.put("ColorChooser.hsbMnemonic", "H");
        UIManager.put("ColorChooser.hsbNameText", "HSB");
        UIManager.put("ColorChooser.hsbRedText", "赤");
        UIManager.put("ColorChooser.hsbSaturationText", "彩度");
        UIManager.put("ColorChooser.okText", "OK");
        UIManager.put("ColorChooser.previewText", "プレビュー");
        UIManager.put("ColorChooser.resetMnemonic", "R");
        UIManager.put("ColorChooser.resetText", "リセット");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "B");
        UIManager.put("ColorChooser.rgbBlueText", "青");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "G");
        UIManager.put("ColorChooser.rgbGreenText", "緑");
        UIManager.put("ColorChooser.rgbMnemonic", "R");
        UIManager.put("ColorChooser.rgbNameText", "RGB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "R");
        UIManager.put("ColorChooser.rgbRedText", "赤");
        UIManager.put("ColorChooser.sampleText", "サンプル:");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "S");
        UIManager.put("ColorChooser.swatchesNameText", "スウォッチ");
        UIManager.put("ColorChooser.swatchesRecentText", "最近:");
        UIManager.put("ComboBox.togglePopupText", "ポップアップ切替");
        UIManager.put("FileChooser.acceptAllFileFilterText", "すべてのファイル");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonText", "キャンセル");
        UIManager.put("FileChooser.cancelButtonToolTipText", "ファイル選択をキャンセル");
        UIManager.put("FileChooser.directoryDescriptionText", "フォルダ");
        UIManager.put("FileChooser.directoryOpenButtonMnemonic", "O");
        UIManager.put("FileChooser.directoryOpenButtonText", "開く");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "選択したディレクトリを開く");
        UIManager.put("FileChooser.fileDescriptionText", "ファイル");
        UIManager.put("FileChooser.helpButtonMnemonic", "H");
        UIManager.put("FileChooser.helpButtonText", "ヘルプ");
        UIManager.put("FileChooser.helpButtonToolTipText", "ヘルプ");
        UIManager.put("FileChooser.newFolderErrorText", "新しいフォルダの作成中にエラーが発生しました");
        UIManager.put("FileChooser.openButtonMnemonic", "O");
        UIManager.put("FileChooser.openButtonText", "開く");
        UIManager.put("FileChooser.openButtonToolTipText", "選択したファイルを開く");
        UIManager.put("FileChooser.openDialogTitleText", "開く");
        UIManager.put("FileChooser.saveButtonMnemonic", "S");
        UIManager.put("FileChooser.saveButtonText", "保存");
        UIManager.put("FileChooser.saveButtonToolTipText", "選択したファイルを保存");
        UIManager.put("FileChooser.saveDialogTitleText", "保存");
        UIManager.put("FileChooser.updateButtonMnemonic", "U");
        UIManager.put("FileChooser.updateButtonText", "更新");
        UIManager.put("FileChooser.updateButtonToolTipText", "ファイルリストを更新");
        UIManager.put("FileChooser.detailsViewActionLabelText", "詳細");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "詳細");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "詳細");
        UIManager.put("FileChooser.fileAttrHeaderText", "属性");
        UIManager.put("FileChooser.fileDateHeaderText", "更新日");
        UIManager.put("FileChooser.fileNameHeaderText", "名前");
        UIManager.put("FileChooser.fileNameLabelText", "ファイル名:");
        UIManager.put("FileChooser.fileSizeHeaderText", "サイズ");
        UIManager.put("FileChooser.fileTypeHeaderText", "種類");
        UIManager.put("FileChooser.filesOfTypeLabelText", "ファイルの種類:");
        UIManager.put("FileChooser.homeFolderAccessibleName", "ホーム");
        UIManager.put("FileChooser.homeFolderToolTipText", "ホームフォルダ");
        UIManager.put("FileChooser.listViewActionLabelText", "リスト");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "リスト");
        UIManager.put("FileChooser.listViewButtonToolTipText", "リスト");
        UIManager.put("FileChooser.lookInLabelText", "場所:");
        UIManager.put("FileChooser.newFolderAccessibleName", "新しいフォルダ");
        UIManager.put("FileChooser.newFolderActionLabelText", "新しいフォルダ");
        UIManager.put("FileChooser.newFolderToolTipText", "新しいフォルダを作成");
        UIManager.put("FileChooser.refreshActionLabelText", "更新");
        UIManager.put("FileChooser.saveInLabelText", "保存先:");
        UIManager.put("FileChooser.upFolderAccessibleName", "一つ上へ");
        UIManager.put("FileChooser.upFolderToolTipText", "一つ上のフォルダへ移動");
        UIManager.put("FileChooser.viewMenuLabelText", "表示");
        UIManager.put("FormView.browseFileButtonText", "参照...");
        UIManager.put("FormView.resetButtonText", "リセット");
        UIManager.put("FormView.submitButtonText", "送信");
        UIManager.put("InternalFrame.closeButtonToolTip", "閉じる");
        UIManager.put("InternalFrame.iconButtonToolTip", "最小化");
        UIManager.put("InternalFrame.maxButtonToolTip", "最大化");
        UIManager.put("InternalFrame.restoreButtonToolTip", "元に戻す");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "閉じる");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "閉じる");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "最小化");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "最大化");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "最大化");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "最小化");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "移動");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "元に戻す");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "サイズ");
        UIManager.put("MetalTitlePane.closeMnemonic", "C");
        UIManager.put("MetalTitlePane.closeTitle", "閉じる");
        UIManager.put("MetalTitlePane.iconifyMnemonic", "I");
        UIManager.put("MetalTitlePane.iconifyTitle", "最小化");
        UIManager.put("MetalTitlePane.maximizeMnemonic", "M");
        UIManager.put("MetalTitlePane.maximizeTitle", "最大化");
        UIManager.put("MetalTitlePane.restoreMnemonic", "R");
        UIManager.put("MetalTitlePane.restoreTitle", "元に戻す");
        UIManager.put("OptionPane.cancelButtonMnemonic", "C");
        UIManager.put("OptionPane.cancelButtonText", "キャンセル");
        UIManager.put("OptionPane.inputDialogTitle", "入力");
        UIManager.put("OptionPane.messageDialogTitle", "メッセージ");
        UIManager.put("OptionPane.noButtonMnemonic", "N");
        UIManager.put("OptionPane.noButtonText", "いいえ");
        UIManager.put("OptionPane.okButtonMnemonic", "O");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.titleText", "メッセージ");
        UIManager.put("OptionPane.yesButtonMnemonic", "Y");
        UIManager.put("OptionPane.yesButtonText", "はい");
        UIManager.put("PrintingDialog.abortButtonDisplayedMnemonicIndex", "0");
        UIManager.put("PrintingDialog.abortButtonMnemonic", "A");
        UIManager.put("PrintingDialog.abortButtonText", "中止");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "印刷を中止");
        UIManager.put("PrintingDialog.contentAbortingText", "印刷を中止中...");
        UIManager.put("PrintingDialog.contentInitialText", "印刷中...");
        UIManager.put("PrintingDialog.titleProgressText", "印刷");
        UIManager.put("ProgressMonitor.progressText", "進行中...");
        UIManager.put("SplitPane.leftButtonText", "左");
        UIManager.put("SplitPane.rightButtonText", "右");
    }
}
