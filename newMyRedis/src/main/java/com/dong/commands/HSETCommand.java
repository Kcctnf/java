package com.dong.commands;

import com.dong.Database;
import com.dong.ICommand;
import com.dong.Protocol;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Author : dong
 * Time:2019/8/9
 */
public class HSETCommand implements ICommand {

    private List<Object> args;

    @Override
    public void setArgs(List<Object> args) {

        this.args = args;
    }

    @Override
    public void run(OutputStream os) throws IOException {

        String key = new String((byte[]) args.get(0));
        String field = new String((byte[]) args.get(1));
        String value = new String((byte[]) args.get(2));
        Map<String, String> hash = Database.getInstance().getHashes(key);
        boolean isUpdate = hash.containsKey(field);
        hash.put(field, value);
        if (isUpdate) {
            Protocol.writeInteger(os, 0);
        } else {
            Protocol.writeInteger(os, 1);
        }
    }


}
