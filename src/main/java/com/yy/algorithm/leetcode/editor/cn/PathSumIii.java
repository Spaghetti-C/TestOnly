//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 902 👎 0

//frontendQuestionId:437

package com.yy.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        System.out.println(solution.pathSum(root, 8));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            return dfs(root, targetSum, 0, map);
        }


        private int dfs(TreeNode root, int targetSum, int current, Map<Integer, Integer> map) {
            int res = 0;
            if (root == null) {
                return res;
            }
            current += root.val;
            if (map.get(current - targetSum) != null) {
                res += map.get(current - targetSum);
            }
            map.put(current, map.getOrDefault(current, 0) + 1);
            int left = dfs(root.left, targetSum, current, map);
            int right = dfs(root.right, targetSum, current, map);
            map.put(current, map.getOrDefault(current, 0) - 1);
            return res + left + right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}