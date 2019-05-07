package com.raindrop;

/**
 * @Name: com.raindrop.JsonUtil.java
 * @Description:
 * @Author: Wang Liang
 * @Create Time: 2019/5/7 9:43
 */
public class JsonUtil {

	public static String jsonFormat(String text) {
		StringBuilder sb = new StringBuilder();
		int tabNum = 0;
		for (int i = 0; i < text.length(); i++) {
			char charValue = text.charAt(i);
			if ('{' == charValue || '[' == charValue) {
                if (i - 1 > 0 && text.charAt(i - 1) == ':') {
					sb.append("\n");
					sb.append(geneSpace(tabNum));
				}
				tabNum++;
				sb.append(charValue);
				sb.append("\n");
				sb.append(geneSpace(tabNum));
			} else if ('}' == charValue || ']' == charValue) {
				tabNum--;
				sb.append("\n");
				sb.append(geneSpace(tabNum));
				sb.append(charValue);
			} else if (',' == charValue) {
				sb.append(charValue);
				sb.append("\n");
				sb.append(geneSpace(tabNum));
			} else {
				sb.append(charValue);
			}
		}
		return sb.toString();
	}

	private static String geneSpace(int tabNum) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tabNum; i++) {
			sb.append("    ");
		}
		return sb.toString();
	}

}
