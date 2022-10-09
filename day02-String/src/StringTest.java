/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/8 15:44
 */

/**
 * String:
 * 1.String是一个对象，声明为final，不可以被继承
 * 2.String实现Serializable接口：表示支持序列化
 *         实现Comparable接口：表示String可以比较大小
 * 3.String内部定义了final char[] value用于存储字符串数据 final表示字符串不可以被查询复制
 * 4.String有不可变性：对字符串重新赋值地址会指向方法区的字符串常量池中别的常量，不会对原先的字符串赋值。
 * 5.通过字面量的方式(区别于new new出来的对象放在堆里面)给一个字符串赋值，此时的字符串声明在方法区的字符串常量池中。比如String的+= 、 replace 、 =
 * 6.字符串常量池中不会存储相同内容的字符串
 */
public class StringTest {

}

