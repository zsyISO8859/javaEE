package my;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * @author : zhousy
 * @date : 2022/10/1 10:31
 * @version : 1.0
 */


public class Person {
    @Test
    public void test() {
        Class<Student> studentClass = Student.class;
        Annotation[] declaredAnnotations = studentClass.getDeclaredAnnotations();
        Annotation[] annotations = studentClass.getAnnotations();
        System.out.println();
    }
}

@MyAnnotation
@MyAnnotation
class man<@MyAnnotation T> {

    private String name;

    @MyAnnotation("asd")
    public man(String name) {
        this.name = name;
    }

    public man() {
    }

    public void talk() {
        ArrayList<@MyAnnotation Object> objects = new ArrayList<>();
        String str = (@MyAnnotation String) "sad";
        System.out.println("talk....");
    }
}

class Student extends man {
    @Override
    public void talk() {
        super.talk();
    }
}
