package com.lonuslan.dailyleetcode.chapter1;

import org.junit.Test;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/1/31 21:51
 * @description： median of two sorted arrays
 * @modified By：
 */
public class MedianOfTwoSortedArraysTest {


    @Test
    public void testMedianOfTwoSortedArrays(){
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    @Test
    public void testMedianOfTwoSortedArrays_2(){
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

}
