package com.lonuslan.dailyleetcode.chapter2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {

    @Test
    public void maxArea() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(ContainerWithMostWater.maxArea(height));
        Assert.assertEquals(49, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void maxArea_approach_2() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(ContainerWithMostWater.maxArea_approach_2(height));
        Assert.assertEquals(49, ContainerWithMostWater.maxArea_approach_2(height));
    }
}