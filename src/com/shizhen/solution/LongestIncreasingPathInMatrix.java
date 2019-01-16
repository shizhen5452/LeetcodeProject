package com.shizhen.solution;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInMatrix {
    private static int[] nextSteps = {0, 1, 0, -1, 1, 0, -1, 0};
    private static int m;
    private static int n;

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length <=0 || matrix[0].length <=0) {
            return 0;
        }
        int res = 1;
        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, matrix, dp));
            }
        }
        return res;
    }

    private static int dfs(int x, int y, int[][] matrix, int[][] dp) {
        if (dp[x][y] > 0) {
            return dp[x][y];
        }
        int max = 1;
        for (int i = 0; i < nextSteps.length; i += 2) {
            int newX = x + nextSteps[i];
            int newY = y + nextSteps[i + 1];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || matrix[newX][newY] <= matrix[x][y]) {
                continue;
            }
            max = Math.max(max, 1 + dfs(newX, newY, matrix, dp));
        }
        dp[x][y] = max;
        return max;
    }

}
