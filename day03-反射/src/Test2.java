import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 */
public class Test2 {

    @Test
    public void test()throws Exception{
        Properties properties = new Properties();

        // 方式一：通过文件流获取配置文件的字节流 默认modular目录下
        // 也可以使用FileInputStream("src\\jdbc.properties")获取src目录下的配置文件
        // FileInputStream fis = new FileInputStream("jdbc.properties");

        //方式二：通过类加载器获取配置文件的字节流 默认是src目录下配置文件
        ClassLoader classLoader = Test2.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");

        properties.load(resourceAsStream);
        String user = properties.getProperty("user");
        System.out.println(user);
    }
}
