package com.lonuslan.dailyleetcode.chapter2;

import java.util.Vector;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/4 17:13
 * @description： integer to roman
 * @modified By：
 */
public class IntegerToRoman {

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
     * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
     *
     * Example 1:
     *
     * Input: 3
     * Output: "III"
     * Example 2:
     *
     * Input: 4
     * Output: "IV"
     * Example 3:
     *
     * Input: 9
     * Output: "IX"
     * Example 4:
     *
     * Input: 58
     * Output: "LVIII"
     * Explanation: L = 50, V = 5, III = 3.
     * Example 5:
     *
     * Input: 1994
     * Output: "MCMXCIV"
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    //TODO fill the guide_doc

    /**
     * approach:
     *
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {

        //TODO test no pass
        String[] s1 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] s2 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] s3 = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] s4 = {"", "M", "MM", "MMM"};
        return s1[num % 10] + s2[(num % 100) / 10] + s3[(num % 1000) / 100] + s4[num / 1000];
    }

    /**
     * approach_2:
     *
     * @param num
     * @return
     */
    public static String intToRoman_approach_2(int num) {
        String res = "";
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int length = val.length;
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < length; i++) {
            while (num >= val[i]) {
                num -= val[i];
                res += str[i];
            }
        }
        return res;
    }

    /**
     * approach_3:
     *
     * @param num
     * @return
     */
    public static String intToRoman_approach_3(int num) {
        //TODO test no pass
        if(num>=1000) {
            return "M"+intToRoman(num-1000);
        }
        if(num>=900) {
            return "CM"+intToRoman(num-900);
        }
        if(num>=500) {
            return "D"+intToRoman(num-500);
        }
        if(num>=400) {
            return "CD"+intToRoman(num-400);
        }
        if(num>=100) {
            return "C"+intToRoman(num-100);
        }
        if(num>=90) {
            return "XC"+intToRoman(num-90);
        }
        if(num>=50) {
            return "L"+intToRoman(num-50);
        }
        if(num>=40) {
            return "XL"+intToRoman(num-40);
        }
        if(num>=10) {
            return "X"+intToRoman(num-10);
        }
        if(num>=9) {
            return "IX"+intToRoman(num-9);
        }
        if(num>=5) {
            return "V"+intToRoman(num-5);
        }
        if(num>=4) {
            return "IV"+intToRoman(num-4);
        }
        if(num>=1) {
            return "I"+intToRoman(num-1);
        }
        return "";
    }

}
