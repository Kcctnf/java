package project;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : dong
 * Time:2019/8/2
 */
public class Protocol {

    private static String processSimpleString(InputStream in) throws IOException {
        //"+OK\r\n"
        StringBuilder sb = new StringBuilder();
        while (true) {
            int b = in.read();
            if (b == -1) {
                throw new RuntimeException("不应该读到结尾的");
            }
            if (b == '\r') {
                int c = in.read();
                if (c == -1) {
                    throw new RuntimeException("");
                }
                if (c == '\n') {
                    break;
                }
                sb.append((char) b);
                sb.append((char) c);
            } else {
                sb.append((char) b);
            }
        }
        return sb.toString();
    }

    private static String processSimpleString1(ProtocolInputStream is) throws IOException {
        return is.readLine(is);
    }

    private static String ptocessError(ProtocolInputStream is) throws IOException {
        return is.readLine(is);
    }


    private static long processInterger(ProtocolInputStream is) throws IOException {
        return is.readInteger(is);
    }


    private static byte[] prccessBulkString(ProtocolInputStream is) throws IOException {

        int len = (int)is.readInteger(is);
        if (len == -1) {
            // "$-1\r\n"    ==> null
            return null;
        }

        byte[] a = new byte[len];
        for (int i = 0; i < len; i++) {
            int b = is.read();
            a[i] = (byte)b;
        }

        // "$5\r\nhello\r\n";
        is.read();
        is.read();

        return a;
    }


    private static List<Object> processArray(ProtocolInputStream is) throws IOException {

        int len = (int) is.readInteger(is);

        if (len == -1) {
            return null;
        }
        List<Object> list = new ArrayList<>(len);
        for(int i = 0;i < len;i++) {
            list.add(process(is));
        }
        return list;
    }

    public static Object process(ProtocolInputStream is) throws IOException {
        int b = is.read();
        switch (b) {
            case '+':
                return processSimpleString1(is);

            case '-':
                throw new RuntimeException(ptocessError(is));
            case ':':
                return processInterger(is);
            case '$':
                return prccessBulkString(is);
            case '*':
                return processArray(is);
            default:
                throw new RuntimeException("读到了错误的信息");
        }
    }
}
