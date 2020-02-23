package com.lonuslan.dailyleetcode.chapter2.chapter2easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {

    private String[] str = {"flower","flow","flight"};

    private String[] str2 = {"dog","racecar","car"};

    @Test
    public void longestCommonPrefix() {
        String s1 = LongestCommonPrefix.longestCommonPrefix(str);
        String s2 = LongestCommonPrefix.longestCommonPrefix(str2);
        System.out.println(s1);
        System.out.println(s2);
        Assert.assertEquals("fl", s1);
        Assert.assertEquals("", s2);
    }

    @Test
    public void longestCommonPrefix_approach_2() {
        String s1 = LongestCommonPrefix.longestCommonPrefix_approach_2(str);
        String s2 = LongestCommonPrefix.longestCommonPrefix_approach_2(str2);
        System.out.println(s1);
        System.out.println(s2);
        Assert.assertEquals("fl", s1);
        Assert.assertEquals("", s2);
    }

    @Test
    public void longestCommonPrefix_approach_3() {
        String s1 = LongestCommonPrefix.longestCommonPrefix_approach_3(str);
        String s2 = LongestCommonPrefix.longestCommonPrefix_approach_3(str2);
        System.out.println(s1);
        System.out.println(s2);
        Assert.assertEquals("fl", s1);
        Assert.assertEquals("", s2);
    }

    @Test
    public void longestCommonPrefix_approach_4() {
        String s1 = LongestCommonPrefix.longestCommonPrefix_approach_4(str);
        String s2 = LongestCommonPrefix.longestCommonPrefix_approach_4(str2);
        System.out.println(s1);
        System.out.println(s2);
        Assert.assertEquals("fl", s1);
        Assert.assertEquals("", s2);
    }

}