package com.yy.algorithm.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 最大收益
 * 小红练习吉他，不能长时间练习的时候都保持好的状态，初始状态为x，可以选择练习或者休息，如果练习的话，每小时收益x点，
 * 同时状态值下降a点（若x<a，下降x点），如果休息的话，每小时状态值上升b点。给出时间n，求最大收益。
 * 输入格式： t // 代表t组数据
 * （后面t行）[x，a，b，n]
 * <p></p>例子：
 * <p>输入：
 * 1
 * 10，5，5，3
 *
 * <p>输出：
 * 25
 *
 * @author chenyiqin02
 * @date 2021/05/09
 */
public class MaximumReturn {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(10, 5, 5, 3));
    }

    static class Solution {
        private Map<Integer, Integer> memo = new HashMap<>();
        public int solution(int x, int a, int b, int n) {
            if (n == 0) {
                return 0;
            }
            if (memo.get(x) != null) {
                return memo.get(x);
            }

            int relax = solution(x + b, a, b, n - 1);
            memo.put(x + b, relax);
            int practice = solution(x - a > 0 ? x - a : x, a, b, n - 1) + x;
            memo.put(x - a, practice);
            return Math.max(relax, practice);
        }
    }
}
