package com.shizhen.solution;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    /**
     * https://leetcode.com/problems/n-queens/description/
     */
    public static List<List<String>> solveNQueen(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] cols = new int[n];
        search(res, cols, n, 0);
        return res;
    }

    private static void search(List<List<String>> res, int[] cols, int n, int i) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            for (int col = 0; col < cols.length; col++) {
                StringBuilder sb = new StringBuilder();
                for (int row = 0; row < n; row++) {
                    if (row == cols[col]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
        } else {
            for (int row = 0; row < n; row++) {
                cols[i] = row;
                if (isValid(cols, i)) {
                    search(res, cols, n, i + 1);
                }
            }
        }
    }

    private static boolean isValid(int[] cols, int i) {
        for (int index = 0; index < i; index++) {
            if (cols[index] == cols[i] || Math.abs(cols[index] - cols[i]) == i - index) {
                return false;
            }
        }
        return true;
    }

}
