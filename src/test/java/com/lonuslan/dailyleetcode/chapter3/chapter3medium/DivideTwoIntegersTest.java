package com.lonuslan.dailyleetcode.chapter3.chapter3medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivideTwoIntegersTest {

    private int divided1 = 10, divisor1 = 3;
    private int divided2 = 7, divisor2 = -3;

    @Test
    public void divide() {
        int res1 = DivideTwoIntegers.divide(divided1, divisor1);
        int res2 = DivideTwoIntegers.divide(divided2, divisor2);

        System.out.println(res1);
        System.out.println(res2);

        Assert.assertEquals(3, res1);
        Assert.assertEquals(-2,res2);
    }
}