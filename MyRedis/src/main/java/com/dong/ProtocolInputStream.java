package com.dong;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author : dong
 * Time:2019/8/9
 */
public class ProtocolInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected ProtocolInputStream(InputStream in) {
        super(in);
    }

    public static String readLine(InputStream in) throws IOException {
        boolean needread = true;
        int b = -1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (needread == true) {
                b = in.read();
                if (b == -1) {
                    throw new RuntimeException("不应该读到结尾的");
                } else {
                    needread = true;
                }
            }
            if (b == '\r') {
                int c = in.read();
                if (c == -1) {
                    throw new RuntimeException("");
                }
                if (c == '\n') {
                    break;
                }
                if (c == '\r') {

                    sb.append((char) b);
                    b = c;

                    needread = false;
                } else {
                    sb.append((char) b);
                    sb.append((char) c);
                }

            } else {
                sb.append((char) b);
            }
        }
        return sb.toString();

    }

    public static long readInteger(InputStream in) throws IOException {

        int b = in.read();
        boolean isNegative = false;
        StringBuilder sb = new StringBuilder();

        if (b == -1) {
            throw new RuntimeException();
        }
        if (b == '-') {
            isNegative = true;
        } else {
            sb.append((char) b);
        }
        while (true) {

            b = in.read();
            if(b == -1) {
                throw new RuntimeException();
            }

            if (b == '\r') {

                int c = in.read();
                if (c == -1) {
                    throw new RuntimeException();
                }

                if (c == '\n') {
                    break;
                }

                throw new RuntimeException();
            }else{
                sb.append((char)b);
            }
        }
        long v = Long.parseLong(sb.toString());
        if (isNegative) {
            v = -v;
        }

        return v;
    }
}
