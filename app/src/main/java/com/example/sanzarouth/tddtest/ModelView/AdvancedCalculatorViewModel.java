package com.example.sanzarouth.tddtest.ModelView;//package com.example.sanzarouth.tddtest.ModelView;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.*;


public class AdvancedCalculatorViewModel {

    double result;

    ExpressionEvaluator ee = new ExpressionEvaluator();

    public void calculate(String input) {
        if (!checkRegex(input)){
           result = Double.NaN;
           return;
        }
        try {
            ee.cook(input);
            String res = null;
            try {
                res = String.valueOf(ee.evaluate(null));
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            result = Double.valueOf(res);

        } catch (CompileException e) {
            e.printStackTrace();
        }
    }

    static Pattern simpleLang = Pattern.compile("\\s*-?\\d+(\\s*[-+*%/]\\s*-?\\d+)*\\s*");
    static Pattern innerParen = Pattern.compile("[(]([^()]*)[)]");
    public static boolean checkRegex(String expr) {
        while (expr.contains(")") || expr.contains("(")) {
            Matcher m = innerParen.matcher(expr);
            if (m.find()) {
                if (!simpleLang.matcher(m.group(1)).matches()) {
                    return false;
                }
                expr = expr.substring(0, m.start()) + " 1 " + expr.substring(m.end());
            } else {
                return false;
            }
        }
        return simpleLang.matcher(expr).matches();
    }

    public double getResult() {
        return result;
    }

}