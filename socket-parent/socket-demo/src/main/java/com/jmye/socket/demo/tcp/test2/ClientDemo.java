package com.jmye.socket.demo.tcp.test2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/17 08:59
 * @Version 1.0
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);

        // 是本地的流,用来读取本地文件的.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("socketmodule\\ClientDir\\1.jpg"));

        // 写到服务器 --- 网络中的流
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);// 通过网络写到服务器中
        }
        bos.flush();
        // 给服务器一个结束标记,告诉服务器文件已经传输完毕
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        bis.close();
        socket.close();
    }
}
