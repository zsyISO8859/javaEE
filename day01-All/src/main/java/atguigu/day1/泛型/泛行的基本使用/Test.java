package atguigu.day1.泛型.泛行的基本使用;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/26 10:27
 */


public class Test {
    public static void main(String[] args) {
        Person<Integer> person = new Person<>();
        person.SetAge(12);

        Integer[] num = {1, 2, 3, 4, 5};
        Person.getArray(num);

        String[] strings = {"H", "e", "l", "l", "o"};
        Person.getStr(strings);

        //如果A是B的父类
        // 一般子类的实例是可以指向父类对象但是G<A>和G<B>是同级关系G<A>=不能等于G<B>
        // 但是G<A>和G<B>可以等于G<?>
        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        //objects=arrayList  此处编译时异常不能赋值 虽然String的父类是Object

        //可以用List<?>代表为G<A> G<B>的父类
        foreachTest(objects);
        foreachTest(arrayList);


    }


    public static void foreachTest(List<?> list) {
        //list.add("AA")  编译不通过 不能进行加入数据了
        // 但是允许遍历 遍历出来的是Object

        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            //遍历出来的是Object
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
