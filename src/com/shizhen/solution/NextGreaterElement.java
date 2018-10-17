package com.shizhen.solution;

import java.util.Arrays;

public class NextGreaterElement {

    /**
     * https://leetcode.com/problems/next-greater-element-iii/description/
     */
    public static int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray();
        int i;
        for (i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                break;
            }
        }
        if (i == 0) {
            return -1;
        }
        i--;
        int small = 0;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] > arr[i] && arr[j] <= arr[i + 1]) {
                small = j;
            }
        }
        char temp = arr[i];
        arr[i] = arr[small];
        arr[small] = temp;
        Arrays.sort(arr, i + 1, arr.length);
        long res = Long.parseLong(new String(arr));
        return res <= Integer.MAX_VALUE ? (int) res : -1;
    }

}
