package com.lonuslan.dailyleetcode.chapter2;

import org.junit.Test;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/1 16:48
 * @description： test longest palindromic substring
 * @modified By：
 */
public class LongestPalindromicSunstringTest {

    @Test
    public void testLongestPaliSub_approach_2(){
        String s = "babad";
        System.out.println(LongestPalindromicSubstring.longestPalindrome_approach_2(s));
    }
    @Test
    public void testLongestPaliSub_approach_3(){
        String s = "abbd";
        System.out.println(LongestPalindromicSubstring.longestPalindrome_approach_3(s));
    }
    @Test
    public void testLongestPaliSub_approach_4(){
        String s = "abcdfdcased";
        System.out.println(LongestPalindromicSubstring.longestPalindrome_approach_4(s));
    }

}
