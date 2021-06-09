package com.yy.algorithm.daily;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description: 零一背包问题
 * 给你一个可装载重量为W的背包和N个物品，每个物品有重量和价值两个属性。其中第i个物品的重量为wt[i]，价值为val[i]，
 * 现在让你用这个背包装物品，最多能装的价值是多少？
 * <p>输入：
 * N = 3, W = 4
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 * </p>
 * <p>输出：6</p>
 * <p>
 * https://mp.weixin.qq.com/s/RXfnhSpVBmVneQjDSUSAVQ
 * </p>
 *
 * @author chenyiqin02
 * @date 2021/05/06
 */
public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int n = 3;
        int w = 4;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        System.out.println(new Solution().solution(n, w, wt, val));
        System.out.println(new Solution().solution2(n, w, wt, val));
    }

    static class Solution {
        // 二维数组动态规划
        public int solution(int n, int w, int[] wt, int[] val) {
            int[][] dp = new int[n + 1][w + 1];
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    if (j - wt[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                    }
                }
                System.out.println(Arrays.toString(dp[i]));
            }
            return dp[n][w];
        }

        // 一维数组动态规划
        public int solution2(int n, int w, int[] wt, int[] val) {
            int[] dp = new int[w + 1];

            for (int i = 1; i < n + 1; i++) {
                for (int j = w; j > 0; j--) {
                    if (j - wt[i - 1] >= 0) {
                        dp[j] = Math.max(dp[j], dp[j - wt[i - 1]] + val[i - 1]);
                    }
                }
                System.out.println(Arrays.toString(dp));
            }
            return dp[w];

        }

    }
}
