package 序列化;

import 序列化.domain.User;

import java.io.*;

/**
 * 序列化原理：
 *      将java内存中的对象转换成二进制流持久化存在磁盘或者进行网络传输，其他程序获取到这种二进制流就可以恢复成为原来的java对象。
 *      反序列化：ObjectInputStream 序列化：ObjectOutputStream
 *
 *  序列化的步骤：
 *      1.实现Serializable接口
 *      2.提供一个全局常量：serialVersionUID
 *      3.类的属性也需要实现Serializable接口 即可序列化
 *          默认情况下，8种基本数据类型可序列化 byte、short、int、long、float、double、char、boolean
 *
 *      补充：ObjectInputStream、ObjectOutputStream 不能序列化类的static、transient修饰的成员变量
 *           被这2个修饰后序列化该属性的值为该数据类型的默认值
 */
public class Test1 {
    public static void main(String[] args) {
        serial();
        unserial();

    }

    private static void unserial() {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("day01-IO\\data.dat"));
            User o = (User) ois.readObject();
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void serial() {
        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream("day01-IO\\data.dat");

            oos = new ObjectOutputStream(fos);
            oos.writeObject(new User("zs", 12, 1));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
