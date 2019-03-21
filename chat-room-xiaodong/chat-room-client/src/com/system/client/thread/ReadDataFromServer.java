package com.system.client.thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Autor : dong
 * Time:2019/3/20
 */
public class ReadDataFromServer extends Thread {

    private final Socket client;

    public ReadDataFromServer(Socket socKet) {

        this.client = socKet;
    }

    @Override
    public void run() {
        while(true){
            try {
                InputStream inPut = client.getInputStream();
                Scanner scanner = new Scanner(inPut);
                String message = scanner.nextLine();
                System.out.println(message);
                if (message.equals("bye")) {
                    client.close();
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
