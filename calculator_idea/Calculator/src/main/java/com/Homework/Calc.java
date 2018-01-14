package com.Homework;

public class Calc {

    public int evaluate (String s) {

        String operands [] = s.split ("\\+|\\-|\\*|\\/");
        int a1 = Integer.parseInt(operands[0]);
        int a2 = Integer.parseInt(operands[1]);

        int res=0;
        if (s.contains("+")) {res = a1+a2;}
        else {
            if (s.contains("-")) {
                res = a1 - a2;
            }
            else {
                if (s.contains("*")) {
                    res = a1 * a2;
                }
                else {
                    if (s.contains("/")) {
                        res = a1 / a2;
                    }
                    else res=0;
                }
            }
        }
        return res;


    }



}
