package com.system.client.thread;

import java.io.IOException;
import java.net.Socket;

/**
 * Autor : dong
 * Time:2019/3/20
 */
public class ThreadClient {

    public static void main(String[] args) {


        try {
            Socket socKet = new Socket("127.0.0.1", 6666);
            System.out.println("客户端正在连接....");
            new writeDataToServer(socKet).start();
            new ReadDataFromServer(socKet).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
