//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 链表 
// 👍 1787 👎 0

//frontendQuestionId:206

package com.yy.algorithm.leetcode.editor.cn;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        next.next = new ListNode(3);
        next = next.next;
        next.next = new ListNode(4);
        next = next.next;
        next.next = new ListNode(5);
        solution.reverseList(head);
    }

    public static class ListNode {
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
        public ListNode reverseList(ListNode head) {
//            return solution1(head);
            return solution2(head);
        }

        private ListNode solution1(ListNode head) {
            ListNode next = head;
            ListNode prev = null;
            while (head != null) {
                next = next.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }

        private ListNode solution2(ListNode head) {
            if (head == null) {
                return head;
            }
            return recursion(head, null, head);
        }

        private ListNode recursion(ListNode head, ListNode prev, ListNode next) {
            if (head == null) {
                return prev;
            }
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;

            return recursion(head, prev, next);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}