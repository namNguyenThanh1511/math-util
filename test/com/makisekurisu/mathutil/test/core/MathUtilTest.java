/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.makisekurisu.mathutil.test.core;

import com.makisekurisu.mathutil.core.MathUtil;
//import junit.framework.Assert;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author Admin
 */
public class MathUtilTest {
    //Đây là class sử dùng các hàm của thư viện/framewor JUnit
    //Để kiểm thử/kiểm tra code chính : hàm getFactorial() bên class core.MathUtil
    //Viết code để test code chính bên kia

    //có nhiều quy tắt đặt tên hàm kiểm thử 
    // thường là nói lên : mục đích test , các case/tình huống test 
    //tình huống theo kiểu thành công/thất bại
    //@Test JUnit sẽ phối hợp với JVM để chạy hàm này 
    //@Test phía hậu trường chính là public static void main() , ko sử dụng main() vì có sự tách biệt giữa các case vì cần nhiều main() cho tình huống khác nhau
    //Có nhiều @Test ứng với nhiều case khác nhau để kiểm thử , hàm tính giai thừa
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        // hàm chạy thành công , trả về ngon 
        // -> đặt tên hàm theo kiểu well -> argument : 5! , 6! , hok chơi đưa -5! , 30!
        int input = 0; // test thử tình huống tử tế -> phải chạy đúng
        long expected = 1;
        long actual = MathUtil.getFactorial(input); // gọi hàm cần test bên core/app chính/code chính
        // so sánh expected vs actual dùng xanh xanh đỏ đỏ -> framework
        Assert.assertEquals(expected, actual);// hàm so sánh 2 value nào đó có giống nhau ko  , nếu giống -> màu xanh  -> passed ít nhất cho cái case đag test , ngược lại thì màu đỏ 
        // gộp thêm vài case thành công /đưa đầu vào ngon , hàm phải tính ngon
        Assert.assertEquals(1, MathUtil.getFactorial(1)); // tui mún 1! == 1
        Assert.assertEquals(2, MathUtil.getFactorial(2)); // tui mún 2! == 2
        Assert.assertEquals(6, MathUtil.getFactorial(3)); // tui mún 3! == 6
        Assert.assertEquals(24, MathUtil.getFactorial(4)); // tui mún 4! == 24
        Assert.assertEquals(120, MathUtil.getFactorial(5)); // tui mún 5! == 120
        Assert.assertEquals(720, MathUtil.getFactorial(6)); // tui mún 6! == 720
    }
// Hàm getF() thiết kế có 2 tình huống xử lí : 
    // 1. Đưa data tử tế [1;20] -> tính đúng đc n!
    // 2. Đưa data cà chớn , âm , >20 -> THIẾT KẾ HÀM : NÉM RA NGOẠI LỆ 
    // Kì vọng ngoại lệ xuất hiện khi n<0 || n >20
    //Rất mong ngoại lệ xuất hiện 
    // nếu ngoại lệ xuất hiện -> hàm chạy đúng 
    // hàm nhận n < 0 || n>20 và hàm ném ra ngoại lệ => HÀM CHẠY ĐÚNG THIẾT KẾ -> XANH 
    // nếu hàm nhận vào n <0 || n >20 và hàm ÉO ném ra ngoại lệ => HÀM CHẠY SAI THIẾT KẾ , KÌ VỌNG -> ĐỎ
    //Test case : 
    // input : -5
    // expected : IllegalArgumentException xuất hiện
    // những tình huống bất thường , ngoại lệ , ngoài dự tính , dự liệu 
    // là những thứ ko thể đo lường , so sánh theo kiểu value
    // mà chỉ có thể đo bằng cách chúng có xuất hiện hay ko 
    //==>Ko sử dụng assertEquals() để so sánh 2 ngoại lệ // equals : bằng nhau hay ko trên value , ko thể so sánh lỗi nào nặng hơn
    // => Dùng @Test(expected = exception )
    //cách viết 1 : 

    @Test(expected = IllegalArgumentException.class)// khi hàm test đc chạy , kì vọng ném lỗi  IllegalArgumentException
    public void testGetFactorialGivenWrongArgumentReturnsThrowsException() {
        MathUtil.getFactorial(-1);// hàm @Test chạy ( hàm getF() ) cần phải ( kì vọng ) ném ngoại lệ  IllegalArgumentException
    }

    //cách viết 2 : 
    //Dùng lambda expression : 
    // Hàm sẽ ném về ngoại lệ nếu nhận vào 21
    @Test
    public void testGetFactorialGivenWrongArgumentReturnsThrowsException_LambdaVersion() {
        // Assert.assertThrows(expectedThrowable, runnable)// tham số 1 : loại ngoại lệ muốn so sánh , tham số 2 : đoạn code chạy văng ra ngoài runnable ( getF() )
        // MathUtil mu = new MathUtil()
        //Assert.assertThrows(IllegalArgumentException.class, mu.getFactorial(-5) );
        //
        Assert.assertThrows(IllegalArgumentException.class, () -> MathUtil.getFactorial(-5));

    }

    //BẮT NGOẠI LỆ XEM HÀM CÓ NÉM VỀ NGOẠI LỆ HAY KO KHI N CÀ CHỚN
    //CÓ NÉM , TỨC LÀ HÀM CHẠY ĐÚNG THIẾT KẾ -> XANH
    @Test
    public void testGetFactorialGivenWrongArgumentReturnsThrowsException_TryCatch() {
        //Chủ động kiểm soát ngoại lệ
        try {
            MathUtil.getFactorial(9);
        } catch (Exception e) {
            //bắt try catch là JUnit sẽ luôn ra xanh do đã chủ động kiểm soát ngoại lệ
            //nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko
            // cần có đoạn code kiểm soát đúng ngoại lệ IllegalArgumentException
            Assert.assertEquals("Cannot calculate , number must > 0", e.getMessage());
        }
    }

}
