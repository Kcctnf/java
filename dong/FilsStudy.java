package com.dong;

import java.io.File;
import java.util.Date;

/**
 * Autor : dong
 * Time:2018/12/5
 */
public class FilsStudy {
    public static void print(File f) {
        if (f == null) {
            return;
        }
        System.out.println((f.isFile() ? "F" : "D") + " " + f.getName() + " " + f.length() + " " +
                new Date(f.lastModified()));
        //1.for循环
        File[] files = f.listFiles();
        if (files != null) {
            for (int i = 0; i < f.length(); i++) {
                File item = files[i];
                System.out.println((item.isFile() ? "F" : "D") + " " + item.getName() + " " + item.length() + " " +
                        new Date(f.lastModified()));
            }
        }
        /*//2.foreach循环
        for (File item : files) {
            System.out.println((item.isFile() ? "F" : "D") + " " + item.getName() + " " + item.length() + " " +
                    new Date(f.lastModified()));
        }*/
    }

    public static void tree(File f) {
        if (f == null) {
            return;
        }
        if (f.isFile()) {
            System.out.println(f.getName());
        } else {
            File[] files = f.listFiles();
            if (files != null) {
                for (File item : files) {
                    tree(item);
                }
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "smd");
        //print(file);
        System.out.println();
        tree(file);

    }

}
