/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/8 10:47
 */

/**
 * 1.异常的体系结构：
 *
 * java.lang.Throwable
 *      |------java.lang.Error：一般不编写针对性的代码处理
 *      |------java.lang.Exception:可以进行异常处理
 *          |-------编译时异常
 *                   |---------IOException
 *                          |------FileNotFoundException
 *                   |---------ClassNotFoundException
 *          |-------运行时异常
 *                   |----------数组越界/字符串越界  ArrayIndexOutOfBoundsException
 *                   |----------空指针             NullPointException
 *                   |----------算数异常           ArithmeticException
 *                   |----------读入数值转换异常     InputMismatchException
 *                   |----------数值转换异常        NumberFormatException
 *                   |----------类型转换异常        ClassCastException
 *
 *
 */
public class ThrowableTest {
}
