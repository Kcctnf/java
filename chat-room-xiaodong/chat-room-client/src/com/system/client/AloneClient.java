package com.system.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室的客户端
 * Autor : dong
 * Time:2019/3/8
 */
public class AloneClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1",1234);
            System.out.println("连接上服务器 服务地址为: " + socket.getLocalAddress());
            //发送数据
            OutputStream outPut = socket.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outPut);
            Scanner ste = new Scanner(System.in);
            System.out.println("请输入：");
            String str1 = ste.next();

            writer.write(str1 + "\n");
           // writer.write("你好，服务器。\n");

            writer.flush();
            //接收数据
            InputStream inPut = socket.getInputStream();
            Scanner scanner = new Scanner(inPut);
            String message = scanner.nextLine();
            System.out.println("接收到服务器消息：" + message);

            System.in.read();
            //关闭客户端
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
