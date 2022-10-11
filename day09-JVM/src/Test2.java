/**
 * @author : zhousy
 * @date : 2022/10/11 9:27
 * @version : 1.0
 */

import org.junit.Test;

import java.util.ArrayList;

/**
 * jvisualvm命令可以查看堆内存快照，可以看到是哪个对象占用内存比较多
 *
 * 方法区： 存放类信息、类加载器、运行时常量池
 *        jdk1.6 方法区的实现方式是永久代 是属于堆中的一部分
 *        jdk1.8 方法区的实现方式是元空间 是属于本地内存即操作系统
 *
 * 运行时常量池：
 *  常量池就是一张表，虚拟机指令根据这张常量表找到执行的类名、方法名、参数类型、字面量等信息
 *  常量池是 *.class文件中的，当该类被加载，它的常量池信息就会放入运行时常量池，并把它里面的符号变为物理真实地址
 *
 *  StringTable(字符串常量池)特性：
 *      字符串常量的拼接的原理是编译期的优化
 *      字符串变量的拼接的原理是StringBuilder
 *      利用串池来避免重复创建字符串对象
 *      可以使用intern()方法将没在串池的字符串对象放入串池
 *      1.6在方法区 1.8在堆空间中
 *      底层是hash表 数组+链表
 *
 *  String s = new String("a") + new String("b");
 *  串池中情况 ： ["a","b"]
 *  堆中情况 ： new String("a") new String("b") new String("ab")
 *  调用s.intern() : 将字符串变量尝试放入串池中，有就不放入，没有就放入，会把串池的对象返回。
 *  jdk1.6 调用new String("a").intern()是往串池复制一个副本，串池和堆中的对象不是同一个
 *  jdk1.8 调用new String("a").intern()堆中对象和串池中的是同一个
 */
public class Test2 {
    @Test
    public void test() throws InterruptedException {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
        }
        Thread.sleep(10000000L);
    }

    @Test
    public void test1(){

        String s = new String("a") + new String("b");
        String intern = s.intern();
        String x = "ab";
        System.out.println(intern==x);
        System.out.println(s==x);
    }
}
class Student{
    private byte[] bytes = new byte[1024*1024];
}
