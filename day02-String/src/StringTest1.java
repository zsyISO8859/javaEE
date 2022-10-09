/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/8 16:46
 */

/**
 * 1.常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量。
 * 2.只要其中一个是变量，结果就存在堆中
 * 3.如果拼接的结果调用intern，返回值就在常量池
 */
public class StringTest1 {
    public static void main(String[] args) {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);

        String s8 = s5.intern();
        System.out.println(s8==s3);

        System.out.println("----------------------");

    }
}
