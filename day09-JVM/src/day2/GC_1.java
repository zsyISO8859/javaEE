package day2; /**
 * @author : zhousy
 * @date : 2022/10/12 11:09
 * @version : 1.0
 */


import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 *  垃圾回收：
 *
 *  1.如何判断对象可以回收
 *    -引用计数法：一个对象被引用后计数+1 被取消引用后计数-1 归0后被垃圾回收 循环引用无法被垃圾回收 （python早期使用的垃圾回收机制）
 *    -可达性分析算法：首先确定一系列root对象(一定不能被作为垃圾回收的对象)，与根对象不存在直接、间接引用的都会被垃圾回收 （java采取的垃圾回收机制）
 *       root对象：核心类库对象、被上锁的对象、本地方法(native方法)对象、线程对象（栈帧内的东西）
 *       -四大引用类型：
 *          强：与root对象和强引用对象都断开引用才会被GC回收  =赋值就是强引用
 *          软：与强引用对象断开引用，且内存不足才会被GC回收 可以配合引用队列进一步释放软引用本身
 *          弱：与强引用对象断开引用，只要执行了GC回收不管内存是否充足都会被回收  可以配合引用队列进一步释放弱引用本身
 *          虚：虚引用(例Cleaner)在虚引用对象(例ByteBuffer)被GC回收的时候一定会进入引用队列，referenceHandler线程调用虚引用对象的clean方法的unsafe.freeMemory释放直接内存
 *          终结器引用：
 *
 *  *查看root对象的方法：jps -> 获取进程id
 *                    jmap -dump：format=b,live,file=1.bin 21384  -> 获取堆运行状态文件1.bin （format=b ：二进制文件  live：只抓存活对象）
 *                    eclipse Memory Analyzer -> 使用内存分析工具读取1.bin文件
 *
 *  2.垃圾回收算法
 *
 *  3.分代垃圾回收
 *
 *  4.垃圾回收器
 *
 *  5.垃圾回收调优
 */
public class GC_1 {
    //软引用基本使用，在内存不足的时候会回收软引用对象
    @Test
    public void test(){
        //list引用SoftReference  SoftReference引用Byte[]
        ArrayList<SoftReference<Byte[]>> list = new ArrayList<>();

        //引用队列
        ReferenceQueue<Byte[]> queue = new ReferenceQueue<>();

        for (int i = 0; i < 5; i++) {
            //将软引用对象与引用队列关联，当软引用对象被GC回收的时候，软引用就自己加入到引用队列中
            SoftReference<Byte[]> softReference = new SoftReference<>(new Byte[4 * 1024 * 1024],queue);
            System.out.println(softReference.get());
            list.add(softReference);
            System.out.println(list.size());
        }
        System.out.println("循环结束："+list.size());

        //从队列中获取无用的软引用对象并移除
        Reference<? extends Byte[]> poll = queue.poll();
        while (poll!=null){
            list.remove(poll);
            poll = queue.poll();
        }

        for (SoftReference<Byte[]> a :list){
            System.out.println(a.get());
        }
    }
}
