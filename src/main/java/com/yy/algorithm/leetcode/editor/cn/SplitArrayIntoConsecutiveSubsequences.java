//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 :
//1, 2, 3
//3, 4, 5
//
//
// 示例 2：
//
//
//输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 :
//1, 2, 3, 4, 5
//3, 4, 5
//
//
// 示例 3：
//
//
//输入: [1,2,3,4,4,5]
//输出: False
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10000
//
// Related Topics 堆 贪心算法
// 👍 304 👎 0

//frontendQuestionId:659

package com.yy.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {
    public static void main(String[] args) {
        Solution solution = new SplitArrayIntoConsecutiveSubsequences().new Solution();
        int[] nums = {1, 2, 3, 4, 4, 5};
        System.out.println(solution.isPossible(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer, Integer> frequence = new HashMap<>();
            Map<Integer, List<List<Integer>>> need = new HashMap<>();
            for (int i : nums) {
                frequence.put(i, frequence.get(i) == null ? 1 : frequence.get(i) + 1);
            }
            for (int i : nums) {
                if (frequence.get(i) == 0) {
                    continue;
                }

                if (need.get(i) != null && need.get(i).size() > 0) {
                    frequence.put(i, frequence.get(i) - 1);
                    List<Integer> list = need.get(i).get(0);
                    list.add(i);
                    List<List<Integer>> lists = need.get(i + 1);
                    if (lists == null) {
                        lists = new LinkedList<>();
                        need.put(i + 1, lists);
                    }
                    lists.add(list);
                    need.get(i).remove(0);
                } else if (frequence.get(i) != null && frequence.get(i + 1) != null && frequence.get(i + 2) != null
                        && frequence.get(i) > 0 && frequence.get(i + 1) > 0 && frequence.get(i + 2) > 0) {
                    frequence.put(i, frequence.get(i) - 1);
                    frequence.put(i + 1, frequence.get(i + 1) - 1);
                    frequence.put(i + 2, frequence.get(i + 2) - 1);
                    List<Integer> list = new LinkedList<>();
                    list.add(i);
                    list.add(i + 1);
                    list.add(i + 2);
                    if (need.get(i + 3) != null) {
                        need.get(i + 3).add(list);
                    } else {
                        List<List<Integer>> lists = new LinkedList<>();
                        lists.add(list);
                        need.put(i + 3, lists);
                    }
                } else {
                    return false;
                }
            }

            for (Map.Entry<Integer, List<List<Integer>>> entry : need.entrySet()) {
                for (List<Integer> integers : entry.getValue()) {
                    System.out.println(integers);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}