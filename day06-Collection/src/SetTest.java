/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/13 9:28
 */

import domain.User;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 一、Set: （以hashSet为例）
 * 存储无序性：不等于随机性，每次遍历得到的结果一样。
 * 存储的数据在底层数组中并非按照数组的索引顺序添加，而是根据哈希散列值作为数组下标存储。
 * 存储不可重复性：
 * 保证添加的元素按照equals()判断是，不能返回true，即相同元素只能添加一个。
 * <p>
 * 二、添加元素的过程：（以hashSet为例）
 * 向hashSet中添加元素a，首先调用a的hashCode()方法获得哈希值
 * 此哈希值通过某种算法计算出hashSet底层数组的存放位置（即索引位置），接着判断数组在此位置上是否已经有元素：
 * 如果没有其他元素，元素a添加成功
 * 如果有其他元素，比较哈希值，值不同添加成功
 * 如果有其他元素，比较哈希值，值相同则调用equals()比较，equals返回false元素才添加成功
 * <p>
 * 对于添加成功的情况而言，如果此时算出的哈希散列值的位置已经有元素了就会采取链表的方式存储。
 * jdk7：新元素存放在数组种，指向原先的元素。
 * jdk8：原来的元素存放在数组中，用链表指向新元素
 * 总结：七上八下
 * <p>
 * 三、要求：
 * 向Set中添加数据，其所在的类一定要重写hashCode()和equals()方法
 * <p>
 * 四、补充:
 * TreeSet底层是红黑树实现的，内部会排序，所以不能添加相同的元素，且添加的类型要相同，不然不报错。
 */
public class SetTest {
    public static void main(String[] args) {
        //自然排序
        //natureSort();

        //定制排序
        TreeSet<User> ts = new TreeSet<>((x, y) ->
                x.getAge() == y.getAge() ? x.getName().compareTo(y.getName()) : x.getAge() - y.getAge());
        ts.add(new User("Aloys", 24));
        ts.add(new User("Leon", 37));
        ts.add(new User("Zoey", 24));

        for (User s : ts) {
            System.out.println(s);
        }
    }

    private static void natureSort() {
        //自然排序默认降序
        TreeSet set = new TreeSet();
        set.add(new User("zs", 2));
        set.add(new User("zs", 3));
        set.add(new User("zs", 4));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
