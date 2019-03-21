package com.system.server.thread;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Autor : dong
 * Time:2019/3/20
 */
public class HandlerClient implements Runnable {

    /**
     * 维护所有的客户端
     */

    private static final Map<String, Socket> ON_LINE_MAP = new ConcurrentHashMap<>();

    private final Socket client;


    public HandlerClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        //注册 register:username
        //私聊 yatter:tosee:message
        //群聊 groupchat:message
        //退出  bye
        try {
            InputStream inPut = client.getInputStream();
            Scanner scanner = new Scanner(inPut);
            boolean regist = false;

            while (true) {

                String message = scanner.nextLine();
                if (message.startsWith("register:")) {
                    register(message);
                    regist = true;
                    continue;
                }
                if (message.startsWith("yatter:") && regist) {
                    yatter(message);
                    continue;
                }
                if (message.startsWith("groupchat:") && regist) {
                    groupchat(message);
                    continue;
                }
                if (message.startsWith("bye")) {
                    bye();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //退出
    private void bye() {
        sendMessage(this.client, "bye");
        for (Map.Entry<String, Socket> entry : ON_LINE_MAP.entrySet()) {
            if (entry.getValue().equals(client)) {
                ON_LINE_MAP.remove(entry.getKey());
            }
        }
    }

    //群聊
    private void groupchat(String message) {

        //直接选取第一个元素
        //String chatNames = message.split(":")[1];
        for (Map.Entry<String, Socket> entry : ON_LINE_MAP.entrySet()) {
            sendMessage(entry.getValue(), message.split(":")[1]);
            //entry.getValue();
        }
    }

    //私聊
    private void yatter(String message) {
        String[] chatName = message.split(":");
        Socket chat = ON_LINE_MAP.get(chatName[1]);
        if (chat == null) {
            System.out.println(chatName + "不在线");
        } else {
            sendMessage(chat, chatName[2]);
        }
    }
    //发送信息
    private void sendMessage(Socket chat, String s) {
        try {
            OutputStream outPut = chat.getOutputStream();
            OutputStreamWriter outPutWriter = new OutputStreamWriter(outPut);
            outPutWriter.write(s + "\n");
            outPutWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //注册
    private void register(String message) {
        String userName = message.split(":")[1];
        ON_LINE_MAP.put(userName, client);
        System.out.println(userName + "已上线,当前在线人数为：" + ON_LINE_MAP.size());

        sendMessage(client, "恭喜注册成功。");
    }


}
