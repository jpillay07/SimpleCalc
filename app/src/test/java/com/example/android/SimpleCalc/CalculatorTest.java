/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative(){
        double resultNegativeAdd = mCalculator.add(-1.0, -1.0);
        assertThat(resultNegativeAdd, is(equalTo(-2.0)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
        assertThat(resultAdd, is(closeTo(2.222, 0.01)));
    }

    @Test
    public void subTwoNumbers(){
        double resultSub = mCalculator.sub(2d, 1d);
        assertThat(resultSub, is(equalTo(1d)));
    }

    @Test
    public void subWorksWithNegativeResult(){
        double resultSubNegative = mCalculator.sub(2d, 3d);
        assertThat(resultSubNegative, is(equalTo(-1d)));
    }

    @Test
    public void mulTwoNumbers(){
        double resultMul = mCalculator.mul(2d, 2d);
        assertThat(resultMul, is(equalTo(4d)));
    }

    @Test
    public void mulTwoNumbersZero(){
        double resultMulZero = mCalculator.mul(2d, 0d);
        assertThat(resultMulZero, is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers(){
        double resultDiv = mCalculator.div(2d,4d);
        assertThat(resultDiv, is(equalTo(0.5)));
    }

    @Test
    public void divTwoNumbersZero(){
        double resultDivZero = mCalculator.div(2d, 0);
        assertThat(resultDivZero, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powTwoNumbersPositive(){
        Double resultPowPositive = mCalculator.pow(2d, 2d);
        assertThat(resultPowPositive, is(equalTo(4d)));
    }

    @Test
    public void powFirstNegativeNumber(){
        Double resultPowFirstNegative = mCalculator.pow(-2d, 2);
        assertThat(resultPowFirstNegative, is(equalTo(4d)));
    }

    @Test
    public void powSecondNegativeNumber(){
        Double resultPowSecondNegative = mCalculator.pow(2d, -2d);
        assertThat(resultPowSecondNegative, is(equalTo(0.25d)));
    }

    @Test
    public void powFirstNumberZero(){
        Double resultPowFirstNumberZero = mCalculator.pow(0.0, 2d);
        assertThat(resultPowFirstNumberZero, is(equalTo(0.0)));
    }

    @Test
    public void powSecondNumberZero(){
        Double resultPowSecondNumberZero = mCalculator.pow(2d, 0.0);
        assertThat(resultPowSecondNumberZero, is(equalTo(1d)));
    }

    @Test
    public void powZeroNegative(){
        Double resultPowZeroNegative = mCalculator.pow(0.0, -1);
        assertThat(resultPowZeroNegative, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void powNegativeZero(){
        Double resultPowNegativeZero = mCalculator.pow(-0.0, -2);
        assertThat(resultPowNegativeZero, is(equalTo(Double.POSITIVE_INFINITY)));
    }

}