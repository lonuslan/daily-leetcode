package com.lonuslan.dailyleetcode.chapter1;

import com.lonuslan.dailyleetcode.entity.ListNode;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/1/29 12:48
 * @description： add-two-numbers
 * @modified By：
 */
public class AddTwoNumbers {

    /**
     * problem description:
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */

    /**
     * approach: Elementary Math
     * Time complexity: O( max(m, n) )
     * Space complexity: O( max(m, n) )
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode<Integer> addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        ListNode<Integer> dommyhead = new ListNode<Integer>(0);
        ListNode<Integer> p = l1, q = l2, cur = dommyhead;
        int carry = 0;
        while (p != null || q != null){
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null){
                q = q.next;
            }
        }
        if (carry > 0){
            cur.next = new ListNode(1);
        }
        return dommyhead.next;
    }
}
