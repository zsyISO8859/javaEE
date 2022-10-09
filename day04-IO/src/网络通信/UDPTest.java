package 网络通信;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

//演示UDP编程实现远程通信

public class UDPTest {
    @Test
    public void clientTest() throws IOException {
        DatagramSocket dgs = new DatagramSocket();
        byte[] bytes = new String("你好啊！").getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket dgp = new DatagramPacket(bytes, 0, bytes.length, localHost, 8809);
        dgs.send(dgp);
        dgs.close();
    }

    @Test
    public void serverTest() throws IOException{
        DatagramSocket dgs = new DatagramSocket(8809);
        byte[] bytes = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        dgs.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData()));
        dgs.close();
    }
}
