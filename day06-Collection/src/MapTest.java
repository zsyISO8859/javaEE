/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/14 9:21
 */

import java.util.Hashtable;
import java.util.TreeSet;

/**
 *  ----Map:双列数据，存储key-value数据
 *         -----HashMap：Map的主要实现类，线程不安全，效率高，可以存储null的key和value
 *                  -------LinkHashMap：保证在遍历元素时候可以按照添加的顺序遍历。
 *                               原因：在原有的hashMap底层结构基础上，添加一对指针，指向前一个和后一个元素
 *                               对于频繁的遍历操作，此类效率高于HashMap。
 *
 *         -----TreeMap：保证对添加的key-value进行排序，实现排序遍历，此时考虑自然排序和定制排序，底层使用红黑树(二叉树)
 *         -----Hashtable：古老实现类，线程安全，效率低，不能存储null的key和value
 *                  -------Properties：常用来处理配置文件。key和value都是String类型
 *
 *    HashMap的底层： 数组+链表 （jdk7及以前）
 *                  数组+链表+红黑树 jdk8
 */
public class MapTest {
    public static void main(String[] args) {
    }
}
