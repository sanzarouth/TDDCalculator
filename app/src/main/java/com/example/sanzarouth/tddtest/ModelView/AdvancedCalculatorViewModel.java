package com.example.sanzarouth.tddtest.ModelView;//package com.example.sanzarouth.tddtest.ModelView;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.*;


public class AdvancedCalculatorViewModel {

    double result;

    ExpressionEvaluator ee = new ExpressionEvaluator();

    public void calculate(String input) {
        try {
            ee.cook(input);
            String res = null;
            try {
                res = String.valueOf(ee.evaluate(null));
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                result = Double.NaN;
            }
            result = Double.valueOf(res);

        } catch (CompileException e) {
            e.printStackTrace();
            result = Double.NaN;
        }
    }

    public double getResult() {
        return result;
    }

}