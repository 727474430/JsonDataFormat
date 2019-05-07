package com.raindrop;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * @name: com.raindrop.JsonDataFormat.java
 * @description:
 * @author: Wang Liang
 * @create Time: 2019/5/7 9:43
 */
public class JsonDataFormat extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // 得到Editor
        final Editor editor = e.getData(PlatformDataKeys.EDITOR);
        // 获取SelectModel
        SelectionModel selectionModel = editor.getSelectionModel();
        // 得到用户选择的内容
        String selectedText = selectionModel.getSelectedText();
        if (selectedText != null && !"".equals(selectedText.trim())) {
            // 格式化后的内容
            String value = JsonUtil.jsonFormat(selectedText);
            // 得到系统剪贴板
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(value), null);
            // Show JsonDialog
            showJsonDialog(value);
        }
    }

    /**
     * Show dialog frame
     *
     * @param value
     */
    private void showJsonDialog(String value) {
        JFrame frame = new JFrame("JsonDialog");
        frame.setContentPane(new JsonDialog(value).getContentPane());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
