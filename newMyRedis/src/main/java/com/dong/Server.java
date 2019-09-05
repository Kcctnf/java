package com.dong;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    public void run(int port) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(20000);
        ServerSocket serverSocket = null;
        try {
            //循环接收来自客户端的连接
            serverSocket = new ServerSocket(6379);
            while (true) {
                final Socket socket = serverSocket.accept();
                executorService.execute(()->{

                    try {
                        //持续提供业务服务
                        while (true) {
                            InputStream read = socket.getInputStream();
                            OutputStream write = socket.getOutputStream();

                            Command command = new ProtocolDecode(read, write).readCommand();
                            if(command!=null) {
                                command.run(write);
                            }
                        }

        }
    }

    public static void main(String[] args) throws IOException {
        new Server().run(6379);

    }
}
