package com.zhengyuli.lzyapp.util;

import android.text.TextUtils;

/**
 * author: zhengyu.li
 * description:
 * date: 2015/8/26
 */
public class StringUtil {
    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input 需要判断字符串
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * 将多个字符串用指定的字符做分隔符连接
     *
     * @param c
     * @param strs
     * @return
     */
    public static String concatWith(String c, String... strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            if (TextUtils.isEmpty(s)) {
                continue;
            } else {
                if (sb.length() > 0) {
                    sb.append(c);
                }
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
