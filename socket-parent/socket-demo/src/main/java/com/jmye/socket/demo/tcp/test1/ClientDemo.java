package com.jmye.socket.demo.tcp.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description
 * @Author jmye
 * @Time 2023/10/17 08:54
 * @Version 1.0
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10000);

        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());
        // os.close();如果在这里关流,会导致整个socket都无法使用
        socket.shutdownOutput();// 仅仅关闭输出流.并写一个结束标记,对socket没有任何影响

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        os.close();
        socket.close();
    }
}
