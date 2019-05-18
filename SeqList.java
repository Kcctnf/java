package coms;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Autor : dong
 * Time:2019/5/7
 */


public class SeqList<E> implements List<E>, RandomAccess {

    class SeqListInterator implements Iterator<E> {
        int index;//迭代器对象

        SeqListInterator() {

            index = 0;
        }

        @Override
        public boolean hasNext() {

            return index < size;
        }

        @Override
        public E next() {
            return array[index++];
        }

        @Override
        public void remove() {
            //SeqList.this表示的时和这个迭代器对象绑定的顺序表的对象
            //调用SeqList.remove(int index)方法删除
            SeqList.this.remove(index - 1);
        }
    }

    //属性
    E[] array;//存储真正数据的位置
    int size;//顺序表中实际存储数据的个数

    final static int DEFAULT_SIZE = 10;

    public SeqList() {
        array = (E[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void clear() {
        array = (E[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public boolean add(E e) {
        array[size++] = e;
        return true;
    }

    @Override
    public String toString() {

        return super.toString();
    }

    @Override
    public Iterator<E> iterator() {

        return new SeqListInterator();
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue = array[index];
        array[index] = element;

        return oldValue;
    }

    @Override
    public void add(int index, E element) {


        for (int i = size; i > index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        E oldValue = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {

        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    //对象之间的比较一定要用equals()方法，否则比较的仅仅是对象的引用
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i > 0; i--) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {

        SeqList<E> subList = new SeqList<>();
        subList.array = Arrays.copyOfRange(array, fromIndex, toIndex);
        subList.size = toIndex - fromIndex;

        return subList;
    }


    //扩容
    private void CheckCapacity() {
        if (size < array.length) {
            return;
        }

        int oldCapacity = array.length;
        int newCapacity = 2 * oldCapacity;

        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < oldCapacity; i++) {
            newArray[i] = array[i];
        }
        array = (E[]) newArray;

    }


    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public Stream<E> stream() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<E> parallelStream() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

        throw new UnsupportedOperationException();

    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new UnsupportedOperationException();
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }


    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }


    private static void testList(List<Integer> list) {
        list.clear();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        // [0, 9]

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int item = iterator.next(); // 自动拆箱
            System.out.print(item + ", ");
        }
        System.out.println();

        iterator = list.iterator();
        while (iterator.hasNext()) {
            int item = iterator.next();
            System.out.print(item + ", ");
            if (item == 5) {
                iterator.remove();
            }
        }
        System.out.println();

        System.out.println(list);
        // [0 .. 4, 6 .. 9]
    }

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> seqList = new SeqList<>();
        testList(arrayList);
        testList(seqList);
    }


}

