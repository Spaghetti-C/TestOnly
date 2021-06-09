//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 962 👎 0

//frontendQuestionId:56

package com.yy.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = solution.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 排序后合并
        public int[][] merge(int[][] intervals) {
            List<int[]> list = new ArrayList<>();
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            for (int i = 0; i < intervals.length; i++) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                if (list.size() == 0 || list.get(list.size() - 1)[1] < left) {
                    list.add(new int[]{left, right});
                } else {
                    list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
                }
            }
            return list.toArray(new int[list.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}