package com.yy.algorithm.daily;

import java.util.Arrays;

/**
 * Description: 最长回文子序列
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000.
 * 示例1：
 * 输入："bbbab"
 * 输出：4
 *
 * https://mp.weixin.qq.com/s/zNai1pzXHeB2tQE6AdOXTA
 *
 * @author chenyiqin02
 * @date 2021/05/17
 */
public class LongestPalindromeSubsequence {
    public static void main(String[] args) {
        String txt = "bbbab";
        System.out.println(new Solution().solution(txt));
    }

    static class Solution {
        public int solution(String txt) {
            int[][] dp = new int[txt.length()][txt.length()];

            for (int i = 0; i < txt.length(); i++) {
                dp[i][i] = 1;
            }

            for (int i = txt.length() - 1; i >= 0; i--) {
                for (int j = i + 1; j < txt.length(); j++) {
                    if (txt.charAt(i) == txt.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            for (int i = 0; i < dp.length; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
            return dp[0][txt.length() - 1];
        }
    }
}
