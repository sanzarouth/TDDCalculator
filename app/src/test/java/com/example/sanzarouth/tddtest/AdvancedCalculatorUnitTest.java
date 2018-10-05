package com.example.sanzarouth.tddtest;

import com.example.sanzarouth.tddtest.ModelView.AdvancedCalculatorViewModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdvancedCalculatorUnitTest {

    AdvancedCalculatorViewModel acvm = new AdvancedCalculatorViewModel();

    @Test
    public void canEvaluateCorrectly() {
        acvm.calculate("(18+2)*3");
        assertEquals("(18+2)*3 should return 60", (18+2)*3, acvm.getResult(), 0);
    }

    @public void cantCalculateIfFormatWrong() {
        acvm.calculate("(18+2*3");
        assertEquals("(18+2*3 should return NaN", Double.NaN, acvm.getResult(), 0);
    }

}
