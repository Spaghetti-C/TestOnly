package com.yy.algorithm.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 楼梯组合问题
 * 给楼层n，每次只能走一步或两步，请问有多少种上楼组合。
 *
 * @author chenyiqin02
 * @date 2021/05/09
 */
public class StairsCombine {
    public static void main(String[] args) {
        int n = 10;
        Solution solution = new Solution();
        System.out.println(solution.recursion(n));
        System.out.println(solution.recursion2(n));
        System.out.println(solution.dynamicProgramming(n));
        System.out.println(solution.dynamicProgramming2(n));
    }

    static class Solution {
        Map<Integer, Integer> records = new HashMap<>(100);

        // 普通递归
        private int recursion(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            return recursion(n - 1) + recursion(n - 2);
        }

        // 使用map记录重复计算逻辑，减少递归
        private int recursion2(int n) {
            if (null != records.get(n)) {
                return records.get(n);
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }

            int left = recursion2(n - 1);
            records.put(n - 1, left);
            int right = recursion2(n - 2);
            records.put(n - 2, right);
            return left + right;
        }

        // 动态规划
        private int dynamicProgramming(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

        // 使用一个变量完成动态规划
        private int dynamicProgramming2(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }

            int a = 1;
            int b = 2;
            int temp;
            for (int i = 3; i <= n; i++) {
                temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }
    }
}
