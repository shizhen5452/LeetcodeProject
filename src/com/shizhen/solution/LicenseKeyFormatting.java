package com.shizhen.solution;

import java.util.Stack;

/**
 * https://leetcode.com/problems/license-key-formatting/
 */
public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int K) {
        String str = S.replaceAll("-", "");
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            stack.push(str.charAt(i));
            index++;
            if (index % K == 0 && i != 0) {
                stack.push('-');
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString().toUpperCase();
    }

}
