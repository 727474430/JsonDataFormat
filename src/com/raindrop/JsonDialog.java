package com.raindrop;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author wl
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
//		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});
		contentPane.registerKeyboardAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

	}

	private void onCancel() {
		dispose();
	}

	public static void main(String[] args) {
		String str = "{ 'kind': 'youtube#searchListResponse', 'etag': 'k1sYjErg4tK7WaQQxvJkW5fVrfg/usRLzp_l5ss-L8Yb9ScY-VDAEOo', 'nextPageToken': 'CAIQAA', 'pageInfo': { 'totalResults': 1000000, 'resultsPerPage': 2 }, 'items': [ { 'kind': 'youtube#searchResult', 'etag': 'k1sYjErg4tK7WaQQxvJkW5fVrfg/D0nlqgSgFFEQnTduJtwcQZ3Hc78', 'id': { 'kind': 'youtube#video', 'videoId': '5ixFWqZGZr8' }, 'snippet': { 'publishedAt': '2014-10-16T19:43:41.000Z', 'channelId': 'UC9-3c4LzdzT_HvW3Xuti9wg', 'title': 'Q&A WITH HARRY | PRANK CALLS!', 'description': 'Can we smash 4000 likes for this Q&A!? My Flatmate Harold - http://www.youtube.com/W2S Buy Cheap and Instant Coins here: http://goo.gl/IZyNg2 Use code ...', 'thumbnails': { 'default': { 'url': 'https://i.ytimg.com/vi/5ixFWqZGZr8/default.jpg' }, 'medium': { 'url': 'https://i.ytimg.com/vi/5ixFWqZGZr8/mqdefault.jpg' }, 'high': { 'url': 'https://i.ytimg.com/vi/5ixFWqZGZr8/hqdefault.jpg' } }, 'channelTitle': 'Calfreezy', 'liveBroadcastContent': 'none' } }, { 'kind': 'youtube#searchResult', 'etag': 'k1sYjErg4tK7WaQQxvJkW5fVrfg/R5nmI-OBXmHyiXsGtMC3J6IUlBs', 'id': { 'kind': 'youtube#video', 'videoId': '8KgzATFR0As' }, 'snippet': { 'publishedAt': '2014-09-03T12:49:15.000Z', 'channelId': 'UC8_yRRDIGFaJEC7NOc1qTMw', 'title': 'Harry at 30 Documentary', 'description': 'In celebration of Prince Harry's 30th birthday, ITV have released a new documentary celebrating the past three decades of his life. Featuring archive footage...', 'thumbnails': { 'default': { 'url': 'https://i.ytimg.com/vi/8KgzATFR0As/default.jpg' }, 'medium': { 'url': 'https://i.ytimg.com/vi/8KgzATFR0As/mqdefault.jpg' }, 'high': { 'url': 'https://i.ytimg.com/vi/8KgzATFR0As/hqdefault.jpg' } }, 'channelTitle': '', 'liveBroadcastContent': 'none' } } ] }";
		JFrame frame = new JFrame("JsonDialog");
		frame.setContentPane(new JsonDialog("").contentPane);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

