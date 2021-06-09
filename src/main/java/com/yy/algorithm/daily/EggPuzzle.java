package com.yy.algorithm.daily;

/**
 * Description: 扔鸡蛋问题
 * 你面前有一栋从 1 到N共N层的楼，然后给你K个鸡蛋（K至少为 1）。现在确定这栋楼存在楼层0 <= F <= N，在这层楼将鸡蛋扔下去，
 * 鸡蛋恰好没摔碎（高于F的楼层都会碎，低于F的楼层都不会碎）。现在问你，最坏情况下，你至少要扔几次鸡蛋，才能确定这个楼层F呢？
 * <p>https://mp.weixin.qq.com/s/xn4LjWfaKTPQeCXR0qDqZg</p>
 * <p>https://mp.weixin.qq.com/s/7XPGKe7bMkwovH95cnhang</p>
 *
 * @author chenyiqin02
 * @date 2021/05/07
 */
public class EggPuzzle {
    public static void main(String[] args) {
        Solution solution = new EggPuzzle().new Solution();
//        System.out.println(solution.solution(100, 2));
//        System.out.println(solution.solution2(100, 2));
        System.out.println(solution.solution3(100, 2));
    }

    class Solution {
        private int[][] memo = new int[200][200];

        // 动态规划，时间复杂度 O(KN^2)
        public int solution(int n, int k) {
            if (n == 0) {
                return 0;
            }
            if (k == 1) {
                return n;
            }
            if (memo[n][k] != 0) {
                return memo[n][k];
            }
            int rst = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                rst = Math.min(rst, Math.max(solution(i - 1, k - 1), solution(n - i, k)) + 1);
            }
            memo[n][k] = rst;

            return rst;
        }

        // 动态规划加二分查找优化，时间复杂度 O(K*N*logN)
        public int solution2(int n, int k) {
            if (n == 0) {
                return 0;
            }
            if (k == 1) {
                return n;
            }
            if (memo[n][k] != 0) {
                return memo[n][k];
            }

            int left = 1;
            int right = n;
            int rst = Integer.MAX_VALUE;
            while (left <= right) {
                int middle = (left + right) / 2;
                int broken = solution2(middle - 1, k - 1);
                int notBroken = solution2(n - middle, k);
                if (broken > notBroken) {
                    right = middle - 1;
                    rst = Math.min(rst, broken + 1);
                } else {
                    left = middle + 1;
                    rst = Math.min(rst, notBroken + 1);
                }
            }
            memo[n][k] = rst;
            return rst;
        }

        // 动态规划，二维数组
        public int solution3(int n, int k) {
            int[][] dp = new int[k + 1][n + 1];
            int m = 0;

            while (dp[k][m] < n) {
                m++;
                for (int i = 1; i <= k; i++) {
                    dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
                }
            }
            return m;
        }
    }
}
