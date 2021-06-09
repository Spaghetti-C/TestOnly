//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 动态规划 
// 👍 781 👎 0
package com.yy.algorithm.leetcode.editor.cn;

/**
 * Description: 等和分割子集问题
 * <p>https://mp.weixin.qq.com/s/OzdkF30p5BHelCi6inAnNg</p>
 *
 * @author chenyiqin02
 * @date 2021/5/14
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();
        int[] nums = new int[4];
        nums[0] = 1;
        nums[1] = 5;
        nums[2] = 11;
        nums[3] = 5;
        System.out.println(solution.canPartition(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            boolean rst = solution(nums);
//            boolean rst = solution2(nums);
            return rst;
        }

        // 使用零一背包思维进行解决
        // 二维数组动态规划
        public boolean solution(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (0 != sum % 2) {
                return false;
            }
            sum = sum / 2;
            boolean[][] dp = new boolean[nums.length + 1][sum + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = true;
            }
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < sum + 1; j++) {
                    if (j - nums[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            for (boolean[] booleans : dp) {
                for (boolean aBoolean : booleans) {
                    System.out.print(aBoolean + "\t");
                }
                System.out.println("");
            }

            return dp[nums.length][sum];
        }

        // 一维数组动态规划
        public boolean solution2(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 != 0) {
                return false;
            }
            sum = sum / 2;
            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            for (int i = 1; i < nums.length + 1; i++) {
                for (int j = sum; j > 0; j--) {
                    if (j - nums[i - 1] >= 0) {
                        dp[j] = dp[j] || dp[j - nums[i - 1]];
                    }
                }

                for (int j = 0; j < sum + 1; j++) {
                    System.out.print(dp[j] + "\t");
                }
                System.out.println();
            }

            return dp[sum];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}