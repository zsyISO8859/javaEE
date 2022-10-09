package atguigu.day3.多线程.生产者与消费者问题;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/30 10:34
 */


public class Consumer extends Thread {
    Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(10);
                clerk.consumer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
