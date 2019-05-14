package coms;

/**
 * Autor : dong
 * Time:2019/3/31
 */
public interface IArrayList {

    /**
     * 把item插入到线性表的最前边
     * @param item  要插入的数据
     */
    void pushFrist(int item);

    /**
     * 把item插入到线性表末尾
     */

    void pushEnd(int item);


    /**
     * 把item插入到线性表的index下表位置处，index后的数据后移
     * item    index
     */

    void add(int item ,int index);


    /**
     * 删除前面的数据
     */

    void popFront();

    /**
     * 删除后面的数据
     */

    void popBack();

    /**
     * 删除index处的数据，index后的数据前移
     */

    void remove(int index);
}
