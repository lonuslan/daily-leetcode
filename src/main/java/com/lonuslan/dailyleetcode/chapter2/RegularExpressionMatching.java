package com.lonuslan.dailyleetcode.chapter2;

import com.lonuslan.dailyleetcode.entity.Result;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/3 17:52
 * @description： regular expression matching
 * @modified By：
 */
public class RegularExpressionMatching {

    /**
     * problem description:
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     *
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     *
     * Note:
     *
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like . or *.
     * Example 1:
     *
     * Input:
     * s = "aa"
     * p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * Example 2:
     *
     * Input:
     * s = "aa"
     * p = "a*"
     * Output: true
     * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
     * Example 3:
     *
     * Input:
     * s = "ab"
     * p = ".*"
     * Output: true
     * Explanation: ".*" means "zero or more (*) of any character (.)".
     * Example 4:
     *
     * Input:
     * s = "aab"
     * p = "c*a*b"
     * Output: true
     * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
     * Example 5:
     *
     * Input:
     * s = "mississippi"
     * p = "mis*is*p*."
     * Output: false
     *
     */


    /**
     * approach: Recursion 递归
     * Time Complexity：let T, P be the length of the text and the pattern respectively. would be O((T + P)* 2 ^ (T + P / 2))
     * Space Complexity: O(T^2 + P^2)
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        if (p.isEmpty()){
            return s.isEmpty();
        }
        boolean first_match = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*'){
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        }else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }



    private static Result[][] memo;

    /**
     * approach_2: Dynamic Programming
     * Time Complexity: let T, P be the length of the text and the pattern respectively. it would be O(TP)
     * Space Complexity: The only memory we use is the O(TP) boolean entries in our cache. Hence, the space complexity is O(TP).
     * Top-Down Variation
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch_approach_2(String s, String p) {
        //Top-Down Variation
        memo = new Result[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    private static boolean dp(int i, int j, String s, String p){
        if (memo[i][j] != null){
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == p.length()){
            ans = i == s.length();
        }else {
            boolean first_match = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
            if (j + 1 < p.length() && p.charAt(j + 1) == '*'){
                ans = dp(i, j + 2, s, p) || first_match && dp(i + 1, j, s, p);
            }else {
                ans = first_match && dp(i + 1, j + 1, s, p);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    /**
     * same to above
     * Bottom-Up Variation
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch_approach_2_1(String s, String p) {
        //Bottom-Up Variation
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--){
            for (int j = p.length() - 1; j >= 0; j--){
                boolean first_match = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                if (j + 1 < p.length() && p.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
