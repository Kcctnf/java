package com.dong.commands;

import com.dong.ICommand;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Author : dong
 * Time:2019/8/9
 */
public class LRANGECommand implements ICommand {
   private List<Object> args;

    @Override
    public void setArgs(List<Object> args) {

    }

    @Override
    public void run(OutputStream os) throws IOException {

        String key = new String((byte[]) args.get(0));
        int start = Integer.parseInt(new String(byte[])args.get());
        int end = Integer.parseInt(new String(byte[])args.get());
    }
}
