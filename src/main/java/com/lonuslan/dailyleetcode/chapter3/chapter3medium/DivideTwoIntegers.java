package com.lonuslan.dailyleetcode.chapter3.chapter3medium;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/3/15 11:46
 * @description： leetcode problem number 29 medium divide two integers
 * @modified By：
 */
public class DivideTwoIntegers {
    /**
     *
     * problem description:
     * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
     *
     * Return the quotient after dividing dividend by divisor.
     *
     * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
     *
     * Example 1:
     *
     * Input: dividend = 10, divisor = 3
     * Output: 3
     * Explanation: 10/3 = truncate(3.33333..) = truncate(3) = 3.
     * Example 2:
     *
     * Input: dividend = 7, divisor = -3
     * Output: -2
     * Explanation: 7/-3 = truncate(-2.33333..) = truncate(-2) = 3.
     * Note:
     *
     * Both dividend and divisor will be 32-bit signed integers.
     * The divisor will never be 0.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.
     */

    /**
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {

        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        if (dividend != Integer.MIN_VALUE && Math.abs(dividend) < Math.abs(divisor)){
            return 0;
        }
        if (divisor == Integer.MIN_VALUE){
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        }

        boolean flag = (dividend < 0) ^ (divisor < 0);
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int[] num = new int[40];
        int[] multiple = new int[40];
        num[1] = divisor;
        multiple[1] = 1;

        for (int i = 2; i < 32 && num[i - 1] < 0; ++i){
            num[i] = num[i - 1] << 1;
            multiple[i] = multiple[i - 1] << 1;
        }

        int result = 0;
        int index = 1;
        while (num[index] < 0){
            ++index;
        }
        index -= 1;

        while (dividend <= divisor){
            while (dividend <= num[index]){
                result += multiple[index];
                dividend -= num[index];
            }
            --index;
        }
        return !flag ? result : -result;
    }
}
