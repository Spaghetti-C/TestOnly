package com.yy.algorithm.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 三数之和
 * 两数之和的扩展版
 * https://mp.weixin.qq.com/s/6URHrb2o5659QCU32bNWIQ
 *
 * @author chenyiqin02
 * @date 2021/05/08
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {5, 12, 6, 3, 9, 2, 1, 7};
        int target = 13;
        System.out.println(new Solution().solution(nums, target));
    }

    static class Solution {
        public List<Integer> solution(int[] nums, int target) {
            List<Integer> rst = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                int tempTarget = target - nums[i];
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[j] + nums[k];
                    while (j < k && sum > tempTarget) {
                        k--;
                        sum = nums[j] + nums[k];
                    }
                    while (j < k && sum < tempTarget) {
                        j++;
                        sum = nums[j] + nums[k];
                    }
                    if (j != k && sum == tempTarget) {
                        rst.add(nums[i]);
                        rst.add(nums[j]);
                        rst.add(nums[k]);
                        k--;
                    }
                }
            }

            return rst;
        }
    }
}
