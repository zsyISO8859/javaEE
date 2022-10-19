package day3;

/**
 * @author : zhousy
 * @date : 2022/10/19 14:47
 * @version : 1.0
 */

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 类加载与字节码技术
 *
 * 1.类文件结构
 * 2.字节码指令
 * 3.编译期处理
 *   3.1 默认构造器： 自己没有实现任何构造器，编译器就会帮忙生成一个默认无参的构造器 并调用父类Object的无参构造方法
 *
 *   3.2 自动拆装箱： 将基本类型变成包装类型成为包箱反之为拆箱，jdk5之前需要手动拆箱和装箱
 *                  Integer x = Integer.valueOf(1); 装箱
 *                  int y = x.intValue()  拆箱
 *
 *   3.3 泛行集合取值： 泛行是jdk5加入的新特性，但是java在编译泛行代码后会执行泛行擦除动作，即编译成字节码后泛行信息就会丢失
 *                   list.add(10); 编译后实际调用的是 List.add(Object o);
 *
 *                   *有些泛行信息不会擦除会被保留下来。比如LocalVariableTypeTable局部变量类型表，存储了变量的泛行是什么。
 *                    但是这些泛行信息通过反射是拿不到的，只有方法的参数和返回值上带的泛行信息通过反射才拿得到。 (详情见Test3.test例)
 *
 *   3.4 可变参数： 比如foo(String... args) 编译期就会被转换成foo(String[] args) ；
 *                如果传递的参数是0个，编译期间会传入一个长度为0的字符串数组对象 而不是传入null
 *
 *   3.5 foreach循环：
 *                   数组： for(int e : array)     编译后=  for(int i=0;i<array.length;i++)
 *                   集合： for(Integer i : list)  编译后=  while(iter.hasNext()){iter.next();}
 *                   *foreach可以配合数组，以及实现了Iterable接口的集合类一起使用
 *
 *   3.6 switch-string： switch在编译期会被拆分成2个switch，
 *                      第一个switch：会先比较hashcode(hashcode是为了提交效率)再比较equals(是为了避免hash冲突
 *                          比如"BM"、".C"的hashcode相等，这时候比较equals才能判断出2个是否相等。) 最后每个分支都会赋值给一个值给byte变量。
 *                      第二个switch，通过case(byte)变量来输出不同的结果。
 *
 *   3.7 switch-enum： 编译器会在当前类生成一个static的匿名内部类(仅jvm使用，对我们不可见)
 *                     静态匿名内部类实现：根据枚举成员个数定义一个static整数数组，给每个整数数组成员赋值。
 *                     switch通过上一步定义的静态整数数组来匹配不同的分支来执行代码
 *
 *   3.8 twr： jdk7新增语法try-with-resource try(资源变量 = 创建资源对象){}catch(){} 其中资源对象需要实现AutoCloseable接口，例如：
 *             inputstream、outputstream都实现了AutoCloseable接口，使用twr语法可以不用写finally语句块，编译器会自动帮忙
 *             生成关闭资源代码。 详情见Test3.test2
 *             *如果使用twr语法如果try中代码出现异常且finally中释放资源的时候也出现异常，外层的异常会调用addSuppressed方法
 *             将资源关闭的异常添加到已经捕获的外层的异常中去，保证2个异常都不会丢。这种语法被称为压制异常。
 *
 *
 * 4.类加载阶段
 * 5.类加载器
 * 6.运行期优化
 * */
public class Test3 {
    public void test(List<String> list, Map<Integer, Object> map) {
    }

    @Test
    public void test() throws NoSuchMethodException {
        Method test = Test3.class.getMethod("test", List.class, Map.class);
        Type[] genericParameterTypes = test.getGenericParameterTypes();
        for (Type type : genericParameterTypes) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                System.out.println("原始类型 : " + parameterizedType.getRawType());
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    System.out.println(" -泛行参数" + i + " : " + actualTypeArguments[i]);
                }
            }
        }

    }

    @Test
    public void test1() {
        System.out.println(Tdd.QQQQ.ordinal());
    }

    @Test
    public void test2() {
        //此案例证明通过twr语法catch的异常和finally里关闭资源的异常都可以捕获不会丢失
        //java.lang.ArithmeticException: / by zero
        //at day3.Test3.test2(Test3.java:93)
        //Suppressed: java.lang.Exception: 手动发起异常
        //at day3.MyResource.close(Test3.java:108)
        try (MyResource myResource = new MyResource()) {
            int i = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

enum Tdd {
    ASD, QQQQ
}

class MyResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        throw new Exception("手动发起异常");
    }
}