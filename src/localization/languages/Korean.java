package localization.languages;

import localization.Localizer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class Korean implements Localizer {
    private static final Logger LOG = Logger.getLogger(Korean.class.getName());
    private static final Map<String, String> texts;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("file", "파일");
        map.put("close", "닫기");
        map.put("viewMode", "보기 모드");
        map.put("systemScheme", "시스템 스킴");
        map.put("universalScheme", "유니버설 스킴");
        map.put("tests", "테스트");
        map.put("logMessage", "로그 메시지");
        map.put("confirmExit", "정말 종료하시겠습니까?");
        map.put("language", "언어");

        map.put("appTitle", "로봇");
        map.put("logProtocolWorks", "로그 프로토콜 작동 중");
        map.put("newLogEntry", "새 로그 항목");
        map.put("languageSwitchedLog", "언어가 변경되었습니다: {0}");
        map.put("lookAndFeelError", "룩앤필 적용 오류");

        map.put("logWindowTitle", "로그 창");
        map.put("gameWindowTitle", "게임 창");
        map.put("coordinatesWindowTitle", "로봇 좌표");

        texts = Map.copyOf(map);
    }

    @Override
    public String getText(String key) {
        return texts.getOrDefault(key, key);
    }

    @Override
    public final void apply() {
        UIManager.put("AbstractButton.clickText", "클릭");
        UIManager.put("AbstractDocument.additionText", "추가");
        UIManager.put("AbstractDocument.deletionText", "삭제");
        UIManager.put("AbstractDocument.redoText", "다시 실행");
        UIManager.put("AbstractDocument.styleChangeText", "스타일 변경");
        UIManager.put("AbstractDocument.undoText", "실행 취소");
        UIManager.put("AbstractUndoableEdit.redoText", "다시 실행");
        UIManager.put("AbstractUndoableEdit.undoText", "실행 취소");
        UIManager.put("ColorChooser.cancelText", "취소");
        UIManager.put("ColorChooser.hsbBlueText", "파랑");
        UIManager.put("ColorChooser.hsbBrightnessText", "밝기");
        UIManager.put("ColorChooser.hsbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.hsbGreenText", "초록");
        UIManager.put("ColorChooser.hsbHueText", "색조");
        UIManager.put("ColorChooser.hsbMnemonic", "H");
        UIManager.put("ColorChooser.hsbNameText", "HSB");
        UIManager.put("ColorChooser.hsbRedText", "빨강");
        UIManager.put("ColorChooser.hsbSaturationText", "채도");
        UIManager.put("ColorChooser.okText", "확인");
        UIManager.put("ColorChooser.previewText", "미리보기");
        UIManager.put("ColorChooser.resetMnemonic", "R");
        UIManager.put("ColorChooser.resetText", "초기화");
        UIManager.put("ColorChooser.rgbBlueMnemonic", "B");
        UIManager.put("ColorChooser.rgbBlueText", "파랑");
        UIManager.put("ColorChooser.rgbDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.rgbGreenMnemonic", "G");
        UIManager.put("ColorChooser.rgbGreenText", "초록");
        UIManager.put("ColorChooser.rgbMnemonic", "R");
        UIManager.put("ColorChooser.rgbNameText", "RGB");
        UIManager.put("ColorChooser.rgbRedMnemonic", "R");
        UIManager.put("ColorChooser.rgbRedText", "빨강");
        UIManager.put("ColorChooser.sampleText", "샘플:");
        UIManager.put("ColorChooser.swatchesDisplayedMnemonicIndex", "0");
        UIManager.put("ColorChooser.swatchesMnemonic", "S");
        UIManager.put("ColorChooser.swatchesNameText", "견본");
        UIManager.put("ColorChooser.swatchesRecentText", "최근:");
        UIManager.put("ComboBox.togglePopupText", "팝업 전환");
        UIManager.put("FileChooser.acceptAllFileFilterText", "모든 파일");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonText", "취소");
        UIManager.put("FileChooser.cancelButtonToolTipText", "파일 선택 취소");
        UIManager.put("FileChooser.directoryDescriptionText", "폴더");
        UIManager.put("FileChooser.directoryOpenButtonMnemonic", "O");
        UIManager.put("FileChooser.directoryOpenButtonText", "열기");
        UIManager.put("FileChooser.directoryOpenButtonToolTipText", "선택한 폴더 열기");
        UIManager.put("FileChooser.fileDescriptionText", "파일");
        UIManager.put("FileChooser.helpButtonMnemonic", "H");
        UIManager.put("FileChooser.helpButtonText", "도움말");
        UIManager.put("FileChooser.helpButtonToolTipText", "도움말");
        UIManager.put("FileChooser.newFolderErrorText", "새 폴더 생성 오류");
        UIManager.put("FileChooser.openButtonMnemonic", "O");
        UIManager.put("FileChooser.openButtonText", "열기");
        UIManager.put("FileChooser.openButtonToolTipText", "선택한 파일 열기");
        UIManager.put("FileChooser.openDialogTitleText", "열기");
        UIManager.put("FileChooser.saveButtonMnemonic", "S");
        UIManager.put("FileChooser.saveButtonText", "저장");
        UIManager.put("FileChooser.saveButtonToolTipText", "선택한 파일 저장");
        UIManager.put("FileChooser.saveDialogTitleText", "저장");
        UIManager.put("FileChooser.updateButtonMnemonic", "U");
        UIManager.put("FileChooser.updateButtonText", "업데이트");
        UIManager.put("FileChooser.updateButtonToolTipText", "파일 목록 업데이트");
        UIManager.put("FileChooser.detailsViewActionLabelText", "세부 정보");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "세부 정보");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "세부 정보");
        UIManager.put("FileChooser.fileAttrHeaderText", "속성");
        UIManager.put("FileChooser.fileDateHeaderText", "수정 날짜");
        UIManager.put("FileChooser.fileNameHeaderText", "이름");
        UIManager.put("FileChooser.fileNameLabelText", "파일 이름:");
        UIManager.put("FileChooser.fileSizeHeaderText", "크기");
        UIManager.put("FileChooser.fileTypeHeaderText", "유형");
        UIManager.put("FileChooser.filesOfTypeLabelText", "파일 형식:");
        UIManager.put("FileChooser.homeFolderAccessibleName", "홈");
        UIManager.put("FileChooser.homeFolderToolTipText", "홈 폴더");
        UIManager.put("FileChooser.listViewActionLabelText", "목록");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "목록");
        UIManager.put("FileChooser.listViewButtonToolTipText", "목록");
        UIManager.put("FileChooser.lookInLabelText", "찾을 위치:");
        UIManager.put("FileChooser.newFolderAccessibleName", "새 폴더");
        UIManager.put("FileChooser.newFolderActionLabelText", "새 폴더");
        UIManager.put("FileChooser.newFolderToolTipText", "새 폴더 만들기");
        UIManager.put("FileChooser.refreshActionLabelText", "새로고침");
        UIManager.put("FileChooser.saveInLabelText", "저장 위치:");
        UIManager.put("FileChooser.upFolderAccessibleName", "상위 폴더");
        UIManager.put("FileChooser.upFolderToolTipText", "상위 폴더로 이동");
        UIManager.put("FileChooser.viewMenuLabelText", "보기");
        UIManager.put("FormView.browseFileButtonText", "찾아보기...");
        UIManager.put("FormView.resetButtonText", "초기화");
        UIManager.put("FormView.submitButtonText", "제출");
        UIManager.put("InternalFrame.closeButtonToolTip", "닫기");
        UIManager.put("InternalFrame.iconButtonToolTip", "아이콘화");
        UIManager.put("InternalFrame.maxButtonToolTip", "최대화");
        UIManager.put("InternalFrame.restoreButtonToolTip", "복원");
        UIManager.put("InternalFrameTitlePane.closeButtonAccessibleName", "닫기");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "닫기");
        UIManager.put("InternalFrameTitlePane.iconifyButtonAccessibleName", "아이콘화");
        UIManager.put("InternalFrameTitlePane.maximizeButtonAccessibleName", "최대화");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "최대화");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "최소화");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "이동");
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "복원");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "크기");
        UIManager.put("MetalTitlePane.closeMnemonic", "C");
        UIManager.put("MetalTitlePane.closeTitle", "닫기");
        UIManager.put("MetalTitlePane.iconifyMnemonic", "I");
        UIManager.put("MetalTitlePane.iconifyTitle", "아이콘화");
        UIManager.put("MetalTitlePane.maximizeMnemonic", "M");
        UIManager.put("MetalTitlePane.maximizeTitle", "최대화");
        UIManager.put("MetalTitlePane.restoreMnemonic", "R");
        UIManager.put("MetalTitlePane.restoreTitle", "복원");
        UIManager.put("OptionPane.cancelButtonMnemonic", "C");
        UIManager.put("OptionPane.cancelButtonText", "취소");
        UIManager.put("OptionPane.inputDialogTitle", "입력");
        UIManager.put("OptionPane.messageDialogTitle", "메시지");
        UIManager.put("OptionPane.noButtonMnemonic", "N");
        UIManager.put("OptionPane.noButtonText", "아니오");
        UIManager.put("OptionPane.okButtonMnemonic", "O");
        UIManager.put("OptionPane.okButtonText", "확인");
        UIManager.put("OptionPane.titleText", "메시지");
        UIManager.put("OptionPane.yesButtonMnemonic", "Y");
        UIManager.put("OptionPane.yesButtonText", "예");
        UIManager.put("PrintingDialog.abortButtonDisplayedMnemonicIndex", "0");
        UIManager.put("PrintingDialog.abortButtonMnemonic", "A");
        UIManager.put("PrintingDialog.abortButtonText", "중단");
        UIManager.put("PrintingDialog.abortButtonToolTipText", "인쇄 중단");
        UIManager.put("PrintingDialog.contentAbortingText", "인쇄 중단 중...");
        UIManager.put("PrintingDialog.contentInitialText", "인쇄 중...");
        UIManager.put("PrintingDialog.titleProgressText", "인쇄");
        UIManager.put("ProgressMonitor.progressText", "진행 중...");
        UIManager.put("SplitPane.leftButtonText", "왼쪽");
        UIManager.put("SplitPane.rightButtonText", "오른쪽");
    }
}
