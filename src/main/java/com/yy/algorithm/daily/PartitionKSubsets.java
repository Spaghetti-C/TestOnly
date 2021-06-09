package com.yy.algorithm.daily;

/**
 * Description: 等和分割k个子集
 * 给你输入一个数组nums和一个正整数k，请你判断nums是否能够被平分为元素和相同的k个子集。
 * https://mp.weixin.qq.com/s/fsLKaWBvSWtM0jA-CfOxyA
 *
 * @author chenyiqin02
 * @date 2021/05/18
 */
public class PartitionKSubsets {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        Solution solution = new Solution();
        System.out.println(solution.canPartitionKSubsets(nums, k));
        System.out.println(solution.canPartitionKSubsets2(nums, k));
    }

    static class Solution {
        // 视角：数字进入不同的桶
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if (sum % k != 0) {
                return false;
            }
            int target = sum / k;
            int[] buckets = new int[k];
            return backtrack(nums, buckets, target, 0);
        }

        private boolean backtrack(int[] nums, int[] buckets, int target, int index) {
            if (index == nums.length) {
                for (int i : buckets) {
                    if (i != target) {
                        return false;
                    }
                }
                return true;
            }

            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] + nums[index] > target) {
                    continue;
                }
                buckets[i] += nums[index];
                if (backtrack(nums, buckets, target, index + 1)) {
                    return true;
                }
                buckets[i] -= nums[index];
            }
            return false;
        }

        // 视角：桶加入不同的数字
        public boolean canPartitionKSubsets2(int[] nums, int k) {
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if (sum % k != 0) {
                return false;
            }
            int target = sum / k;
            boolean[] used = new boolean[nums.length];
            return backtrack2(nums, 0, target, 0, k, used);
        }

        public boolean backtrack2(int[] nums, int bucket, int target, int index, int k, boolean[] used) {
            if (k == 0) {
                return true;
            }
            if (bucket == target) {
                return backtrack2(nums, 0, target, 0, k - 1, used);
            }

            for (int i = index; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (bucket + nums[i] > target) {
                    continue;
                }
                used[i] = true;
                bucket += nums[i];
                if (backtrack2(nums, bucket, target, i + 1, k, used)) {
                    return true;
                }
                used[i] = false;
                bucket -= nums[i];
            }
            return false;
        }
    }
}
