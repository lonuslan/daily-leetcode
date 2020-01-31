package com.lonuslan.dailyleetcode.chapter1;

import org.junit.Test;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/1/30 17:38
 * @description： test longest substring without repeating characters
 * @modified By：
 */
public class LongestSubWithoutRepCharTest {

    @Test
    public void testLongestSubChar(){
        String s = "abcabcbb";
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
    }
    @Test
    public void testLongestSubChar_approach_2(){
        String s = "bbbbb";
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring_approach_2(s));
    }
    @Test
    public void testLongestSubChar_approach_3(){
        String s = "pwwkew";
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring_approach_3(s));
    }
    @Test
    public void testLongestSubChar_approach_3_2(){
        String s = "abcdefgaeihakdg";
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring_approach_3_2(s));
    }
}
