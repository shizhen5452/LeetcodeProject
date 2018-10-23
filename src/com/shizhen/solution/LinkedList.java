package com.shizhen.solution;

import com.shizhen.model.ListNode;

public class LinkedList {

    /**
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode firstNode = node;
        ListNode secondNode = node;
        for (int i = 0; i <= n; i++) {
            secondNode = secondNode.next;
        }
        while (secondNode != null) {
            secondNode = secondNode.next;
            firstNode = firstNode.next;
        }
        firstNode.next = firstNode.next.next;
        return node.next;
    }

}
