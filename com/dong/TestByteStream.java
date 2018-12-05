package com.dong;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Autor : dong
 * Time:2018/12/5
 */
public class TestByteStream {
    private static class FileinputStream {
    }

    public static void code1() {
        File file = new File(File.separator + "D:" + File.separator + "smd" +
                File.separator + "ssss");
        //getparent()  创建父目录，取得父路径的对象
        if (!file.getParentFile().exists()) {
            //mkdirs()若想创建父路径，此时最好取得父路径的File类对象。
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
            System.out.println("文件删除");
        } else {
            try {
                file.createNewFile();
                System.out.println("文件创建");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void code2() {
        File inputFile = Paths.get("D:", "smd", "input.txt").toFile();
        File outputFile = Paths.get("D:", "smd", "input.txt").toFile();
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }
        FileInputStream ins = null;
        FileOutputStream out = null;
        try {
            ins = new FileInputStream(inputFile);
            out = new FileOutputStream(outputFile);
            int value = -1;
            //字节都是-1---255
            while ((value = ins.read()) != -1) {
                value = value + 32;
                out.write(value);
            }
        } //下边这个是IOE的自雷子类，所以可以省略
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭数据流
            if (ins == null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out == null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

    }
}
