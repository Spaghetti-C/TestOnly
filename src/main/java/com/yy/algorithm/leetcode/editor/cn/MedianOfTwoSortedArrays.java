//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 4109 👎 0

//frontendQuestionId:4
//https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/hard/4.median-of-two-sorted-arrays#guan-jian-dian-fen-xi

package com.yy.algorithm.leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {2, 3};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int m = nums1.length;
            int n = nums2.length;
            int low = 0;
            int high = m;

            while (low <= high) {
                int i = (low + high) / 2;
                int j = (m + n + 1) / 2 - i;
                int left1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
                int right1 = i == m ? Integer.MAX_VALUE : nums1[i];
                int left2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
                int right2 = j == n ? Integer.MAX_VALUE : nums2[j];

                if (left1 <= right2 && left2 <= right1) {
                    if ((m + n) % 2 == 0) {
                        return (double) (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                    } else {
                        return Math.max(left1, left2);
                    }
                } else if (left1 > right2) {
                    high = i - 1;
                } else {
                    low = i + 1;
                }
            }
            return 0D;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}