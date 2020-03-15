package com.lonuslan.dailyleetcode.chapter3.chapter3easy;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/3/15 11:30
 * @description： leetcode problem number 28 implement strstr
 * @modified By：
 */
public class ImplementStrstr {

    /**
     * problem description:
     * Implement strStr().
     *
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     * Example 1:
     *
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * Example 2:
     *
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     * Clarification:
     *
     * What should we return when needle is an empty string? This is a great question to ask during an interview.
     *
     * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
     *
     */

    /**
     *
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++){
            if (haystack.substring(i, i + needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
