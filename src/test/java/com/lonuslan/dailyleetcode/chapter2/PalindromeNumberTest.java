package com.lonuslan.dailyleetcode.chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/3 17:45
 * @description： palindrome number test
 * @modified By：
 */
public class PalindromeNumberTest {

    @Test
    public void testPalindromeNumber(){

        int a = 121;
        int b = -121;
        int c = 10;

        System.out.println(PalindromeNumber.isPalindrome(a));
        System.out.println(PalindromeNumber.isPalindrome(b));
        System.out.println(PalindromeNumber.isPalindrome(c));

        Assert.assertTrue(true == PalindromeNumber.isPalindrome(a));
        Assert.assertTrue(false == PalindromeNumber.isPalindrome(b));
        Assert.assertTrue(true != PalindromeNumber.isPalindrome(c));
    }
}
