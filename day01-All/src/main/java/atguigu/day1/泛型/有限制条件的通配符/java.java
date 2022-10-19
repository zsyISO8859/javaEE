package atguigu.day1.泛型.有限制条件的通配符;


import atguigu.day1.泛型.有限制条件的通配符.domain.Person;
import atguigu.day1.泛型.有限制条件的通配符.domain.User;

import java.util.List;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/26 15:09
 */


public class java {
    public static void main(String[] args) {
        List<? extends Person> list = null;
        List<? super Person> list1 = null;

        List<Object> list2 = null;
        List<User> list3 = null;
        List<Person> list4 = null;

        //G<? extends A> 可以作为G<A>和G<B>的父类 且B是A的子类 <=
        //list = list2; Object是Person的父类 所以编译异常
        list = list3;
        list = list4;

        //G<? super A> 可以作为G<A>和G<B>的父类 且B是A的父类 >=
        list1 = list2;
        //list1 = list3; User是Person的子类 所以编译异常
        list1 = list4;
    }
}
