/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/9 14:39
 */

import java.util.ArrayList;

/**
 * Collection接口：单列集合，用来存储一个个的对象
 *      list接口：存储有序的(按照数组索引的顺序存储)、可重复的数据  ”动态“数组，自动替换原有的数组
 *            ArrayList：作为List接口的主要实现类；线程不安全；效率高；底层使用Object[]数组实现
 *            LinkedList：对于频繁插入、删除的操作，使用此类效率比ArrayList高；底层使用链表实现
 *            Vector：作为List接口的古老实现类；线程安全；效率低，底层使用Object[]数组实现
 *      Set接口：存储无序的(不是按照数组索引的顺序存储而是按照数据的哈希值决定的)、不可重复的数据
 *
 *  ArrayList源码分析：
 *          jdk1.7  在new ArrayList()的时候创建长度为10的数组
 *          jdk1.8  在add()的时候才创建长度为10的数组 右移1位
 *          默认情况下扩容为原先容量的1.5倍  右移1位(除以2)
 *
 *
 *  集合的常用方法：
 *  add(Object o) / addAll(Collection c) / size() / isEmpty() / clear();
 *  contains(Object o) / containsAll(Collection c) / remove(obj o) / remove(int i) / removeAll(Collection c) / get(int i)
 *  retainAll(Collection c)[取交集] / equals(Object);
 *  toArrays() / toArrays(T[] t) / iterator() / hasCode();
 *
 *
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
        arrayList.add("ccc");

        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("ddd");
        list.add("eee");

        //获取交集
        //list.retainAll(arrayList);
        //list.forEach(x-> System.out.println(x));

        //获取不相交的部分
        arrayList.removeAll(list);
        arrayList.forEach(System.out::println);
    }
}
