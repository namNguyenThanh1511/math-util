/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.makisekurisu.mathutil.test.core;

import com.makisekurisu.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Admin
 */
// câu lệnh báo hiệu JUnit báo hiệu rằng sẽ cần loop qua tập data
// lấy cặp data input/expected nhồi vào hàm test
@RunWith(value = Parameterized.class) // biến class này thành class tham số hóa 
public class MathUtilDDTTest { // @Runwith bản chất là Interface , thay vì implement thì dùng annotation

    // return mảng 2 chiều gồm nhiều cặp  Input/Expected
    @Parameterized.Parameters // JUnit sẽ ngầm chạy loop qua từng dòng của mảng để lấy ra đc cặp data input/expected
    // tên hàm ko quan trọng , quan trọng nhất là @ : quy ước điều gì diễn ra
    public static Object[][] initData() {
        return new Integer[][]{
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 120},
            {6, 120}// int a[input][expected] = { {2:input,2:expected} // {a[0], a[1]}
        //                  {3,6}  }
        };
    }
//giả sử loop qua từng dòng của mảng , ta vẫn cần gán từng value của cột
//vào biến tương ứng input-expected để lát feed cho hàm 
    @Parameterized.Parameter(value = 0) // value = 0 -> map với mảng data thì 0 là cột input
    public int input;//biến map với value của cột 0 của mảng
    @Parameterized.Parameter(value = 1) // value = 1 -> map với mảng data thì 1 là cột expected
    public long expected;

    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        Assert.assertEquals(expected, MathUtil.getFactorial(input));
    }
    //Build succesfull kể cả test failed , Ant đóng gói nhắm mắt làm ngơ  ( Old Netbean  )
    // Nên dạy Ant phải kiểm tra JUnit đã rồi mới đóng gói ( New Netbean tích hợp chức năng rồi )
    
}
