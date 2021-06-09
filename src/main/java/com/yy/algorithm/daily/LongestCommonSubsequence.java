package com.yy.algorithm.daily;

import java.util.Arrays;

/**
 * Description: 最长公共子序列
 * 输入: str1 = "abcde", str2 = "ace"
 * 输出: 3
 * 解释: 最长公共子序列是 "ace"，它的长度是 3
 * https://mp.weixin.qq.com/s/SUJ35XDpTn5OKU7hud-tPw
 *
 * @author chenyiqin02
 * @date 2021/05/17
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String txt = "abcde";
        String pat = "ace";
        System.out.println(new Solution().solution(txt, pat));
    }

    static class Solution {
        public int solution(String txt, String pat) {
            int[][] dp = new int[pat.length() + 1][txt.length() + 1];

            for (int i = 1; i <= pat.length(); i++) {
                for (int j = 1; j <= txt.length(); j++) {
                    if (pat.charAt(i - 1) == txt.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
                System.out.println(Arrays.toString(dp[i]));
            }
            return dp[pat.length()][txt.length()];
        }
    }
}
