package com.yy.algorithm.daily;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * 一个无序的数组，找出所有符合以下特点的数，返回它们的索引。
 * 这个数的左边的数都小于它，右边的数都大于等于它。
 * 要求时间复杂度 O(n) 。
 * <p>
 * https://leetcode-cn.com/circle/discuss/q5wVRM/
 *
 * @author chenyiqin02
 * @date 2021/08/11
 */
public class LeftMaxRightMinNum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 7, 6, 5};
        System.out.println(solution(nums));
        nums = new int[]{2, 1, 3, 4, 5, 7, 6};
        System.out.println(solution(nums));
        nums = new int[]{7, 6, 5, 4, 3, 2, 1};
        System.out.println(solution(nums));
        nums = new int[]{6, 5, 4, 3, 2, 1, 7};
        System.out.println(solution(nums));
        nums = new int[]{1, 7, 6, 5, 4, 3, 2};
        System.out.println(solution(nums));
    }

    static int solution(int[] nums) {
        Deque<Integer> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] > nums[i]) {
                queue.pollLast();
            }
            if (nums[i] > max) {
                max = nums[i];
                queue.addLast(i);
            }
        }
        if (!queue.isEmpty()) {
            return queue.peekFirst();
        }
        return -1;
    }
}
