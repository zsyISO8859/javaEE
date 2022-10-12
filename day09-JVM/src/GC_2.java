/**
 * @author : zhousy
 * @date : 2022/10/12 15:37
 * @version : 1.0
 */

/**
 *  垃圾回收：
 *
 *  2.垃圾回收算法
 *      -标记清除 ： 一阶段标记(遍历全部对象标记出垃圾对象)  二阶段：清除(把垃圾对象的内存起始结束地址做个标记)
 *          优点：速度快              缺点：造成内存空间不连续，形成内存碎片
 *      -标记整理 ： 先标记再整理
 *          优点：避免了内存碎片的问题   缺点：速度慢，整理牵扯到对象的移动
 *      -复制 ： 先标记 将不需要回收的对象复制到另外一块内存区 清空原先的内存区 再交换2个内存区
 *          优点：不会有内存碎片        缺点：会占用双倍的内存空间
 *   *jvm会根据实际情况调用不通的GC回收算法 （分代的垃圾回收机制）
 *   -新生代 里面是用完了就丢弃的对象，GC执行频率高
 *   -老年代 里面是长时间使用的对象，GC执行频率低
 *
 *
 *  3.分代垃圾回收
 *
 *  4.垃圾回收器
 *
 *  5.垃圾回收调优
 */
public class GC_2 {
}
