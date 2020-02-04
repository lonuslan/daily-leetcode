package com.lonuslan.dailyleetcode.chapter2;

/**
 * @author ：lonus_lan
 * @date ：Created in 2020/2/4 17:16
 * @description： Container With Most Water
 * @modified By：
 */
public class ContainerWithMostWater {

    /**
     * problem description:
     *
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     *
     * Note: You may not slant the container and n is at least 2.
     *
     * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     * Example:
     *
     * Input: [1,8,6,2,5,4,8,3,7]
     * Output: 49
     */

    /**
     * approach: Brute Force
     * simply consider the area for every possible pair of the lines and find out the maximum area out of those.
     * Time complexity : O(n^2). Calculating area for all n * (n - 1) / 2 height pairs.
     * Space complexity : O(1). Constant extra space is used.
     * @param height
     * @return
     */
    public static int maxArea(int[] height){
        if (height == null){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        int maxarea = 0;
        for (int i = 0; i < height.length; i++){
            for (int j = i + 1; j < height.length; j++){
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxarea;
    }


    /**
     * approach_2: Two Pointer Approach
     * We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines.
     * Futher, we maintain a variable \text{maxarea}maxarea to store the maximum area obtained till now.
     * At every step, we find out the area formed between them,
     * update {maxarea}maxarea and move the pointer pointing to the shorter line towards the other end by one step.
     * Time complexity : O(n). Single pass.
     * Space complexity : O(1). Constant space is used.
     * @param height
     * @return
     */
    public static int maxArea_approach_2(int[] height){
        if (height == null){
            throw new IllegalArgumentException("Illegal input parameters");
        }
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r){
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - 1));
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return maxarea;
    }
}
