package 网络通信;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP
 *      使用TCP协议前必须建立TCP连接，形成数据传输通道
 *      传输前三次握手，证明通信是可靠的
 *      在连接中大量传输数据
 *      传输完，需要释放已经建立的连接，效率低
 * UDP
 *      将数据源、目的地打包，无需建立连接
 *      不管对方有没有准备好，对方收到也不确认，所以不可靠
 *      每个数据包大小限制64K
 *      传输完，无需释放资源，开销小，速度快
 *
 *  注意点：main方法中使用 FileInputStream("day01-IO\\1.jpg"); 参数前面无需\\day01-IO\\1.jpg
 *         junit中FileInputStream("1.jpg") 直接表示当前工程
 *
 *  TCP通信不先启动服务端就启动客户端会报错 而UDTP通信则不会报错
 */
public class TCPTest {

    //这里演示TCP协议进行通信
    //clientTest、ServerTest
    @Test
    public void clientTest() throws Exception {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inetAddress, 8899);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(new String("你哈！我是客户端！").getBytes());
        socket.close();
        outputStream.close();
    }

    @Test
    public void ServerTest() throws Exception {
        ServerSocket ss = new ServerSocket(8899);
        Socket accept = ss.accept();
        InputStream inputStream = accept.getInputStream();

        //将字节读入这里，防止文字被劈开导致乱码
        ByteArrayOutputStream bais = new ByteArrayOutputStream();
        byte[] bytes = new byte[5];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            bais.write(bytes, 0, len);
        }
        System.out.println(bais.toString());
        bais.close();
        inputStream.close();
        accept.close();
        ss.close();

    }

    //此处演示客户端传输文件给服务端
    //clientTest1、serverTest1
    @Test
    public void clientTest1() throws IOException {
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(byName, 8899);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("1.jpg");
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        fis.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void serverTest1() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        FileOutputStream fos = new FileOutputStream("2.jpg");
        byte[] bytes = new byte[1024];
        int len;
        while((len = inputStream.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fos.close();
        inputStream.close();
        accept.close();
        serverSocket.close();

    }

    //此处演示客户端传输文件给服务端，且服务的响应客户端收到文件
    //clientTest2、serverTest2
    //注意：read方法为阻塞方法，客户端需要手动停止传输 socket.shutdownOutput()
    //     不然服务端一直以为客户端在传输信息就阻塞在while循环中，无法执行下面的语句。
    @Test
    public void clientTest2() throws IOException {
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(byName, 8899);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("1.jpg");
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes1 = new byte[4];
        int len1;
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        while((len1 = inputStream.read(bytes1))!=-1){
            bao.write(bytes1,0,len1);
        }
        System.out.println(bao.toString());


        fis.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void serverTest2() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        FileOutputStream fos = new FileOutputStream("3.jpg");
        byte[] bytes = new byte[1024];
        int len;
        while((len = inputStream.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("文件已经收到！".getBytes());

        outputStream.close();
        fos.close();
        inputStream.close();
        accept.close();
        serverSocket.close();

    }
}

