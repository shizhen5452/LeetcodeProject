package com.shizhen.solution;

public class GlobalAndLocalInversions {

    /**
     * https://leetcode.com/problems/global-and-local-inversions/description/
     */
    public static boolean isIdealPermutation(int[] A) {
        int len = A.length;
        if (len < 3) {
            return true;
        }
        int max = A[0];
        for (int i = 0; i < len - 2; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (max > A[i + 2]) {
                return false;
            }
        }
        return true;
    }

}
