package com.lonuslan.dailyleetcode.chapter2.chapter2easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/23 21:18
 * @description： valid parentheses
 * @modified By：
 */
public class ValidParentheses {

    /**
     * problem description:
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     *
     * Example 1:
     *
     * Input: "()"
     * Output: true
     * Example 2:
     *
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: "(]"
     * Output: false
     * Example 4:
     *
     * Input: "([)]"
     * Output: false
     * Example 5:
     *
     * Input: "{[]}"
     * Output: true
     *
     */

    /**
     *
     * approach: stacks
     * solution detail :
     * https://leetcode.com/articles/valid-parentheses/
     * Time complexity : O(n).
     * because we simply traverse the given string one character at a time and push
     * and pop operations on a stack take O(1) time.
     * Space complexity : O(n).
     * as we push all opening brackets onto the stack and in the worst case,
     * we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() < 0){
            throw new IllegalArgumentException("illegal input parameters");
        }
        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();
        // Initialize a map to be used in the algorithm.
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the current character is a closing bracket.
            if (map.containsKey(c)) {
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();
                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
