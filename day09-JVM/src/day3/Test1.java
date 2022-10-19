package day3;

/**
 * @author : zhousy
 * @date : 2022/10/17 10:41
 * @version : 1.0
 */

/**
 * 类加载与字节码技术
 *
 * 1.类文件结构
 *
 * ClassFile {
 *字节数u4 magic;  魔术
 *     u2 minor_version;  小版本号
 *     u2 major_version;  主版本号
 *     u2 constant_pool_count;  常量池信息
 *     cp_info constant_pool[constant_pool_count-1];
 *     u2 access_flags;  访问修饰public
 *     u2 this_class;    自己的包名
 *     u2 super_class;   父类信息
 *     u2 interfaces_count;  接口信息
 *     u2 interfaces[interfaces_count];
 *     u2 fields_count;  类中的成员变量
 *     field_info fields[fields_count];
 *     u2 methods_count;  方法信息
 *     method_info methods[methods_count];
 *     u2 attributes_count;  类附加属性信息
 *     attribute_info attributes[attributes_count];
 * }
 * 1.1 0~3字节表示魔术名称
 *     0000000 [ca fe ba be] 00 00 00 34 00 23 0a 00 06 00 15 09
 *
 * 1.2 4~7版本号
 *     0000000 ca fe ba be [00 00 00 34] 00 23 0a 00 06 00 15 09
 *     【00 00 00 34（十进制52）表示jdk8，35表示jdk9，33表示jdk7】
 *
 * 1.3 8~9表示常量池长度
 *     0000000 ca fe ba be 00 00 00 34 [00 23] 0a 00 06 00 15 09
 *     【00 23（十进制35）表示常量池有#1~#34项，注意#0项不计入，也没有值】
 *
 * 1.4 访问修饰符和继承信息
 *     0000660 29 56 00 21 00 05 00 06 00 00 00 00 00 02 00 01
 *     【00 21 即：20+1=public+super=公共的类  】
 *     【00 05 表示根据常量池中 #5 找到本类全限定名】
 *     【00 06 表示根据常量池中 #6 找到父类全限定名】
 *     【00 00 表示接口的数量，本类为 0】
 *
 * 1.5 Field信息
 *     0000660 29 56 00 21 00 05 00 06 00 00 00 00 00 02 00 01
 *     【00 00 表示成员变量数量，本类为 0】
 *
 * 1.6 Method信息
 *
 * 1.7 附加属性
 *    0001100 00 12 00 00 00 05 01 00 10 00 00 00 01 00 13 00
 *    0001120 00 00 02 00 14
 *    【00 01 表示附加属性数量】
 *    【00 13 表示引用了常量池 #19 项，即【SourceFile】】
 *    【00 00 00 02 表示此属性的长度】
 *    【00 14 表示引用了常量池 #20 项，即【HelloWorld.java】】

 *
 * 2.字节码指令
 * 2.1
 * 3.编译期处理
 * 4.类加载阶段
 * 5.类加载器
 * 6.运行期优化
 */
public class Test1 {
}
