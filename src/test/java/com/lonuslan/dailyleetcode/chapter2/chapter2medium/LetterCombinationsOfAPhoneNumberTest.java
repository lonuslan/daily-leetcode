package com.lonuslan.dailyleetcode.chapter2.chapter2medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LetterCombinationsOfAPhoneNumberTest {

    @Test
    public void letterCombinations() {
        String s1 = "23";
        List<String> list = LetterCombinationsOfAPhoneNumber.letterCombinations(s1);
        for (String s : list){
            System.out.print(s + ", ");
        }
        String[] exp = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        System.out.println(Arrays.toString(exp));
    }
}