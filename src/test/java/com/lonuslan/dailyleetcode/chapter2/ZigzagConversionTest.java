package com.lonuslan.dailyleetcode.chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/1 17:24
 * @description： test zigzag conversion
 * @modified By：
 */
public class ZigzagConversionTest {

    @Test
    public void testZigzagConversion_approach_1(){
        String s = "PAYPALISHIRING";
        System.out.println(ZigzagConversion.convert(s, 3));
        Assert.assertEquals("isOrNot", "PAHNAPLSIIGYIR", ZigzagConversion.convert(s, 3));
    }

    @Test
    public void testZigzagConversion_approach_2(){
        String s = "PAYPALISHIRING";
        System.out.println(ZigzagConversion.convert_approach_2(s, 4));
        Assert.assertEquals("isOrNot", "PINALSIGYAHRPI", ZigzagConversion.convert_approach_2(s, 4));
    }
}
