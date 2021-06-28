//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 数组 动态规划 
// 👍 808 👎 0

//frontendQuestionId:309

package com.yy.algorithm.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int length = prices.length;
            if (length == 0) {
                return 0;
            }
            int[][] dp = new int[length][3];
            dp[0][0] = -prices[0];
            for (int i = 1; i < length; i++) {
                // dp[i][0]表示持有股票；则i-1日持有股票或者未持有股票且未在冷冻期
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                // dp[i][1]表示未持有股票，且在冷冻期；则i-1日售出股票
                dp[i][1] = dp[i - 1][0] + prices[i];
                // dp[i][2]表示未持有股票，且未在冷冻期；则i-1日未持有股票，在或者不在冷冻期
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }

            return Math.max(dp[length - 1][1], dp[length - 1][2]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}