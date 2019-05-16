package coms;

/**
 * Author : dong
 * Time:2019/4/25
 */
public class MyHeap {
    private static void heapify(int[] tree,int index){
        int left = 2 * index + 1;
        if(left >= tree.length){
            return;
        }
        int right = 2 * index + 2;
        int max = left;
        if(right < tree.length && tree[right] > tree[right]){
            max = right;
        }
        if(tree[index] >= tree[max]){
            return;
        }
        int t = tree[index];
        tree[index] = tree[max];
        tree[max] = t;

        heapify(tree,max);

    }
}
