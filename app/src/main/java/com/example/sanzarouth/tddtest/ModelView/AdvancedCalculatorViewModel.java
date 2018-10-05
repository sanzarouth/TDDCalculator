package com.example.sanzarouth.tddtest.ModelView;//package com.example.sanzarouth.tddtest.ModelView;

import android.arch.lifecycle.ViewModel;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class AdvancedCalculatorViewModel extends ViewModel{

    double result;

    public void calculate(String input) {
        if (!checkRegex(input)){
           result = Double.NaN;
           return;
        }
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result = (double) engine.eval(input);
        } catch (Exception e){
            //
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