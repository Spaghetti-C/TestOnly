//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1441 👎 0

//frontendQuestionId:146

package com.yy.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LruCache().new LRUCache(10);
        lruCache.put(10, 13);
        lruCache.put(3, 17);
        lruCache.put(6, 11);
        lruCache.put(10, 5);
        lruCache.put(9, 10);
        System.out.println(lruCache.get(13));
        lruCache.put(2, 19);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(5, 25);
        System.out.println(lruCache.get(8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        class DoublyLinkedNode {
            DoublyLinkedNode prev;
            DoublyLinkedNode next;
            int key;
            int value;

            DoublyLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, DoublyLinkedNode> map = new HashMap<>();
        DoublyLinkedNode tail;
        DoublyLinkedNode head;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            DoublyLinkedNode node = map.get(key);
            int val = node == null ? -1 : node.value;
            if (val != -1 && tail != node) {
                if (node.prev != null) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                } else {
                    head = head.next;
                    head.prev = null;
                }
                tail.next = node;
                node.prev = tail;
                tail = node;
                node.next = null;
            }
            return val;
        }

        public void put(int key, int value) {
            DoublyLinkedNode node = map.get(key);
            if (node != null) {
                node.value = value;
                if (tail != node) {
                    if (node.prev != null) {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                    node.next = null;
                }
            } else {
                node = new DoublyLinkedNode(key, value);
                if (head == null) {
                    head = node;
                    tail = node;
                    map.put(key, node);
                } else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                    map.put(key, node);
                    if (map.size() > capacity) {
                        DoublyLinkedNode temp = head;
                        head = head.next;
                        head.prev = null;
                        temp.next = null;
                        map.remove(temp.key);
                    }
                }
            }

        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}