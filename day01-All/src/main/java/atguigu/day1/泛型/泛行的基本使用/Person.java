package atguigu.day1.泛型.泛行的基本使用;

import java.util.ArrayList;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/26 10:22
 */


public class Person<E> {
    private String name;
    private E age;


    public Person() {

    }

    //该方法不能是静态的因为有泛型参数，
    // 泛型参数必须在实例化之后才会知道具体类型，
    // 而static修饰的静态方法是在类加载之前就存在了。
    public void SetAge(E age) {
        this.age = age;
    }

    public Person(String name, E age) {
        this.name = name;
        this.age = age;
    }

    //泛型方法1:
    //注意点：泛行方法和泛型类没有关系  泛行方法可以是静态的
    public static <T> ArrayList<T> getArray(T[] arr) {
        ArrayList<T> ts = new ArrayList<>();
        for (T obj : arr) {
            ts.add(obj);
        }
        return ts;
    }

    //泛型方法2
    public static <T> String getStr(T[] str) {
        StringBuilder index = new StringBuilder();
        for (T s : str) {
            index.append(s);
        }
        return index.toString();
    }

    //泛型方法3
    //设置返回值是任意类型
    public static <T> T getValue(){
        return null;
    }
}
