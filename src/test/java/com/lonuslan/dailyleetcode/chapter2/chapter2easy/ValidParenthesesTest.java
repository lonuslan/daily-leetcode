package com.lonuslan.dailyleetcode.chapter2.chapter2easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesesTest {

    private String a = "()";
    private String b = "()[]{}";
    private String c = "(]";
    private String d = "([)]";
    private String e = "{[]}";

    private boolean exp1 = true,
                    exp2 = true,
                    exp3 = false,
                    exp4 = false,
                    exp5 = true;

    @Test
    public void isValid() {
        boolean fact1 = ValidParentheses.isValid(a),
                fact2 = ValidParentheses.isValid(b),
                fact3 = ValidParentheses.isValid(c),
                fact4 = ValidParentheses.isValid(d),
                fact5 = ValidParentheses.isValid(e);
        System.out.println(fact1);
        System.out.println(fact2);
        System.out.println(fact3);
        System.out.println(fact4);
        System.out.println(fact5);

        Assert.assertEquals(exp1, fact1);
        Assert.assertEquals(exp2, fact2);
        Assert.assertEquals(exp3, fact3);
        Assert.assertEquals(exp4, fact4);
        Assert.assertEquals(exp5, fact5);
    }
}