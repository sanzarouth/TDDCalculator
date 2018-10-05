package com.example.sanzarouth.tddtest.ModelView;

import android.arch.lifecycle.ViewModel;


public class CalculatorViewModel extends ViewModel {

    double result;

    public void add(double number1, double number2) {
        result = number1 + number2;
    }

    public void subtract(double number1, double number2) {
        result = number1 - number2;
    }

    public void multiply(double number1, double number2) {
        result = number1 * number2;
    }

    public void divide(double number1, double number2) {
        if(number2 == 0) {
            result = Double.NaN;
        } else {
            result = number1 / number2;
        }
    }

    public double getResult() {
        return result;
    }

}
