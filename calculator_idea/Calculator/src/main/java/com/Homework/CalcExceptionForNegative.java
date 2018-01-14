package com.Homework;

public class CalcExceptionForNegative {

    public void throwException(int a, int b) throws CalcException {
        if (a!= b)
        {System.out.printf("Comparing expected %d with actual %d%n",b, a);
            throw new CalcException();

        }
    }

}


