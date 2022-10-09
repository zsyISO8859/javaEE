package atguigu.day3.多线程.wait和sleep的区别;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/30 10:14
 */

/**
 * 1.sleep是Thread的方法               wait是Object类的方法
 * 2.sleep可以在任何地方调用             wait在同步代码块和同步方法中调用
 * 3.sleep和wait都是阻塞线程            但是wait会释放线程的锁 所以调用wait其他线程也可以拿到锁而sleep不行
 * 4.sleep睡眠的时间到了之后，会自动唤醒   wait需要通过notify或notifyAll方法来唤醒
 */
public class Test {
}
