//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 
// 👍 796 👎 0

//frontendQuestionId:394

package com.yy.algorithm.leetcode.editor.cn;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        solution.decodeString("3[a]2[bc]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            return recursion(s);
        }

        int index = 0;
        private String recursion(String s) {
            if (index == s.length() || s.charAt(index) == ']') {
                return "";
            }

            String ret = "";
            if (Character.isDigit(s.charAt(index))) {
                int num = 0;
                // 获取数字
                while (Character.isDigit(s.charAt(index))) {
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                // 跳过左括号
                index++;
                // 获取字母
                String str = recursion(s);
                // 跳过右括号
                index++;
                while (num > 0) {
                    ret += str;
                    num--;
                }
            } else if (Character.isLetter(s.charAt(index))) {
                ret = String.valueOf(s.charAt(index));
                index++;
            }
            return ret + recursion(s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}