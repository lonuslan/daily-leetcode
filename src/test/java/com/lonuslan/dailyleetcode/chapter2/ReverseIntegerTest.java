package com.lonuslan.dailyleetcode.chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/2 21:40
 * @description： reverse integer test
 * @modified By：
 */
public class ReverseIntegerTest {

    @Test
    public void testReverseInteger(){
        int a = 321;
        int b = -123;
        int c = 210;

        System.out.println(ReverseInteger.reverse(a));
        System.out.println(ReverseInteger.reverse(b));
        System.out.println(ReverseInteger.reverse(c));

        Assert.assertEquals("isOrNotEqual", 123, ReverseInteger.reverse(a));
        Assert.assertEquals("isOrNotEqual", -321, ReverseInteger.reverse(b));
        Assert.assertEquals("isOrNotEqual", 12, ReverseInteger.reverse(c));

    }
}
