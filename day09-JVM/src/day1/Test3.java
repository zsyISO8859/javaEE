package day1;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author : zhousy
 * @date : 2022/10/11 15:42
 * @version : 1.0
 */

/**
 * StringTable调优：
 *  StringTables底层是Hash表，Hash表是数组+链表存储，所以hash表的长度过小就会导致散列函数的位置重复，就会导致将字符串放入串池中（s.intern()）速度慢。
 *  -XX:StringTableSize=1099  调整StringTable大小
 * 为什么要字符串入串池：
 *  因为串池可以去除重复字符串 例子：推特用s.intern()将用户地址信息去重复存储 将30G的地址内存优化为几百M。
 *  所以如果程序有大量重复字符串 就可以考虑入串池可以减少字符串个数且降低堆内存的使用。
 *
 * 直接内存：并不属于java虚拟机的内存管理而是系统内存
 *  用于常见的NIO操作，作为数据读写的缓冲区
 *  分配回收成本高，但是读写性能高
 *  不受jvm内存回收管理 不当操作也会导致内存溢出
 * java代码不具备磁盘读写的能力，他需要调用操作系统的方法(native方法)才能进行磁盘读写   （cpu从用户态切换到内核态）
 * 由cpu的函数将文件分次读取到系统缓冲区，java在堆内存中分配java缓冲区，需要将系统缓存区数据传输到java缓冲区 数据存了2份所以效率低。
 * ByteBuffer.allocateDirect()分配直接内存：在操作系统划分出一块java可以直接访问的缓冲区，只需要存一份，少了一次缓冲区的复制操作，所以效率高。
 *
 * 直接内存的分配与回收：
 *  使用Unsafe对象完成内存分配与回收，回收需要主动调用freeMemory方法
 *  ByteBuffer的内部实现类，使用了Cleaner(虚引用)来监测ByteBuffer对象，一旦ByteBuffer对象被垃圾回收，
 *  那么就会由ReferenceHandler线程通过Cleaner的clean方法调用freeMemory来释放直接内存
 */
public class Test3 {
    @Test
    public void test() {
        int j = 0;
        try {
            for (int i = 0; i < 10000; i++, j++) {
                String.valueOf(i).intern();
            }
        } finally {
            System.out.println(j);
        }
    }

    //模拟分配并释放直接内存
    @Test
    public void test1() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024 * 1024);
        System.out.println("分配完毕....");
        System.out.println("开始释放....");
        byteBuffer=null;
        System.gc();
        System.out.println("asds");

    }
}
