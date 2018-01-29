package com.Homework.interfaces;

import com.Homework.CalcData;

public interface CalcApi {
    void getResult(final String e, final String r);
    CalcData postExpression(final String e);
    void doPost (final String e);

}
