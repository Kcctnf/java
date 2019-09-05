package com.dong;

import com.dong.exceptions.MyRedisException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : dong
 * Time:2019/8/2
 */
public class Protocol {

    public static Object read(ProtocolInputStream is) throws IOException {
        return process(is);
    }

    public static ICommand readCommand(ProtocolInputStream is) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, MyRedisException {
        Object o = read(is);
        if (!(o instanceof List)) {
            throw new MyRedisException("命令必须是 Array 类型");
        }

        List<Object> list = (List<Object>) o;
        //=1的时候是可以的
        if (list.size() < 1) {
            throw new MyRedisException("命令元素个数必须大于 1");
        }

        //删除第一个命令的名称
        Object o2 = list.remove(0);
        if (!(o2 instanceof byte[])) {
            throw new MyRedisException("错误的命令类型");
        }

        byte[] array = (byte[]) o2;
        String commandName = new String(array);
        String className = String.format("%sCommand", commandName.toUpperCase());
        Class<?> cls = Class.forName(className);
        if (!ICommand.class.isAssignableFrom(cls)) {
            throw new MyRedisException("错误的命令");
        }
        ICommand command = (ICommand) cls.newInstance();
        command.setArgs(list);

        return command;
    }


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

        int len = (int) is.readInteger(is);
        if (len == -1) {
            // "$-1\r\n"    ==> null
            return null;
        }

        byte[] a = new byte[len];
        for (int i = 0; i < len; i++) {
            int b = is.read();
            a[i] = (byte) b;
        }

        // "$5\r\nhello\r\n";
        is.read();
        // is.read();

        return a;
    }


    private static List<Object> processArray(ProtocolInputStream is) throws IOException {

        int len = (int) is.readInteger(is);

        if (len == -1) {
            return null;
        }
        List<Object> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
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

    public static void writeError(OutputStream os, String message) throws IOException {
        os.write('-');
        os.write(message.getBytes());
        os.write("\r\n".getBytes());
    }

    public static void writeInteger(OutputStream os, long v) throws IOException {
        // v = 10
        //:10\r\n

        // v = -1
        //:-1\r\n

        os.write(':');
        os.write(String.valueOf(v).getBytes());
        os.write("\r\n".getBytes());
    }

    public static void writeArray(OutputStream os, List<?> list) throws IOException {
        os.write('*');
        os.write(String.valueOf(list.size()).getBytes());
        os.write("\r\n".getBytes());
        for (Object o : list) {
            if (o instanceof String) {
                writeBulkString(os, (String) o);
            } else if (o instanceof byte[]) {

            } else if (o instanceof Integer) {

            } else if (o instanceof Long) {

            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void writeBulkString(OutputStream os, String s) throws IOException {

        byte[] buf = s.getBytes();
        os.write('$');
        os.write(String.valueOf(buf.length).getBytes());
        os.write("\r\n".getBytes());
        os.write(buf);
        os.write("\r\n".getBytes());

    }

    public static void writeNull(OutputStream os) throws IOException {
        os.write('$');
        os.write('-');
        os.write('1');
        os.write('\r');
        os.write('\n');
    }
}
