//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1326 👎 0

//frontendQuestionId:17

package com.yy.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            List<String> list = new LinkedList<>();
            backtrack(digits, list, 0, "", map);
            return list;
        }

        private void backtrack(String digits, List<String> list, int index, String res, Map<Character, String> map) {
            int n = digits.length();
            if (digits.equals("")) {
                return;
            }
            if (index >= n) {
                list.add(res);
                return;
            }

            for (int j = 0; j < map.get(digits.charAt(index)).length(); j++) {
                res += map.get(digits.charAt(index)).charAt(j);
                backtrack(digits, list, index + 1, res, map);
                res = res.substring(0, res.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}