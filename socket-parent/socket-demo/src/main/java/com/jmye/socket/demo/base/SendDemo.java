package com.jmye.socket.demo.base;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/16 21:03
 * @Version 1.0
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        // 创建发送端的Socket对象(DatagramSocket)
        // DatagramSocket() 构造数据报套接字并将其绑定到本地主机上的任何可用端口
        DatagramSocket ds = new DatagramSocket();

        // 创建数据, 并把数据打包
        // 构造一个数据包，发送长度为 length的数据包到指定主机上的指定端口
        byte[] bytes = "Hello, UDP!".getBytes();
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 12345);

        // 调用DatagramSocket对象的方法发送数据
        ds.send(dp);

        // 关闭发送端
        ds.close();
    }
}
