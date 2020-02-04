package com.lonuslan.dailyleetcode.chapter2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerToRomanTest {

    private int a = 3;
    private int b = 4;
    private int c = 9;
    private int d = 58;
    private int e = 1994;

    @Test
    public void intToRoman() {
        System.out.println(IntegerToRoman.intToRoman(a));
        System.out.println(IntegerToRoman.intToRoman(b));
        System.out.println(IntegerToRoman.intToRoman(c));
        System.out.println(IntegerToRoman.intToRoman(d));
        System.out.println(IntegerToRoman.intToRoman(e));

        Assert.assertEquals("III", IntegerToRoman.intToRoman(a));
        Assert.assertEquals("IV", IntegerToRoman.intToRoman(b));
        Assert.assertEquals("IX", IntegerToRoman.intToRoman(c));
        Assert.assertEquals("LVIII", IntegerToRoman.intToRoman(d));
        Assert.assertEquals("MCMXCIV", IntegerToRoman.intToRoman(e));
    }

    @Test
    public void intToRoman_approach_2() {
        System.out.println(IntegerToRoman.intToRoman_approach_2(a));
        System.out.println(IntegerToRoman.intToRoman_approach_2(b));
        System.out.println(IntegerToRoman.intToRoman_approach_2(c));
        System.out.println(IntegerToRoman.intToRoman_approach_2(d));
        System.out.println(IntegerToRoman.intToRoman_approach_2(e));

        Assert.assertEquals("III", IntegerToRoman.intToRoman_approach_2(a));
        Assert.assertEquals("IV", IntegerToRoman.intToRoman_approach_2(b));
        Assert.assertEquals("IX", IntegerToRoman.intToRoman_approach_2(c));
        Assert.assertEquals("LVIII", IntegerToRoman.intToRoman_approach_2(d));
        Assert.assertEquals("MCMXCIV", IntegerToRoman.intToRoman_approach_2(e));
    }

    @Test
    public void intToRoman_approach_3() {
        System.out.println(IntegerToRoman.intToRoman_approach_3(a));
        System.out.println(IntegerToRoman.intToRoman_approach_3(b));
        System.out.println(IntegerToRoman.intToRoman_approach_3(c));
        System.out.println(IntegerToRoman.intToRoman_approach_3(d));
        System.out.println(IntegerToRoman.intToRoman_approach_3(e));

        Assert.assertEquals("III", IntegerToRoman.intToRoman_approach_3(a));
        Assert.assertEquals("IV", IntegerToRoman.intToRoman_approach_3(b));
        Assert.assertEquals("IX", IntegerToRoman.intToRoman_approach_3(c));
        Assert.assertEquals("LVIII", IntegerToRoman.intToRoman_approach_3(d));
        Assert.assertEquals("MCMXCIV", IntegerToRoman.intToRoman_approach_3(e));
    }
}