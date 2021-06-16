//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1188 👎 0

//frontendQuestionId:76

package com.yy.algorithm.leetcode.editor.cn;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        String s = "acbbaca";
        String t = "aba";
        System.out.println(solution.minWindow(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int[] need = new int[128];
            int[] counts = new int[128];
            int length = t.length();
            int count = 0;
            String res = "";
            for (int i = 0; i < length; i++) {
                need[t.charAt(i)]++;
            }
            int l = 0;
            int r = 0;
            while (r < s.length()) {
                counts[s.charAt(r)]++;
                if (counts[s.charAt(r)] <= need[s.charAt(r)]) {
                    count++;
                }
                r++;

                while (count >= length) {
                    res = res.length() == 0 || (r - l) < res.length() ? s.substring(l, r) : res;

                    counts[s.charAt(l)]--;
                    count -= counts[s.charAt(l)] >= need[s.charAt(l)] ? 0 : 1;
                    l++;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}