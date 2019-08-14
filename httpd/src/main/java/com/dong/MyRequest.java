package com.dong;


import java.io.*;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Author : dong
 * Time:2019/8/11
 */
public class MyRequest {

    private String method;

    private String url;

    private String protocol;

    private Map<String, String> headers = new HashMap<>();

    private Map<String, String> requestPrames = new HashMap<>();

    public static MyRequest parse(InputStream in) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        MyRequest myRequest = new MyRequest();

        parseRequestLine(bufferedReader, myRequest);

        parseRequestHeader(bufferedReader, myRequest);

        return myRequest;
    }

    /*
    请求头的读取
     */
    private static void parseRequestHeader(BufferedReader bufferedReader, MyRequest myRequest) throws IOException {

        String line;
        while (((line = bufferedReader.readLine()) != null) && (line.trim().length() != 0)) {

            String[] framents = line.split(":");
            String key = framents[0].trim().toUpperCase();
            String value = framents[1].trim();
            myRequest.setHeader(key, value);
        }
    }

    private void setHeader(String key, String value) {
        this.headers.put(key, value);
    }


    /*
    HTTP协议的请求
    请求行
    请求方法
    请求URL
     */
    private static void parseRequestLine(BufferedReader bufferedReader, MyRequest myRequest) throws IOException {
        String line = bufferedReader.readLine();
        if (line == null) {
            throw new IOException("对方提前关闭了连接");
        }

        String[] fragments = line.split(" ");
        if (fragments.length != 3) {
            throw new IOException("错误的请求行");
        }

        myRequest.setMethod(fragments[0].trim().toUpperCase());
        myRequest.setUrl(fragments[1].trim());
        myRequest.setProtocol(fragments[2].trim());

    }

    private void setUrl(String url) throws UnsupportedEncodingException {
        String[] fragments = url.split("\\?");
        this.url = URLDecoder.decode(fragments[0].trim(), "UTF-8");
        if (fragments.length == 2) {
            setRequestParams(fragments[1].trim());
        }
    }

    private void setRequestParams(String queryString) throws UnsupportedEncodingException {

        String[] fragments = queryString.split("&");
        for (String param : fragments) {
            String[] kv = param.trim().split("=");
            String name = URLDecoder.decode(kv[0], "UTF-8");
            String value = "";
            if (kv.length == 2) {
                value = URLDecoder.decode(kv[1], "UTF-8");
            }
            requestPrames.put(name, value);
        }

    }

    private void setMethod(String method) throws IOException {
        if (method.equals("GET") || method.equals("POST")) {
            this.method = method;
            return;
        }
        throw new IOException("不支持的方法: " + method);

    }

    private void setProtocol(String protocol) {
        this.protocol = protocol;
    }


    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getProtocol() {
        return protocol;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getRequestPrames() {
        return requestPrames;
    }
}

