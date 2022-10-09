/**
 * @author : zhousy
 * @version : 1.0
 * @date : 2022/9/1 9:23
 */

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 流的分类：
 * 按照处理数据大小：字节流(8bit 处理非文本文件)、字符流(16bit 处理文本文件)
 * 按照流的方法：输入流、输出流
 * 按照流的角色：节点流、处理流
 * <p>
 * <p>
 * 抽象基类           节点流（或文件流）                             缓冲流（处理流的一种）  内部有8kb的缓冲区处理速度快        转换流(处理流的一种)
 * InputStream      FileInputStream read(chars[])               BufferedInputStream read(chars[])                 InputStreamReader  将一个字节的输入流转换成字符的输入流  解码
 * OutputStream     FileOutputStream write(chars[], 0, len)     BufferedOutputStream write(chars[], 0, len)       OutputStreamWriter 将一个字符的输出流转换成字节的输出流  编码
 * Reader           FileReader read(chars[])                    BufferedReader read(chars[])/readLine()
 * Writer           FileWriter write(chars[], 0, len)           BufferedWriter write(chars[], 0, len)
 * <p>
 * <p>
 * 注意：1.关闭流只需要关闭处理流，文件流会自动关闭
 * 2.字节流其实可以用来复制文本文件，但是不能读入到内存中查看，因为会将文字劈开造成乱码。但是字符流不可以用来处理非文本文件。
 * <p>
 * 结论：文本文件(.txt .java .c .cpp)
 * 非文本文件(.jpg .mp3 .mp4 .avi .doc .ppt)
 * <p>
 * <p>
 * ctrl+alt+wins+t 快捷键try catch
 */
public class IOTest1 {

    public static void main(String[] args) {
        //fileReaderTest();
        //changStream();
        //dealFile();

    }

    private static void dealFile() {
        //使用缓冲流处理文件
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //注意地址的前面没有\\不然报错找不到路径
            FileInputStream fis = new FileInputStream("day04-IO\\png.jpg");
            FileOutputStream fos = new FileOutputStream("day04-IO\\png1.jpg");
            //缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] data = new byte[5];
            int len;
            while ((len = bis.read(data)) != -1) {
                bos.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //使用转换流编码、解码
    private static void changStream() {
        //使用转换流编码、解码
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            FileInputStream fis = new FileInputStream("day04-IO\\hello.txt");
            FileOutputStream fos = new FileOutputStream("day04-IO\\hello1.txt");
            //解码
            isr = new InputStreamReader(fis, "gbk");
            //编码
            osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            char[] data = new char[5];
            int len;
            while ((len = isr.read(data)) != -1) {
                System.out.print(new String(data, 0, len));
                osw.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null)
                    osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //使用文件流读文件(速度慢)
    private static void fileReaderTest() {
        FileReader fileReader = null;
        try {
            //内存总加载一个文件对象
            File file = new File("hello.txt");
            //使用节点流(文件流)处理
            fileReader = new FileReader(file);

            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
