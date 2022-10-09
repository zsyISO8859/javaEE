import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/2 15:53
 */

/**
 * 注意：
 * FileWriter的构造参数可以指定是追加写入 还是覆盖文件写入
 */
public class IOTest2 {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader(new File("hello.txt"));
        FileWriter fileWriter = new FileWriter(new File("hello1.txt"), true);

        int len;
        char[] chars = new char[5];
        while ((len = fileReader.read(chars)) != -1) {

            fileWriter.write(chars, 0, len);

        }


        fileWriter.close();
        fileReader.close();
    }
}
