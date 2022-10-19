package day3;

/**
 * @author : zhousy
 * @date : 2022/10/18 9:51
 * @version : 1.0
 */

import org.junit.Test;

/**
 * 类加载与字节码技术
 *
 * 1.类文件结构
 * 2.字节码指令
 * 2.1入门：
 *    研究2组字节码指令：
 *    1.构造方法的指令：
 *       2a b7 00 01 b1  字节码的指令  （jvm内部解释器可以识别这些与平台无关的字节码指令最终解释为机器码执行)
 *          2a => aload_0 是将局部变量表的一个变量加载到操作数栈上，因为jvm的解释器读取数据大多数都是去操作数栈上。
 *                aload_0是将0号槽位的局部变量加载到操作数栈上，即this。
 *          b7 => invokespecial 准备进行方法调用
 *          00 01 => 引用常量池#1项，即[Method java/lang/Object."<init>":()V]
 *          b1 => 表示返回
 *
 *       b2 00 02 12 03 b6 00 04 b1
 *          b2 => getstatic 加载静态变量
 *          00 02 => 常量池中的2# [Filed java/lang/System.out:Ljava/io/PrintStream;]
 *          12 => ldc 加载参数
 *          03 => 引用常量池#3项，即[String hello world]
 *          b6 => invokespecial 准备进行方法调用
 *          00 04 => 引用常量池#4项，即[Method java/io/PrintStream.println:(Ljava/lang/String;)V]
 *          b1 => 表示返回
 *
 *       *javap -v HelloWorld.class  通过Oracle提供的javap反编译工具更清晰的阅读class文件和方法代码
 *       *LineNumberTable: 例子： line 6:0  即java代码第六行对应字节码第0行
 *       *LocalVariableTable: 局部变量表  start  Length  Slot  Name  Signature
 *                                        0       9      0   args  [Ljava/lang/String;
 *                            args的作用范围是0-9行，槽位是0，类型是String数组
 *
 *     2.图解类加载运行流程
 *       1.把class文件的常量池信息载入到运行时常量池中
 *         较小的数值和字节码指令存储在一起，比如Short.MAX_VALUE+1 就存储在运行时常量池
 *       2.把方法字节码指令放入方法区，准备开始运行了。
 *       3.运行之前会启动主线程main，并给main线程分配栈帧内存(包含局部变量表[存储变量]和操作数栈[用来存储数据和字节码指令])
 *         局部变量表长度和操作栈深度构成了栈帧内存的大小
 *       4.执行引擎从方法区读指令
 *          bipush10 将一个byte(1字节 -128 ~127)压入操作数栈中，其长度会补齐4字节，整数的话用0补齐
 *          sipush将一个short压入操作数栈中，其长度补齐4字节
 *          ldc找到常量池中的一个常量压入操作数栈中，int4个字节
 *          ldc2_w将一个long压入操作数栈中，分2次压入，因为long是8个字节  (所有大于short范围的数字就存入常量池中)
 *          istore 1将操作数栈顶数据弹出，存入局部变量表的槽位1
 *          iload_1将局部变量表1槽位的数据读入操作数栈
 *          iadd弹出操作数栈的2个数据相加后结果入操作数栈
 *          getstatic #4  找到常量池的4#，发现它是一个成员变量的引用System.out，System.out实际存储在堆内存中，将成员变量的引用放入操作数栈
 *          invokevirtual #5 找到常量池5#，发现是要执行方法PrintStream.println，这个方法的执行过程中会定位到方法区的新方法上，
 *              这个新方法会由虚拟机给他分配新的栈帧，传递参数执行新栈帧中的字节码，执行完毕，弹出栈帧，清除main操作数栈内容
 *          return 执行return 完成main方法调用，弹出栈帧 程序结束
 *
 *         *i++ 是先iload_1再iinc 1,1 (第一个1是槽位 第二个1是自增多少) 与++i相反
 *
 *    3.字节码指令
 *          ifeq 判断是否==0
 *          ifne 判断是否!=0
 *          ifIt 判断是否<0
 *          if_icmpeq 两个int是否==
 *          if_icmpne 两个int是否!=
 *          if_icmplt 两个int是否<
 *          if_acmpeq 两个引用是否==
 *          if_acmpne 两个引用是否!=
 *          ifnull 判断是否==null
 *          ifnonnull 判断是否!=null
 *
 *          byte,short,char都按int比较，因为操作数栈宽带都是4字节
 *          goto用来进行调整到指定行号的字节码
 *
 *          iconst_0得到一个0常量，比较小的数是用iconst来表示的，-1~5直接的数
 *
 *      4.构造方法
 *          <cinit>()V  编译器会从上至下，收集所有static静态代码块和静态成员的赋值代码，合并成一个特殊的<cinit>()V
 *              putfileld #4  给变量赋值
 *              putstatic #3  给static变量赋值，赋值到常量池#3项
 *          <init>()V
 *
 *      5.方法调用的字节码指令
 *        invokespecial  调用构造方法、私有方法、final方法
 *        invokevirtual  调用普通的public方法
 *        invokestatic   调用静态方法
 *
 *        *invokespecial、invokestatic属于静态绑定，在字节码生成的时候就知道如何找到是哪个类的哪个方法
 *        *invokevirtual 属于动态绑定，有可能出现方法重写，所以不确定是调用子类还是父类方法，运行期才能确定是哪个方法
 *        *字节码指令：
 *              new 在堆中分配空间，并将对象的引用放入操作数栈中
 *              dup 将操作数栈顶的对象复制一份，就是刚才创建对象的引用，再压入栈
 *              invokespecial 调用栈顶复制的那一份对象的构造方法，调用结束就从栈顶清除
 *              astore_1 将剩余的对象存储到局部变量表的d中
 *              pop 将元素从操作数栈顶弹出，并且直接废弃
 *              ireturn 返回int类型数据  (在finally中如果写了ireturn会吞掉异常)
 *              athrow 抛出异常
 *              checkcast  强制类型转换，比如将Object转换成Integer
 *
 *
 * 3.编译期处理
 * 4.类加载阶段
 * 5.类加载器
 * 6.运行期优化
 */
public class Test2 {
    public static void main(String[] args) {
        int a = 10;
        //      10  + 12 + 12
        int b = a++ + ++a + a--;
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void test() {
        //finally中return会吞调异常
        re();
    }

    public int re() {
        try {
            int i = 1 / 0;

        }finally {
            return 20;
        }

    }
}
