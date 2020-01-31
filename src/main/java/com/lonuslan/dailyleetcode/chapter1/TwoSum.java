package com.lonuslan.dailyleetcode.chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/1/29 12:09
 * @description： the first leetcode problem
 * @modified By：
 */
public class TwoSum {


    /**
     * problem description:
     *
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have  exactly  one solution, and you may not use the  same  element twice.
     *
     * Example:
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     */

    /**
     * Approach 1 : Brute force
     * Time complexity: O(n ^ 2)
     * Space complexity: O( 1 )
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        int length = nums.length;
        for (int i = 0; i < length; i++){ //先选一个数作为基数
            for (int j = i + 1; j < length; j++){ // 从选择的基数后面选择新的数，查找是否满足和为target
                if (nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution!");
    }

    /**
     * approach_2: Two-pass Hash Table
     * Time complexity: O( n )
     * Space complexity: O( n )
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_approach_2(int[] nums, int target){
        if (nums == null){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        //利用的hash表的特性，查找快
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++){ //第一次循环，将数组转为 hash table
            map.put(nums[i], i);
        }
        for (int i = 0; i < length; i++){ //第二次循环，从hash表中查找满足和为target的数
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * approach_3: One-pass Hash Table
     * Time complexity: O ( n )
     * Space complexity: O ( n )
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_approach_3(int[] nums, int target){
        if (nums == null){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        //we iterate and inserting elements into the table, we also look back to
        //check if current element's complement already exists in the table.
        //If it exists, we have found a solution and return immediately.
        for (int i = 0; i < length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
