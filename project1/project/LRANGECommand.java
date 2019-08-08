package project;

import java.util.List;

/**
 * Author : dong
 * Time:2019/8/8
 */

public class LRANGECommand implements Command {
    private List<Object> args;

    @Override
    public void setArgs(List<Object> args) {
        this.args = args;
    }

    @Override
    public void run() {

    }
}


