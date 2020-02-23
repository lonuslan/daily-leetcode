package com.lonuslan.dailyleetcode.chapter2.chapter2easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/5 14:35
 * @description： roman to integer
 * @modified By：
 */
public class RomanToInteger {

    /**
     * problem description:
     *
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     *
     * Example 1:
     *
     * Input: "III"
     * Output: 3
     * Example 2:
     *
     * Input: "IV"
     * Output: 4
     * Example 3:
     *
     * Input: "IX"
     * Output: 9
     * Example 4:
     *
     * Input: "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * Example 5:
     *
     * Input: "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */

    /**
     *
     * TODO
     * need to do
     * approach:
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {

        if (s == null || s.length() < 0){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = map.get(s.charAt(0));
        int length = s.length();
        for (int i = 1; i < length; i++){
            if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))){
                res = res + map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            }else {
                res = res + map.get(s.charAt(i));
            }
        }
        return res;
    }




    public static int romanToInt_approach_2(String s) {

        if (s == null || s.length() < 0){
            throw new IllegalArgumentException("Illegal input parameters");
        }

        return 0;
    }
}
