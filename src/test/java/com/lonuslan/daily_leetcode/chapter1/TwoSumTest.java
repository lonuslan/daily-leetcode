package com.lonuslan.daily_leetcode.chapter1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/1/29 12:16
 * @description：this is the two sum test class
 * @modified By：
 */
public class TwoSumTest {

    @Test
    public void testTwoSum(){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = TwoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }

    @Test
    public void testTwoSum_approach_2(){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = TwoSum.twoSum_approach_2(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }

    @Test
    public void testTwoSum_approach_3(){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = TwoSum.twoSum_approach_3(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }
}
