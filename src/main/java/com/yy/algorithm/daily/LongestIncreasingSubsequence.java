package com.yy.algorithm.daily;

import java.util.Arrays;

/**
 * Description: 最长递增子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例：
 * 输入：[10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长的上升子序列是[2,3,7,101]，他的长度是4。
 * <p>https://mp.weixin.qq.com/s/02o_OPgePjaz3dXnw9TA1w</p>
 *
 * @author chenyiqin02
 * @date 2021/05/08
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution().solution(nums));
    }

    static class Solution {
        // 动态规划解决方案
        public int solution(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int rst = 0;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            for (int i = 0; i < dp.length; i++) {
                rst = Math.max(rst, dp[i]);
            }
            return rst;
        }
    }
}
