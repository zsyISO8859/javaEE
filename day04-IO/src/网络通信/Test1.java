package 网络通信;

import java.net.InetAddress;

/**
 * 1.网络通信中的两个主要问题：
 *   如何准确的定位网络上的主机：定位主机上的应用 -》 IP和端口号
 *   找到主机后如何高效的进行数据传输  -》  提供网络通信协议
 *
 *   网络通信协议：TCP/IP参考模型分成4层
 *              应用层   http ftp dns telnet
 *              传输层   tcp udp
 *              网络层   IP ICMP ARP
 *              物理+数据链路层  Link
 *
 * 2.如何实例化InetAddress:
 *      InetAddress.getByName("域名或者ip地址");
 *      InetAddress.getLocalHost()
 *
 * 3.IP和端口号组合得出网络的一个套接字：Socket  即网络通信就是Socket通信
 */
public class Test1 {
    public static void main(String[] args) {
    }
}
