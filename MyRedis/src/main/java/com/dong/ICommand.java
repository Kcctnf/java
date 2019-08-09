package com.dong;


import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Author : dong
 * Time:2019/8/9
 */
public interface ICommand {

    void setArgs(List<Object> args);

    void run(OutputStream os) throws IOException;


}
