package com.lonuslan.dailyleetcode.chapter2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressionMatchingTest {

    @Test
    public void isMatch() {
        String s = "aa";
        String p = "a";
        System.out.println("approach_1 : " + RegularExpressionMatching.isMatch(s, p));
        Assert.assertTrue(!RegularExpressionMatching.isMatch(s, p));
    }

    @Test
    public void isMatch_approach_2() {
        String s ="aa";
        String p = "a*";
        System.out.println("approach_2 : " + RegularExpressionMatching.isMatch_approach_2(s, p));
        Assert.assertTrue(RegularExpressionMatching.isMatch_approach_2(s, p));
    }

    @Test
    public void isMatch_approach_2_1() {
        String s = "ab";
        String p = ".*";

        String s1 = "aab";
        String p1 = "c*a*b";

        String s2 = "mississippi";
        String p2 = "mis*is*p*.";

        System.out.println("approach_3 : " + RegularExpressionMatching.isMatch_approach_2_1(s, p));
        Assert.assertTrue(RegularExpressionMatching.isMatch_approach_2_1(s, p));

        System.out.println("approach_3 s1 : " + RegularExpressionMatching.isMatch_approach_2_1(s1, p1));
        Assert.assertTrue(RegularExpressionMatching.isMatch_approach_2_1(s1, p1));

        System.out.println("approach_3 s2 : " + RegularExpressionMatching.isMatch_approach_2_1(s2, p2));
        Assert.assertTrue(!RegularExpressionMatching.isMatch_approach_2_1(s2, p2));
    }
}