package com.raindrop;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author wl
 * @date 2017/10/24
 */
public class JsonDataFormat extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // project
        final Project project = e.getData(PlatformDataKeys.PROJECT);
        // 得到Editor
        final Editor editor = e.getData(PlatformDataKeys.EDITOR);
        // 获取SelectModel
        SelectionModel selectionModel = editor.getSelectionModel();
        // 得到用户选择的内容
        String selectedText = selectionModel.getSelectedText();
        if (StringUtils.isNotBlank(selectedText)) {
            // 格式化后的内容
            String value = JsonUtil.jsonFormat(selectedText);
            // 得到系统剪贴板
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(value), null);
            // Show JsonDialog
            showJsonDialog(value);
        }
    }

    private void showJsonDialog(String value) {
        JFrame frame = new JFrame("JsonDialog");
        frame.setContentPane(new JsonDialog(value).getContentPane());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
