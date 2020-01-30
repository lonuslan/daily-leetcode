package com.lonuslan.daily_leetcode.chapter1;

import com.lonuslan.daily_leetcode.entity.ListNode;
import org.junit.Test;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/1/29 12:53
 * @description： add two numbers test
 * @modified By：
 */
public class AddTNTest {

    @Test
    public void testAddTwoNumbers(){

        ListNode<Integer> l1 = new ListNode<Integer>(2);
        l1.next = new ListNode<Integer>(4);
        l1.next.next = new ListNode<Integer>(3);

        System.out.println(l1);
        ListNode<Integer> l2 = new ListNode<Integer>(5);
        l2.next = new ListNode<Integer>(6);
        l2.next.next = new ListNode<Integer>(4);

        System.out.println(l2);
        ListNode<Integer> listNode = AddTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
