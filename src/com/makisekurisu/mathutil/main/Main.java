/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.makisekurisu.mathutil.main;

import com.makisekurisu.mathutil.core.MathUtil;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        int input = 5;
        long expected = 120; // 5!
        long actual = MathUtil.getFactorial(input);
        System.out.println("input : " + input + "| Expected  : " + expected);
        System.out.println("actual : " + actual);
        System.out.println("Result : "+ (expected == actual));
    }
}
