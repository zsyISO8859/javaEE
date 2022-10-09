package day1;

/**
 * @author : zhousy
 * @date : 2022/10/2 9:45
 * @version : 1.0
 */

import java.util.Random;

/**
 * class->类装载器->(方法区、栈、堆、本地方法栈、程序计数器)
 *
 *  方法区： 类信息、字符串常量、静态变量、
 *  栈： 存放局部变量
 *  堆： 存放对象实例、数组
 *  本地方法栈：
 *
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(Math.random()*6);
    }
}
