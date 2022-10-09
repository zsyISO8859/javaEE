/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/16 9:36
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections工具类常用方法
 * reverse(List)反转list中元素顺序
 * shuffle(List)对list中元素进行随机排序
 * sort(List)集合元素升序排序
 * sort(List,Comparator) 指定排序List
 * swap(List,int,int)交换list中2个位置的元素
 *
 * max(Collection)返回集合中最大元素
 * min(Collection)返回集合中最小元素
 * int frequency(collection,Object) 返回指定集合中指定元素出现的次数
 * void copy(list dest,list src)将src内容复制到dest
 * boolean replaceAll(list,Object oldV,Object newV):使用新值替换旧值
 *
 * 注意：arraylist和hashmap都是线程不安全的，如果要线程安全，我们需要将他俩转为线程安全
 *      可以使用Collections的 synchronizedList(List list) / synchronizedMap(Map map)方法
 */
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("AA");
        arrayList.add("BB");
        arrayList.add("CC");
        //错误方法
        //ArrayList<String> arrayList1 = new ArrayList<>();
        //Collections.copy(arrayList1, arrayList);

        //正确方法
        List<String> list1 = Arrays.asList(new String[arrayList.size()]);
        Collections.copy(list1, arrayList);
        System.out.println(list1);




    }
}
