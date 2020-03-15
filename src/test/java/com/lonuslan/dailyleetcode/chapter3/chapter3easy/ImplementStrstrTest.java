package com.lonuslan.dailyleetcode.chapter3.chapter3easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImplementStrstrTest {

    private String strHay = "hello", strNeedle = "ll";

    private String strHay2 = "aaaaa", strNeedle2 = "baa";

    @Test
    public void strStr() {
        int res1 = ImplementStrstr.strStr(strHay, strNeedle);
        int res2 = ImplementStrstr.strStr(strHay2, strNeedle2);
        System.out.println(res1);
        System.out.println(res2);
        Assert.assertEquals(2, res1);
        Assert.assertEquals(-1, res2);
    }
}