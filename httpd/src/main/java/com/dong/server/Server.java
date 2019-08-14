package com.dong.server;

import com.dong.MyRequest;
import com.dong.Status;
import com.dong.WebApp;
import com.dong.controllers.Controller;
import com.dong.controllers.StaticController;


import javax.xml.ws.Response;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    private static final String HOME = System.getenv("JM_HOME");
    private final Controller staticController = new StaticController();
    private final WebApp webApp = WebApp.parseXML();

    public Server() throws DocumentException, MalformedURLException {
    }

    public void run(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                MyRequest request = MyRequest.parse(socket.getInputStream());
                Response response = Response.build(socket.getOutputStream());

                // 如果 url 对应静态文件存在，就当成静态文件处理，否则当成动态文件处理
                String filename = getFilename(request.getUrl());
                File file = new File(filename);
                Controller controller = null;
                if (file.exists()) {
                    // 当成静态文件处理
                    controller = staticController;
                } else {
                    // /list        => ListController
                    // 当成动态 controllers 处理
                    controller = webApp.findController(request);
                }

                System.out.println(request.getUrl());
                System.out.println(controller);

                if (controller == null) {
                    response.setStatus(Status.NOT_FOUND);
                    response.println(Status.NOT_FOUND.getReason());
                } else {
                    switch (request.getMethod()) {
                        case "GET":
                            controller.doGet(request, response);
                            break;
                        case "POST":
                            controller.doPost(request, response);
                            break;
                        default:
                            response.setStatus(Status.METHOD_NOT_ALLOWED);
                            response.println(Status.METHOD_NOT_ALLOWED.getReason());
                    }
                }

                response.flush();
                socket.close();
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }

    private String getFilename(String url) {
        if (url.equals("/")) {
            url = "/index.html";
        }
        return HOME + File.separator + "webapp" + File.separator + url.replace("/", File.separator);
    }

    public static void main(String[] args) throws DocumentException, IOException {
        new Server().run(8080);
    }
}
