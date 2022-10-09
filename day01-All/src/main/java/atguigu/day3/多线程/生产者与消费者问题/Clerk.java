package atguigu.day3.多线程.生产者与消费者问题;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/30 10:34
 */


public class Clerk {
    private int produceNum = 0;

    public synchronized void produce() {
        if (produceNum < 20) {
            produceNum++;
            System.out.println(Thread.currentThread().getName() + ":" + "当前生产的数量是第" + produceNum + "个");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumer() {
        if (produceNum > 0) {
            produceNum--;
            System.out.println(Thread.currentThread().getName() + ":" + "当前消费的数量是第" + produceNum + "个");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
