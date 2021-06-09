//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1320 👎 0

//frontendQuestionId:23

package com.yy.algorithm.leetcode.editor.cn;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
//        MergeKSortedLists.ListNode l1 = new MergeKSortedLists.ListNode(5, null);
//        l1 = new MergeKSortedLists.ListNode(4, l1);
//        l1 = new MergeKSortedLists.ListNode(1, l1);
//        MergeKSortedLists.ListNode l2 = new MergeKSortedLists.ListNode(4, null);
//        l2 = new MergeKSortedLists.ListNode(3, l2);
//        l2 = new MergeKSortedLists.ListNode(1, l2);
//        MergeKSortedLists.ListNode l3 = new MergeKSortedLists.ListNode(6, null);
//        l3 = new MergeKSortedLists.ListNode(2, l3);
//        ListNode[] lists = new ListNode[3];
//        lists[0] = l1;
//        lists[1] = l2;
//        lists[2] = l3;
        ListNode[] lists = new ListNode[1];
        lists[0] = null;
        System.out.println(solution.mergeKLists(lists));
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return recursion(lists, 0, lists.length - 1);
        }

        // 分治外加合并两个链表思路
        private ListNode recursion(ListNode[] lists, int left, int right) {
            if (lists.length == 0) {
                return null;
            }
            if (right - left == 1) {
                return mergeTwoLists(lists[left], lists[right]);
            }
            if (left >= right) {
                return lists[left];
            }
            int middle = (left + right) / 2;
            ListNode l1 = recursion(lists, left, middle);
            ListNode l2 = recursion(lists, middle + 1, right);
            return mergeTwoLists(l1, l2);
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            ListNode head;
            if (l1.val < l2.val) {
                head = l1;
                l1 = l1.next;
            } else {
                head = l2;
                l2 = l2.next;
            }
            ListNode current = head;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    current.next = l1;
                    current = current.next;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    current = current.next;
                    l2 = l2.next;
                }
            }
            if (l1 != null) {
                current.next = l1;
            } else {
                current.next = l2;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}