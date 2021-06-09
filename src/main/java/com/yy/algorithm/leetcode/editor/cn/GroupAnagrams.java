//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 755 👎 0

//frontendQuestionId:49

package com.yy.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        String[] strs = {"bdddddddddd", "bbbbbbbbbbc"};
        System.out.println(solution.groupAnagrams(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 桶排序
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                int[] count = new int[26];
                for (int j = 0; j < strs[i].length(); j++) {
                    count[strs[i].charAt(j) - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    sb.append(count[j] + " ");
                }
                List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
                list.add(strs[i]);
                map.put(sb.toString(), list);
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}