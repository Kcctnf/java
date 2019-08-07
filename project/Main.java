package project;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author : dong
 * Time:2019/8/2
 */
public class Main {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;

        Object o = Protocol.process(in);
        System.out.println(o);


    }
}
