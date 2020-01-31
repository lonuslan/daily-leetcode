package com.lonuslan.dailyleetcode.chapter1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/1/30 16:48
 * @description： longest substring without repeating characters
 * @modified By：
 */
public class LongestSubstringWithoutRepeatingCharacters {


    /**
     * problem description:
     *
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    /**
     * 方法1： 暴力选择
     * approach: Brute Force
     * Time complexity : O(n^3)
     * Space complexity : O(min(n, m)).
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        int length = s.length();
        int aus = 0;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                if (allUnique(s, i, j)){
                    aus = Math.max(aus, j - i);
                }
            }
        }
        return aus;
    }

    /**
     * return true if the characters in the substring are all unique,
     * otherwise false. We can iterate through all the possible
     * substrings of the given string s and call the function allUnique.
     * If it turns out to be true, then we update our answer of the maximum length of substring without duplicate characters.
     * @param s
     * @param start
     * @param end
     * @return
     */
    public static boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<Character>();
        // use the set collection properties, it do not have a duplicate element
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                //if the substring has a duplicate character we return false , or we return true
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * approach_2: Sliding Window
     * Time complexity : O(n)
     * Space complexity : O(min(n, m)).
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_approach_2(String s) {
        if (s == null){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        int length = s.length();
        Set<Character> set = new HashSet<Character>();
        int aus = 0, i = 0, j = 0;
        while (i < length && j < length){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                aus = Math.max(aus, j - i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return aus;
    }

    /**
     * approach_3: Sliding Window Optimized
     * Time complexity : O(n)
     * Space complexity(HashMap) : O(min(n, m)).
     * Space complexity(Table) : O(m)
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_approach_3(String s) {
        if (s == null){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(16);
        // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring_approach_3_2(String s) {
        if (s == null){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
