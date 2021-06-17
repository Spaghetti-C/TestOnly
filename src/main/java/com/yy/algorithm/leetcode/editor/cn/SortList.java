//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
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
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1169 👎 0

//frontendQuestionId:148

package com.yy.algorithm.leetcode.editor.cn;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        ListNode head = new ListNode(4);
        ListNode next = head;
        next.next = new ListNode(2);
        next = next.next;
        next.next = new ListNode(3);
        next = next.next;
        next.next = new ListNode(1);
        solution.sortList(head);
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
        public ListNode sortList(ListNode head) {
            // todo
            return recursion(head, null);
        }

        private ListNode recursion(ListNode head, ListNode tail) {
            if (head == tail) {
                return head;
            }
            ListNode fast = head;
            ListNode slow = head;
            while (fast != tail && fast.next != tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode middle = slow.next;
            ListNode listNode1 = recursion(head, slow);
            ListNode listNode2 = recursion(middle, tail);
            return merge(listNode1, listNode2);
        }

        private ListNode merge(ListNode listNode1, ListNode listNode2) {
            if (listNode1 == null) {
                return listNode2;
            }
            if (listNode2 == null) {
                return listNode1;
            }

            ListNode head;
            if (listNode1.val > listNode2.val) {
                head = listNode2;
                listNode2 = listNode2.next;
            } else {
                head = listNode1;
                listNode1 = listNode1.next;
            }

            ListNode current = head;
            while (listNode1 != null && listNode2 != null) {
                if (listNode1.val > listNode2.val) {
                    current.next = listNode2;
                    current = current.next;
                    listNode2 = listNode2.next;
                } else {
                    current.next = listNode1;
                    current = current.next;
                    listNode1 = listNode1.next;
                }
            }

            if (listNode1 != null) {
                current.next = listNode1;
            }
            if (listNode2 != null) {
                current.next = listNode2;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}