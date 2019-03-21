package com.system.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天室的服务端
 * Autor : dong
 * Time:2019/3/8
 */
public class AloneServer {

    public static void main(String[] args)  {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("客户端正在连接...");

            //接受客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("有新的客户端连接 端口为: " + socket.getLocalAddress());
            //接收数据
            InputStream inPut = socket.getInputStream();
            Scanner scanner = new Scanner(inPut);
            String message = scanner.nextLine();
            System.out.println("收到客户端的消息是：" + message);
            //发送数据
            OutputStream outPut = socket.getOutputStream();
            OutputStreamWriter  writer  = new OutputStreamWriter(outPut);
            Scanner str = new Scanner(System.in);

            writer.write(str + "\n");
            //writer.write("你好，客户端,我很好。 \n" );
            writer.flush();
            serverSocket.close();
            System.out.println("服务器关闭");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
