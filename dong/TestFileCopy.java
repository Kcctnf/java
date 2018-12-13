package com.dong;

import java.io.*;
import java.nio.file.Paths;

/**
 * Autor : dong
 * Time:2018/12/9
 */
public class TestFileCopy {
    public static void copy(String srcFilePath, String destFilePath) {
        //参数校验
        if (srcFilePath == null || srcFilePath.isEmpty()) {
            throw new IllegalArgumentException("not null");
        }
        if (destFilePath == null || destFilePath.isEmpty()) {
            throw new IllegalArgumentException("not null");
        }
        //文件校验及准备工作
        File srcFile = Paths.get(srcFilePath).toFile();
        File destFile = Paths.get(destFilePath).toFile();
        if (!srcFile.exists() || !srcFile.isFile()) {
            throw new IllegalArgumentException("not exists/not File");
        }
        File parentFile = destFile.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                throw new RuntimeException("can't create " + parentFile.getAbsolutePath() + " directory");
            }
        }
        try (FileInputStream inputstream = new FileInputStream(srcFile);
             FileOutputStream outputstream = new FileOutputStream(destFile)) {
            //缓存数组
            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = inputstream.read(buff)) != -1) {
                outputstream.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String src = "D:\\src\\sss";
        String dest = "D:\\dest\\ee";
        long start = System.currentTimeMillis();
        copy(src, dest);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000);//换算为妙
    }

}
