package atguigu.day3.多线程.自旋锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/31 17:50
 */

/**
 * 自旋锁spinlock
 * 是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式获取锁，
 * 好处是减少线程上下文切换的消耗，缺点是消耗cpu
 *
 * 上下文就是一个释放处理器的使用权，另外一个线程获取处理器的使用权，自发和非自发的调用操作，都会导致上下文切换，
 * 会导致系统资源开销。线程越多不一定执行的速度越快，在单个逻辑比较简单的时候，而且速度相对来说非常快的情况下，
 * 我们推荐是使用单线程。如果逻辑非常复杂，或者需要进行大量的计算的地方，我们建议使用多线程来提高系统的性能。
 *
 */
public class Test {
    private static AtomicReference<Thread> atomicReference = new AtomicReference<>();

    private static void Lock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "/t come in");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    private static void unLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + "/t unlock");
    }

    public static void main(String[] args) {
        new Thread(() -> {
            Lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            unLock();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            Lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            unLock();
        }, "B").start();
    }
}
