import domain.Person;
import org.junit.Test;

/**
 * 创建反射的四种方式
 * 最常用的是第三种
 * 最少用的是第二种
 *
 * 1. javac将 .java文件构建成 .class文件
 * 2. 通过类装载器将.class文件加载到内存中 ：将静态数据转换成方法区的数据结构，并在堆生成对应实例对象。
 *          装载器分3类：
 *              引导装载器：加载核心类库 不可以获取到 例如：String.getClassLoader()返回的内容为null
 *              扩展装载器：负责加载jre/lib/evt下jar包 可以手动获取
 *              系统装载器：负责加载自定义类，是最常用的加载器
 */
public class Test1 {

    //newInstance方法注意事项
    @Test
    public void test1() throws Exception{
        Class<Person> clazz = Person.class;
        /**
         * newInstance调用此方法创建运行时类对象，内部调用运行时类的空参构造器
         *
         * 要想调用此方法创建运行时类对象，要求：
         * 提供类的空参构造器
         * 空参构造器访问权限得够，通常是public。
         *
         * javabean要求提供一个public的空参构造器，原因：
         * 编译通过反射创建运行时类对象
         * 便于子类继承于此运行时类时，默认调用super()时，保证父类有此构造器。
         */
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    //四种反射的方式
    @Test
    public void test() throws Exception {
        //1
        Class clazz = Person.class;
        //2 实例化对象获取字节码
        Person person1 = new Person("zs", 12);
        Class clazz1 = person1.getClass();
        //3
        Class clazz2 = Class.forName("domain.Person");
        //4 使用类的加载器创建对象
        ClassLoader classLoader = Test1.class.getClassLoader();
        Class clazz3 = classLoader.loadClass("domain.Person");

        System.out.println(clazz == clazz1);
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);
    }

}
