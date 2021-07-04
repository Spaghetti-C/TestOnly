package com.yy.algorithm.daily;

/**
 * Description: 圆环回到原点问题
 * 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
 * https://mp.weixin.qq.com/s/NZPaFsFrTybO3K3s7p7EVg
 *
 * @author chenyiqin02
 * @date 2021/07/02
 */
public class BackToOrigin {
    public static void main(String[] args) {
        Solution solution = new BackToOrigin().new Solution();
        System.out.println(solution.backToOrigin(2));
    }

    class Solution {
        public int backToOrigin(int n) {
            int k = 10;
            int[][] dp = new int[n + 1][k];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < k; j++) {
                    dp[i][j] = dp[i - 1][(j - 1 + k) % k] + dp[i - 1][(j + 1) % k];
                }
            }
            return dp[n][0];
        }

    }
}
