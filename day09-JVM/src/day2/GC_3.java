package day2; /**
 * @author : zhousy
 * @date : 2022/10/13 9:33
 * @version : 1.0
 */

import java.util.ArrayList;

/**
 *  垃圾回收：
 *
 *  1.如何判断对象可以回收
 *  2.垃圾回收算法
 *
 *
 *  3.分代垃圾回收
 *     -新生代(伊甸园 幸存区Form 幸存区To)
 *        新生代的伊甸园内存不够了就会触发GC回收(Minor GC)
 *        ->采用复制算法把伊甸区的存活对象复制到幸存区To;幸存对象寿命+1;交换幸存区Form和To的位置(内存地址不变)
 *        ->幸存区的对象寿命超过了阈值15就会晋升到老年代
 *        Minor GC会引发stop the world 暂停其他用户的线程，等垃圾回收结束，用户线程才恢复运行，
 *        ->由于新生代都是垃圾对象会被回收，要复制的对象很少所以触发stw的时间比较短
 *     -老年代
 *        当老年代内存不足，先尝试Minor GC，如果之后空间依然不足就会触发一次 full GC，STW的时间更长，
 *  *新生代内存不足了，即使对象寿命阈值没达到15次也会进入到老年代。
 *  *大对象在老年代空间足够，在新生代空间肯定不够的情况下会直接晋升到老年代，不会触发GC
 *  *一个线程内的OutOfMemory不会导致一个java的进程停止
 *
 *  jvm虚拟机参数详解：
 *  -Xms20M 堆初始大小
 *  -Xmx20M 堆最大大小
 *  -Xmn10M 同事指定堆内部新生代的初始、最大大小；也可以分开指定
 *  -XX:+UseSerialGC  指定垃圾回收器，因为jdk8的垃圾回收器不是它，所以我们指定它以后幸存区才不会动态调整
 *  -XX:+PrintGCDetails -verbose:gc  打印垃圾回收时候的详情信息
 *
 *  例子：
 *  Heap(堆)
 *  def new generation(新生代)   total 9216K, used 2362K
 *   eden(伊甸园) space 8192K,  28% used
 *   from(幸存区) space 1024K,   0% used
 *   to(幸存区)   space 1024K,   0% used
 *  tenured generation(老年代)   total 10240K, used 0K
 *    the space 10240K,   0% used
 *  Metaspace(元空间)       used 3362K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 366K, capacity 388K, committed 512K, reserved 1048576K
 *
 *
 *
 *  4.垃圾回收器
 *
 *  5.垃圾回收调优
 */
public class GC_3 {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        list.add(new byte[1024 * 1024 * 7]);
        list.add(new byte[1024 * 512]);
        list.add(new byte[1024 * 512]);

        /**
         *  由于list.add(new byte[1024*1024*7]);新生代内存不足所以发生了一次GC
         *  由于2次list.add(new byte[1024*512]);新生代内存不足又发生了一次GC
         *
         *  案例演示：新生代内存不足了，即时对象寿命阈值没达到15次也会进入到老年代。
         *
         *  GC类型                   新生代内存回收变化              回收时间             堆内存回收(堆总内存)     回收时间                                  GC耗时
         * [GC (Allocation Failure) [DefNew: 2197K->754K(9216K), 0.0014766 secs] 2197K->754K(19456K), 0.0015127 secs] [Times: user=0.00 sys=0.02, real=0.00 secs]
         * [GC (Allocation Failure) [DefNew: 8762K->517K(9216K), 0.0043112 secs] 8762K->8435K(19456K), 0.0043301 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * Heap
         *  def new generation   total 9216K, used 1194K
         *   eden space 8192K,   8% used
         *   from space 1024K,  50% used
         *   to   space 1024K,   0% used
         *  tenured generation   total 10240K, used 7918K
         *    the space 10240K,  77% used
         *  Metaspace       used 3448K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
         */
    }
}
