package project;

/**
 * Author : dong
 * Time:2019/8/8
 */
import java.util.List;

public interface Command {
    void setArgs(List<Object> args);

    void run();

}
