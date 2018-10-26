package com.shizhen.solution;

public class SumOfTwoIntegers {

    /**
     * https://leetcode.com/problems/sum-of-two-integers/description/
     */
    public static int getSum(int a, int b) {
        while (b != 0) {
            int c = a & b;
            a ^= b;
            b = c << 1;
        }
        return a;
    }

}
