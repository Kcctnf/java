package com.dong;

import java.io.File;
import java.util.Date;

/**
 * Autor : dong
 * Time:2018/12/5
 */
public class TestIo {
    public static void main(String[] args) {
        File file = new File(File.separator + "smd" + File.separator + "ssss");
        //保证文件存在，在进行操作
        if (file.exists() && file.isFile()) {
            System.out.println("文件大小" + file.length());
            System.out.println("最后一次修改日期" + new Date(file.lastModified()));
        }
    }
}

