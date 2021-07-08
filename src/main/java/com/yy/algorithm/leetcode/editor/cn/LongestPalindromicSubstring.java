//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3667 👎 0

//frontendQuestionId:5
//https://mp.weixin.qq.com/s/ux6VSWAPwgOS32xlScr2kQ

package com.yy.algorithm.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("abadd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
//            return solution1(s);
//            return solution2(s);
            return solution3(s);
        }

        // 扩散查找
        private String solution1(String s) {
            int len = s.length();
            String res = "";

            for (int i = 0; i < len; i++) {
                String palindrome1 = palindrome(s, i, i);
                String palindrome2 = palindrome(s, i, i + 1);
                if (palindrome1.length() > res.length()) {
                    res = palindrome1;
                }
                if (palindrome2.length() > res.length()) {
                    res = palindrome2;
                }
            }
            return res;
        }

        private String palindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return s.substring(left + 1, right);
        }

        // 动规思维，并不比方法一好
        private String solution2(String s) {
            int len = s.length();
            int[][] dp = new int[len][len];
            String res = "";

            for (int i = 0; i < len; i++) {
                dp[i][i] = 1;
                res = s.substring(i, i + 1);
            }

            for (int i = len - 1; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    if ((dp[i + 1][j - 1] != 0 || j - i == 1) && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                        if (dp[i][j] > res.length()) {
                            res = s.substring(i, j + 1);
                        }
                    }
                }
            }
//            for (int i = 0; i < dp.length; i++) {
//                System.out.println(Arrays.toString(dp[i]));
//            }

            return res;
        }

        // manacher马拉车算法
        private String solution3(String s) {
            StringBuilder sb = new StringBuilder();
            int c = -1;
            int r = -1;
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                sb.append("#");
                sb.append(s.charAt(i));
            }
            sb.append("#");
            s = sb.toString();
            int length = s.length();
            int[] radius = new int[length];

            for (int i = 0; i < length; i++) {
                radius[i] = r > i ? Math.min(radius[2 * c - i], r - i) : 0;
                while (i - radius[i] - 1 >= 0 && i + radius[i] + 1 < length) {
                    if (s.charAt(i - radius[i] - 1) != s.charAt(i + radius[i] + 1)) {
                        break;
                    }
                    radius[i]++;
                }
                if (i + radius[i] > r) {
                    if (res.length() < radius[i] * 2 + 1) {
                        res = s.substring(i - radius[i], i + radius[i] + 1);
                    }
                    r = i + radius[i];
                    c = i;
                }
            }
            return res.replace("#", "");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}