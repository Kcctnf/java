package coms;

import java.util.Arrays;

/**
 * Autor : dong
 * Time:2019/4/25
 */

class Heap{
    private int[] array;

    private int size;

    Heap(int[] array){
        this.array =  Arrays.copyOf(array,array.length);

    }
}
public class HeapMain {
    /*
    tree  看成完全二叉树的数组
    大堆
    时间复杂度 log(n)
    向下调整:前提  只有一个位置不满足堆的性质，其余位置都已经满足堆的性质
    */
    private static void heapify(int[] tree,int index){
       /*
        判断Index位置是不是叶子节点，
        完全二叉树，只要判断有没有左孩子就行，
        转化成数组下标越界问题
       */
        int left = 2 * index + 1;
        if(left >= tree.length){
            return;
        }
        /*


        */
        int right = 2 * index + 2;
        int max = left;
        if(right < tree.length && tree[right] > tree[left]){
            max = right;
        }
        /*

        */
        if(tree[index] >= tree[max]){
            return;
        }
        //根的值比较小，先交换
        int t = tree[index];
        tree[index] = tree[max];
        tree[max] = t;

        //继续向下调整
        heapify(tree,max);

    }


    //建堆    n * log(n) 计算之后为o(n)
    private static void createHeap(int[] array){
        //从最后一个非叶子节点开始,
        for(int i = (array.length - 2) / 2;i >= 0;i--){
            heapify(array,i);
        }
    }


    //直接选择排序
    private static void selectSort(int[] array){
        for(int i = 0;i < array.length;i++){
            int max = 0;
            for(int j = 1;j< array.length - i;j++){
                if(array[j] > array[max]){
                    max = j;
                }
                //array[max]就是最大的数，把最大的数交换到无序区间最后一个
                int t = array[max];
                array[max] = array[array.length - i -1];
                array[array.length - i -1] = t;
            }
        }
    }

}












