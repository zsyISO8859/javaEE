package day1; /**
 * @author : zhousy
 * @date : 2022/10/10 15:13
 * @version : 1.0
 */

import org.junit.Test;

/**
 * JVM ：java程序（字节码）的运行环境
 * JRE(JVM+基础类库)
 * JDK(JVM+基础类库+编译工具)
 * JavaSE（JDK+IDE工具）
 * JavaEE（JDK+应用工具+IDE工具）
 *
 * 常见JVM：HotSpot（Oracle） OpenJ9（Eclipse）
 *
 * java字节码-》类加载器-》JVM内存结构-》执行引擎
 *                     方法区、堆、栈、程序计数器、本地方法栈
 *                                  解释器、即时编译器、垃圾回收
 *
 * 程序计数器使用场景： 字节码（即jvm指令）被解释器翻译成机器码给cpu执行，
 *                  程序计数器(寄存器)会记录下一条jvm指令的地址，
 *                  解释器根据程序计数器提供的下一条jvm指令地址找到JVM指令翻译成机器码给cpu执行。
 *   程序计数器不会存在内存溢出且线程是私有的
 *
 * 栈： 即线程运行需要的内存空间，多个线程就会有多个栈 每个栈有多个栈帧 栈帧是每个方法运行需要的内存 默认大小1M
 *     -Xss8m 设置栈空间8m
 *     每个线程对应一个活动栈帧，对应当前正在执行的方法。
 *     使用jstack分析cpu打满 和 死锁问题
 *
 * 本地方法栈：java调用c或者c++的方法与底层操作系统打交道 用native修饰的方法都是本地方法比如object中的notify()
 *
 * 堆： 通过new创建的对象会使用堆内存，堆和方法区都是线程共享的，需要考虑线程安全问题，堆有垃圾回收机制
 *     -Xmx8m 设置堆空间8m
 *     堆内存诊断：
 *              jps 查看当前系统有那些java进程
 *              jmap -heap 进程id    查看堆内存占用情况
 *              jconsole            图形化工具可以查看堆内存占用情况
 */
public class Test1 {

    @Test
    public void test() throws InterruptedException {
        System.out.println(1);
        Thread.sleep(30000);
        System.out.println(2);
        byte[] bytes = new byte[1024*1024*10];
        Thread.sleep(10000);
        bytes=null;
        System.gc();
        System.out.println(3);
        Thread.sleep(10000);
    }
}
