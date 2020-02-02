package com.lonuslan.dailyleetcode.chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/2 22:08
 * @description：
 * @modified By：
 */
public class StringToIntegerAtoiTest {

    @Test
    public void testMyAtoi(){
        String s1 = "42";
        String s2 = "    -24";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";

        System.out.println(StringToIntegerAtoi.myAtoi(s1));
        System.out.println(StringToIntegerAtoi.myAtoi(s2));
        System.out.println(StringToIntegerAtoi.myAtoi(s3));
        System.out.println(StringToIntegerAtoi.myAtoi(s4));
        System.out.println(StringToIntegerAtoi.myAtoi(s5));

        Assert.assertEquals(42, StringToIntegerAtoi.myAtoi(s1));
        Assert.assertEquals(-24, StringToIntegerAtoi.myAtoi(s2));
        Assert.assertEquals(4193, StringToIntegerAtoi.myAtoi(s3));
        Assert.assertEquals(0, StringToIntegerAtoi.myAtoi(s4));
        Assert.assertEquals(-2147483648, StringToIntegerAtoi.myAtoi(s5));
    }
}
