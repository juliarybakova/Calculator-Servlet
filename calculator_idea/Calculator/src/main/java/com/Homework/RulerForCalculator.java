package com.Homework;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;


public class RulerForCalculator implements TestRule {

    public final static int TEST_COUNT = 10;


    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable testError = null;


               long average = 0;
               for (int i=0; i<TEST_COUNT; i++) {
                   try {
                       long start_Time = System.currentTimeMillis();
                       String descriptionMethodName = description.getMethodName();
                       int time = description.testCount();

                       base.evaluate();
                       long total = System.currentTimeMillis() - start_Time;
                       average = (average + total);
                       System.out.println(descriptionMethodName);
                       System.out.println ("Time of test execution is " + total);


                       //return;
                   } catch (Throwable e) {
                       testError = e;
                   }
               }
               System.out.println("Average time of test executing : " + average/TEST_COUNT);
            }
        };
    }
}
