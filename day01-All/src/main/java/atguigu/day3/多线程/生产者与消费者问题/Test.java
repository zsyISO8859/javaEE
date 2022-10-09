package atguigu.day3.多线程.生产者与消费者问题;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/30 10:34
 */


public class Test {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);

        p1.setName("生产者1");
        c1.setName("消费者1");

        p1.start();
        c1.start();
    }
}
