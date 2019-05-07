package com.raindrop;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @name: com.raindrop.JsonDialog.java
 * @description:
 * @author: Wang Liang
 * @create Time: 2019/5/7 9:43
 */
public class JsonDialog extends JFrame {
	private JPanel contentPane;
	private JScrollPane scroll;
	private JEditorPane editPane;
	private JLabel tips;

	public JsonDialog(String text) {
		setContentPane(contentPane);
		setTitle("Json Data Format");
		editPane.setText(text);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});
		contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

	}

	private void onCancel() {
		dispose();
	}

}

