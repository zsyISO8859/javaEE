/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/15 10:40
 */

/**
 * HashMap底层实现原理jdk7为例子
 *  HashMap map = new HashMap();
 *  实例化之后，底层创建长度是16的一维数组Entry[] table
 *  map.put(k,v)可能多次put之后：
 *      首先，调用k所在类的hashCode()计算k的哈希值，经过某种算法(hashCode & (size-1))之后得到Entry数组的存放位置。
 *      如果此位置上的数据为空，此时的k-v添加成功
 *      如果此位置上的数据不为空(意味着此位置上存在一个或者多个数据(以链表形式存在))，比较k和一个或者多个数据的哈希值：
 *          如果k的哈希值和某个存在的k的哈希值相同，继续比较k的equals
 *              如果true：使用需要添加的v替换存在的v
 *              如果false：k-v添加成功
 *
 *       补充：k如果添加的位置有值且成功添加就会以链表的方式存储
 *       在不断添加过程中会涉及到扩容的问题，默认扩容方式为原来的2倍。并将原有的数据复制过来。
 *
 *       jdk8相比jdk7底层的实现原理不同
 *       1. 7的底层是数组+链表 8底层是数组+链表+红黑树
 *          当数组的某个索引位置上以链表的形式存在数据个数>8 且数组的长度》64
 *          此时索引位置上的所有数据使用红黑树存储。
 *       2. 7调用put方法用Entry[]存储 8调用put方法用Node[]存储
 *       3. 7new的时候就会初始化长度 8首次调用put会初始化长度为16的数组
 *
 *       default_initial_capacity HashMap的默认容量16
 *       default_load_factor      HashMap的默认加载因子0.75
 *       threshold                扩容的临界值=容量*装载因子 16*0.75=12
 *       treeify_threshold        链表的长度临界值，超过了转化为红黑树 8
 *       min_treeify_capacity     Node被转化为树的最小hash表容量  64
 */
public class MapTest1 {
}
