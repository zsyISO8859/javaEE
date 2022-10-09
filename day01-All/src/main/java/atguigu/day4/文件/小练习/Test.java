package atguigu.day4.文件.小练习;

import java.io.File;

/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/8/31 9:33
 */

/**
 * 功能： 查出指定目录下的所有文件
 */
public class Test {
    public static int sum;

    public static void main(String[] args) {
        File file = new File("C:\\mySoft\\CloudMusic");
        getFile(file);
        System.out.println("该目录文件所占内存：" + sum / 1024 / 1024);
    }

    private static void getFile(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                getFile(file1);
            } else {
                sum += file1.length();
                System.out.println("文件名称：" + file1.getName());
            }
        }
    }
}
