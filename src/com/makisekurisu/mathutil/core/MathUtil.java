/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.makisekurisu.mathutil.core;

/**
 *
 * @author Admin
 */
public class MathUtil {

    // This class provides many  logical math functions for someone
    //Clone class Math from JDK 
    // hàm thư viện xài chung cho ai đó , ko cần lưu lại trạng thái/giá trị 
    //chọn thiết kế là hàm static
    //hàm tính giai thừa 
    //n!= 1.2.3.4. ... n
    // ko có giai thừa cho số âm
    // 0! = 1! = 1 : quy ước 
    //giai thừa hàm đồ thị tuyến tính ( dốc đứng ) : tăng nhanh về giá trị 
    //x chậm -> y giá trị rất lớn
    // 20! : 18 số 0 , vừa kịp đủ cho kiểu long của Java
    //21! -> tràn kiểu long 
    //bài này quy ước tính n! trong khoảng từ 0..20
    public static long getFactorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException(n < 0 ? "Cannot calculate , number must > 0 " : "Cannot calculate  21! or above ");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long product = 1;
        for (int i = 2; i <= n; i++) {
            product *= i;
        }
        return product;
    }
}
