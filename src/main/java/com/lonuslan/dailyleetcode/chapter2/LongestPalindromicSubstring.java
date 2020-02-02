package com.lonuslan.dailyleetcode.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/1 15:46
 * @description： 5. longest palindromic substring
 * @modified By：
 */
public class LongestPalindromicSubstring {

    /**
     * problem description:
     *
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     *
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: "cbbd"
     * Output: "bb"
     */

    /**
     * approach: Longest Common Substring
     *
     * Common mistake
     *
     * Some people will be tempted to come up with a quick solution, which is unfortunately flawed (however can be corrected easily):
     *
     * Reverse SS and become S'S
     * ′
     *  . Find the longest common substring between SS and S'S
     * ′
     *  , which must also be the longest palindromic substring.
     *
     * This seemed to work, let’s see some examples below.
     *
     * For example, SS = "caba", S'S
     * ′
     *   = "abac".
     *
     * The longest common substring between SS and S'S
     * ′
     *   is "aba", which is the answer.
     *
     * Let’s try another example: SS = "abacdfgdcaba", S'S
     * ′
     *   = "abacdgfdcaba".
     *
     * The longest common substring between SS and S'S
     * ′
     *   is "abacd". Clearly, this is not a valid palindrome.
     *
     * Algorithm
     *
     * We could see that the longest common substring method fails when there exists a reversed copy of a non-palindromic substring in some other part of SS. To rectify this, each time we find a longest common substring candidate, we check if the substring’s indices are the same as the reversed substring’s original indices. If it is, then we attempt to update the longest palindrome found so far; if not, we skip this and find the next candidate.
     *
     * This gives us an O(n^2)O(n
     * 2
     *  ) Dynamic Programming solution which uses O(n^2)O(n
     * 2
     *  ) space (could be improved to use O(n)O(n) space). Please read more about Longest Common Substring here.
     */

    /**
     * approach_2: Brute Force
     * Time complexity : O(n^3)
     * Space complexity : O(1)
     * The obvious brute force solution is to pick all possible starting and ending positions for a substring,
     * and verify if it is a palindrome.
     * @param s
     * @return
     */
    public static String longestPalindrome_approach_2(String s) {
        if (s == null){
            throw new IllegalArgumentException("Illegel input parameters");
        }
        for(int i = s.length();i > 0; i--) {
            //子串长度 the length of the substring
            for (int j = 0; j <= s.length() - i; j++) {
                //子串位置 the position of the substring i the s;
                String sub = s.substring(j , i + j);
                //计数，用来判断是否对称 use the the count to determine whether the substring is a palindrome
                int count = 0;
                //左右对称判断 determine the substring
                for (int k = 0; k < sub.length() / 2; k++) {
                    if (sub.charAt(k) == sub.charAt(sub.length() - k - 1)) {
                        count++;
                    }
                }
                if (count == sub.length() / 2){
                    return sub;
                }
            }
        }
        throw new IllegalArgumentException("no palindrome substring");
    }

    /**
     * approach_3: Expand Around Center
     * Time complexity : O(n^2)
     * Space complexity : O(1)
     * We observe that a palindrome mirrors around its center. Therefore,
     * a palindrome can be expanded from its center, and there are only 2n - 12n−1 such centers.
     * You might be asking why there are 2n - 12n−1 but not nn centers?
     * The reason is the center of a palindrome can be in between two letters.
     * Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
     * @param s
     * @return
     */
    public static String longestPalindrome_approach_3(String s) {
        if (s == null){
            throw new IllegalArgumentException("Illegel input parameters");
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * approach_4: Manacher's Algorithm
     * Time complexity: O(n)
     * Space complexity : O(n)
     * links: https://www.cnblogs.com/grandyang/p/4475985.html
     * @param s
     * @return
     */
    public static String longestPalindrome_approach_4(String s) {
        // TODO the answer is wrong accroding to the leetcode submit.
        // TODO exam
        if (s == null){
            throw new IllegalArgumentException("Illegel input parameters");
        }
        int length = s.length();
        List<Character> s_new = new ArrayList<>();
        for (int i = 0; i < length; i++){
            s_new.add('#');
            s_new.add(s.charAt(i));
        }
        s_new.add('#');
        List<Integer> len =  new ArrayList<>();
        //表示在i之前所得到的len数组中的最大值所在位置
        int sub_middle = 0;
        //表示以sub_middle为中心的最长回文子串的最右端在s_new中的位置
        int sub_side = 0;
        len.add(1);
        for (int i = 1; i < s_new.size(); i++){
            if (i < sub_side){
                int j = 2 * sub_middle - i;
                if (j >= 2 * sub_middle - sub_side  && len.get(j) <= sub_side - i){
                    len.add(len.get(j));
                }else {
                    len.add(sub_side - i + 1);
                }
            }else {
                len.add(1);
                while( (i - len.get(i) >= 0 && i + len.get(i) < s_new.size()) && (s_new.get(i - len.get(i)).equals(s_new.get(i + len.get(i))))){
                    len.set(i, len.get(i) + 1);
                    if (len.get(i) >= len.get(sub_middle)){
                        sub_side = len.get(i) + i - 1;
                        sub_middle = i;
                    }
                }
            }
        }
        return s.substring((2 * sub_middle - sub_side) / 2, sub_side / 2);

        /**
         * online accepted submission :
         * char[] s = str.toCharArray();
         *         int[] f = new int[2 * s.length + 1];
         *         int c = 0, r = 0, tc = 0, tr = 0;
         *         for(int i = 1, x = 0, y = 0; i < f.length; ++i) {
         *             if(i < r) f[i] = Math.min(r - i, f[(c << 1) - i]);
         *             x = i + f[i] + 1; y = (i << 1) - x;
         *             while((x & 1) == 0 || (x < f.length && y >= 0 && s[x >> 1] == s[y >> 1])) {
         *                 f[i]++; x++; y--;
         *             }
         *             if(i + f[i] > r) { c = i; r = i + f[i]; }
         *             if(f[i] > tr - tc) { tc = c; tr = r; }
         *         }
         *         return str.substring(((tc << 1) - tr) / 2, tr / 2);
         */
    }
}
