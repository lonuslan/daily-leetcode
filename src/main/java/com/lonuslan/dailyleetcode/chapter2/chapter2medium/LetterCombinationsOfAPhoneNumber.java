package com.lonuslan.dailyleetcode.chapter2.chapter2medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/23 21:41
 * @description： letter combinations of a phone number
 * @modified By：
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * problem description:
     * Given a string containing digits from 2-9 inclusive,
     * return all possible letter combinations that the number could represent.
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * Note that 1 does not map to any letters.
     *
     * Example:
     *
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     *
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     */



    private static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private static List<String> output = new ArrayList<String>();
    /**
     *
     * approach: Backtracking
     *
     * Time complexity : O(3^N * 4^M)
     * where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and
     * M is the number of digits in the input that maps to 4 letters (e.g. 7, 9),
     * and N+M is the total number digits in the input.
     * Space complexity : O(3^N * 4^M)
     * since one has to keep 3^N * 4^M solutions.
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() < 0){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        if (digits.length() != 0){
            backtrack("", digits);
        }
        return output;
    }

    public static void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }
}
