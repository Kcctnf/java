package com.system.client.thread;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Autor : dong
 * Time:2019/3/20
 */
public class writeDataToServer extends Thread {
    private final Socket client;

    public writeDataToServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            OutputStream outPut = client.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outPut);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String str = scanner.nextLine();
                writer.write(str + "\n");
                writer.flush();

                if (str.equals("bye")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
