package atguigu.day3.多线程.callable创建多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/30 11:19
 */

/**
 * 1. callable相比runnable功能更强大
 * callable支持泛型、
 * 可以通过get()方法获取线程运行的返回值，
 * 可以抛出异常供外层捕获获取异常信息
 */
public class CallableTest {
    public static void main(String[] args) {
        CallableThread c1 = new CallableThread();
        FutureTask<Integer> futureTask = new FutureTask<>(c1);
        new Thread(futureTask).start();

        try {
            Integer integer = futureTask.get();
            System.out.println("总和=" + integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                count += i;
            }
        }
        return count;
    }
}
