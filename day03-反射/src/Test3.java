/**
 * @author : zhousy
 * @date : 2022/9/26 9:18
 * @version : 1.0
 */

import domain.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射赋值
 */
public class Test3 {
    @Test
    public void test()throws Exception{
        Class<Person> clazz = Person.class;
        //使用空参构造器获取对象
        Person person = clazz.newInstance();
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();

        Field name = clazz.getDeclaredField("name");
        //设置私有属性可修改
        name.setAccessible(true);
        //修改私有属性
        name.set(person, "zsy");


        System.out.println(person);

    }

    /**
     * 通过反射调用类方法
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        Method show = personClass.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        Object zyp = show.invoke(person, "zyp");
        System.out.println(zyp);
    }
}
