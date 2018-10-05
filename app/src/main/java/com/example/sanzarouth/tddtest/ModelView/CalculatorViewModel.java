package com.example.sanzarouth.tddtest.ModelView;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.graphics.Movie;


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
