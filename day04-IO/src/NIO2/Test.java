package NIO2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * NIO2是什么：java1.4出现了NIO当时为了替换原先的IO流 效率会比价高 但是当时写的不咋滴
 *           java1.7出现了NIO2 效率好多了
 *
 *  Path Paths Files
 *  通过Paths是工具类可以获得Path  Files多了对于文件的操作
 */
public class Test {
    public static void main(String[] args) {
        Path path = Paths.get("index.html");
    }
}
