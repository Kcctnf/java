package coms;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

/**
 * Autor : dong
 * Time:2019/3/31
 */
public class MyArrayList implements IArrayList {

    private int[] array;//保存数据的空间

    private int size;//保存有效数据个数

    MyArrayList(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    @Override
    public void pushFrist(int item) {
        for (int i = this.size; i >= 1; i--) {
            array[i] = array[i - 1];
        }
        this.array[0] = item;
        this.size++;
    }


    @Override
    public void pushEnd(int item) {
        this.array[size] = item;
        this.size++;
    }

    @Override
    public void add(int item, int index) {
        for (int i = this.size; i >= size - index; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = item;
        this.size++;
    }

    @Override
    public void popFront() {
        for (int i = 1; i < size; i++) {
            this.array[i - 1] = this.array[i];
        }
        //this.size--;
        this.array[--this.size] = 0;
    }

    @Override
    public void popBack() {
        if (this.size == 0) {
            throw new Error();
        }
        this.array[--this.size] = 0;

    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > this.size) {
            throw new Error();
        }
        for (int i = index + 1; i < this.size - 1; i++) {
            array[i] = array[i + 1];
        }
        this.array[--this.size] = 0;
    }
}
