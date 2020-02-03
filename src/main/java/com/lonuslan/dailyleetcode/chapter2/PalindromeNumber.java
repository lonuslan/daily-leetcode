package com.lonuslan.dailyleetcode.chapter2;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/3 17:33
 * @description： palindrome number
 * @modified By：
 */
public class PalindromeNumber {

    /**
     * problem description:
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     *
     * Example 1:
     *
     * Input: 121
     * Output: true
     * Example 2:
     *
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     *
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     * Follow up:
     *
     * Could you solve it without converting the integer to a string?
     *
     */

    /**
     * approach: Revert half of the number
     * Time complexity : O(\log_{10}(n)) We divided the input by 10 for every iteration,
     * so the time complexity is O(\log_{10}(n))
     * Space complexity : O(1)O(1).
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        //special cases:
        // As discussed above, when x < 0, x is not a palindrome. because of the flag '-';
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int revertedNumber = 0;
        while ( x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
