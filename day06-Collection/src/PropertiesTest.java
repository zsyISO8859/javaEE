/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/16 10:15
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * Properties是Hashtable的子类
 *  常用于做配置文件
 *  load加载配置文件
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("day06-Collection\\src\\jdbc.properties");
        properties.load(fileInputStream);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password1");
        System.out.println(name);
        System.out.println(password);
    }
}
