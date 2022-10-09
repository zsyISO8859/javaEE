package atguigu.day3.多线程.生产者与消费者问题;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/30 10:12
 */


public class Producer extends Thread {
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(10);
                clerk.produce();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
