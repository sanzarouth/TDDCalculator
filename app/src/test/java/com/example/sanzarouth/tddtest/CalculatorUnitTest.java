package com.example.sanzarouth.tddtest;

import com.example.sanzarouth.tddtest.ModelView.CalculatorViewModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalculatorUnitTest {

    CalculatorViewModel cvm = new CalculatorViewModel();

    @Test
    public void canAddWithZeroAndInt() {
        cvm.add(6,0);
        assertEquals("6+0 should return 6", 6, cvm.getResult(), 0);
    }

    @Test
    public void updatesWithDifferentAdditions() {
        cvm.add(3,4);
        assertEquals("3+4 should return 7", 7, cvm.getResult(), 0);

        cvm.add(9,9);
        assertEquals("9+9 should return 18", 18, cvm.getResult(), 0);
    }

    @Test
    public void canAddSequentially() {
        cvm.add(1,2);
        cvm.add(cvm.getResult(), 33);
        assertEquals("1+2, +33 should return 36", 36, cvm.getResult(), 0);
    }

    @Test
    public void canAddDoubles() {
        cvm.add(3.4, 9.1);
        assertEquals("3.4+9.1 should return 12.5", 12.5, cvm.getResult(), 0);
    }

    @Test
    public void canSubtractInts() {
        cvm.subtract(10, 4);
        assertEquals("10-4 should return 6", 6, cvm.getResult(), 0);
    }

    @Test
    public void canSubtractDoubles() {
        cvm.subtract(9.8, 2.4);
        assertEquals("9.8-2.4 should return 7.4", 7.4, cvm.getResult(), 0);
    }

    @Test
    public void canSubtractAndAddSequentially() {
        cvm.add(10, 19.3);
        cvm.subtract(cvm.getResult(), 3.1);
        assertEquals("10+19.3, - 3.1 should return 26.2",26.2, cvm.getResult(), 0);
    }

    @Test
    public void canMultiplyInts() {
        cvm.multiply(3,3);
        assertEquals("3*3 should return 9", 9, cvm.getResult(), 0);
    }

    @Test
    public void canMultiplyDoubles() {
        cvm.multiply(2.3, 4.5);
        assertEquals("2.3*4.5 should return 10.35", 10.35, cvm.getResult(), 0);
    }

    @Test
    public void canMultiplySequentially() {
        cvm.multiply(3,4);
        cvm.multiply(cvm.getResult(), 2);
        assertEquals("3*4,*2 should return 24", 24, cvm.getResult(), 0);
    }

    @Test
    public void canDivideInts() {
        cvm.divide(10,2);
        assertEquals("10/2 should return 5", 5, cvm.getResult(), 0.001);
    }

    @Test
    public void canDivideDoubles() {
        cvm.divide(9.3, 3.4);
        assertEquals("9.3/3.4 should give 2.735", 2.735, cvm.getResult(), 0.001);
    }

    @Test
    public void canDivideSequentially() {
        cvm.divide(30, 3);
        cvm.divide(cvm.getResult(), 2);
        assertEquals("30/3, /2 should return 5", 5, cvm.getResult(), 0);
    }

    @Test
    public void cannotDivideByZero() {
        cvm.divide(3,0);
        assertEquals("Dividing by zero should return NaN", Double.NaN, cvm.getResult(), 0);
    }

    @Test
    public void canMixOperations() {
        cvm.add(108,3);
        cvm.multiply(cvm.getResult(), 2);
        cvm.subtract(cvm.getResult(), 10);
        cvm.divide(cvm.getResult(), 1.2);
        assertEquals("(((108+3)*2)-10)/1.2 should return", (((108+3)*2)-10)/1.2, cvm.getResult(), 0.001);
    }
}