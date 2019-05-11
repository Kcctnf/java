package coms;

/**
 * Author : dong
 * Time:2019/4/27
 */
public class Sort {

    /*
    1. 插入排序   1.遍历方式  2，二分查找
    2.希尔插入排序（分组插排）
    */
    public static void insertSort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            //有序【0，i）
            //无序【i，array.length)
            //1.在有序空间遍历查找，从后往前
            int j;
            for(j = i -1;j >= 0 && array[i] < array[j];j--){

                //j+1就是要插入的下标
                //插入数据,从后往前移动数据
                int pos = j + 1;
                int key = array[i];
                for(int k = i;k > pos;k--){
                    array[k] = array[k - 1];
                }

                array[pos] = key;
            }
        }

    }


    //重点
    public static void insertSort2(int[] array){
        for(int i = 0;i < array.length;i++){
            int key = array[i];
            int j = i -1;
            for(;j >= 0 && key < array[j];j--){
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }


    //希尔排序
    private static void insertSortWithGap(int[] array,int gap){
        for(int i = 0;i < array.length;i++){
            int key = array[i];
            int j = i - gap;
            for(;j >= 0 && key < array[j]; j = j -gap){
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }

    private static void shellSort(int[] array) {

        int gap = array.length;
        while(true){
            //gap = gap /2;
            gap = (gap / 3) + 1;
            insertSortWithGap(array,gap);
            if(gap == 1){
                break;
            }
        }
    }

    /*
    1.选择排序 2.堆排序 3.冒泡排序
    */

    //选择排序
    private static void selectSort(int[] array){
        for(int i = 0;i <array.length;i++){
            //有序[0,i)
            //无序[i,array.length)
            int min = i;//记录最终最小数的下标
            for(int j = i + 1;j < array.length;j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            swap(array,min,i);
        }
    }

    //冒泡排序
    private static void bubbleSort(int[] array){
        for(int i = 0;i < array.length;i++){
            boolean isSort = true;
            //最小数冒泡到最前边
            //有序[0,i)
            //无序[i,length)
            //要把最小的数冒泡到最前需要从后往前冒泡
            for(int j = array.length - 1;j > i;j--){
                if(array[j] < array[j -1]){
                    swap(array,j,j - 1);
                    isSort = false;
                }
            }
            if(isSort){
                break;
            }
        }
    }



    //堆排序


    //向下调整
    private static void heapify(int[] array,int size,int index){
        //判断是不是叶子
        int left = 2 * index +1;
        while(left < size){
            //找到最大孩子的下标
            int max = 2 * index + 1;
            if(max +1 < size && array[max + 1] > array[max]){
                max = 2 * index +2;
            }

            //判断最大孩子和根的值

            if(array[index] < array[max]){
                swap(array,index,max);
                index = max;
            }else{
                // 4. 根的值比较大，可以直接结束了
                // 不交换，也不继续往下走了
                break;
            }
        }
    }

    //建堆
    private static void createHeap(int[] array) {
        // [从最后一个非叶子结点的下标, 根] 向下调整
        // [(array.length - 2) / 2, 0]

        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            heapify(array, array.length, i);
        }
    }

    //排序
    private static void heapSort(int[] array){
        createHeap(array);

        //减治处理
        for (int i = 0; i< array.length; i++) {
            // 无序 [0, length - i - 1]
            // 有序 [length - i, length)
            // 最大的数在 [0], 最大的数应该放到的下标是
            // [length - i  - 1]
            swap(array, 0, array.length - 1 - i);
            // 处理 [0] , 无序剩余部分满足堆的性质
            // 无序 [0, length - i - 2]
            // 有序 [length - i - 1, length)
            // size 剩余无序部分的长度
            heapify(array, array.length - 1 - i, 0);
        }
    }

    /*
    快速排序
   （
    一些优化方法:1.要排序的数据长度 <= 20，用插入排序
                2.做partition时可以将与基准值相等的分出来

    ）
    1.选择一个基准值（选择最右边的数作为基准值）
      随机法和三数取中法
    2.遍历整个区间，每个数都和基准值比较，并且发生交换遍历结束后，使得
      比基准值小的（包括等于）都在基准值的左边
      比基准值大的数（包括等于）都在基准值的右边
    3.分治算法
      分别对左右两个小区间进行同样的方式处理
      直到：小区间的size==0或者siza == 1（有序）
    */

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /*
    hover法
    */
    private static int partition1(int[] array, int left, int right) {
        int begin = left;
        int end = right;
        int pivot = array[right];
        while (begin < end) {
            while (begin < end && array[begin] <= pivot) {
                begin++;
            }
            //array[begin] > pivot
            while (begin < end && array[end] >= pivot) {
                end--;
            }
            //array[end] < pivot
            swap(array, begin, end);
        }
        return begin;
    }

    /*
    挖坑法
    */
    private static int partition2(int[] array, int left, int right) {
        int begin = left;
        int end = right;
        int pivot = array[right];
        while (begin < end) {
            while (begin < end && array[begin] <= pivot) {
                begin++;
            }
            array[end] = array[begin];

            while (begin < end && array[end] >= pivot) {
                end--;
            }
            array[begin] = array[end];
        }
        array[begin] = pivot;
        return begin;

    }

    /*
    前后下标法
    选最边上作为基准值时，当数组已经有序或数组逆序，都是最坏情况

    利用随机法和三数取中法获取基准值，然后将基准值换到右边
    */
    private static int partition3(int[] array, int left, int right) {
        int d = left;
        for (int i = left; i < right; i++) {
            if (array[i] < array[right]) {
                swap(array, d, i);
                d++;
            }
        }
        swap(array, d, right);
        return d;
    }


    /*
    三数取中法,有效避免最坏情况出现的概率
    */

    private static int sanShuQuZhong(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (array[left] > array[right]){
            if(array[left] < array[mid]){
                return left;
            }else if(array[mid] > array[right]){
                return mid;
            }else{
                return right;
            }
        }else{
            if(array[right] < array[mid]){
                return right;
            }else if(array[mid] > array[left]){
                return mid;
            }
            return left;
        }
    }

    private static void quickSortInner(int[] array, int left, int right) {

        // 直到 size == 1 || size == 0
        if (left == right) {
            // size == 1
            return;
        }

        if (left > right) {
            // size == 0
            return;
        }

        // 要排序的区间是 array [left, right]
        // 1. 找基准值，array[right];
        int originIndex = sanShuQuZhong(array, left, right);
        swap(array, originIndex, right);
        // 2. 遍历整个区间，把区间分成三部分
        int pivotIndex = partition3(array, left, right);
        // 比基准值小的 [left, pivotIndex - 1]
        // 比基准值的 [pivotIndex + 1, right]
        // 3. 分治算法
        // 处理比基准值小的区间
        quickSortInner(array, left, pivotIndex - 1);
        // 处理比基准值大的区间
        quickSortInner(array, pivotIndex + 1, right);

    }


    public static void quickSort(int[] array) {
        //
        quickSortInner(array, 0, array.length - 1);
    }

    /*
    归并排序  分治算法
    1.把要排序区间平均切割成两部分
    2.分治算法，对左右两边小区间进行同样方式排序
      直到：size == 1 已经有序
            size == 0 一边没有数字（实际上size不会等于0）
    3.合并两个有序空间到一个有序空间（额外空间）

    时间复杂度  O（n * log(n)）
    空间复杂度  O（n）

    外部排序最好的算法（内存放不下了就用外部排序）
    */

    //合并两个数组
    private static void merge(int[] array, int low, int mid, int high,int[] extra) {
        //int[] extra = new int[high - low];

        //在这块new新空间的话，太浪费，直接在下边new一个大点的就行
        int i = low;
        int j = mid;
        int x = 0;
        while (i < mid && j < high) {
            if (array[i] < array[j]) {
                extra[x++] = array[i++];
            } else {
                extra[x++] = array[j++];
            }
        }

        //有一个数组的所有数都被拿完了
        while (i < mid) {
            extra[x++] = array[i++];
        }
        while (j < high) {
            extra[x++] = array[j++];
        }

        //将数据从extra拿回原来的array
        for (int k = low; k < high; k++) {
            array[k] = extra[k - low];
        }
    }

    private static void mergeSortInner(int[] array, int low, int high,int[] extra) {

        // array[low, high)
        // [3, 4)
        if (low == high - 1) {
            return;
        }

        if (low >= high) {
            return;
        }

        // 1. 平均切分
        int mid = low + (high - low) / 2;
        // [low, mid) + [mid, high)
        // 2. 分治算法处理所有两个小区间
        mergeSortInner(array, low, mid, extra);
        mergeSortInner(array, mid, high, extra);

        // 左右两个小区间已经有序了
        merge(array, low, mid, high, extra);

    }

    public static void mergeSort(int[] array) {

        int[] extra = new int[array.length];
        mergeSortInner(array,0,array.length,extra);

    }

    /*
    归并排序非递归法
    */

    private static void mergeSortNorR(int[] array) {
        int[] extra = new int[array.length];
        for (int i = 1; i < array.length; i = i * 2) {
            for (int j = 0; j < array.length; j = 2 * i + j) {
                int low = j;
                int mid = low + i;
                if (mid >= array.length) {
                    continue;
                }
                int high = mid + i;
                if (high > array.length) {
                    high = array.length;
                }
                merge(array, low, mid, high, extra);
            }
        }
    }

    public static void main(String[] args) {
    /*
    从功能角度分类
           直接插入排序  （减治算法）
           每次从无需部分抓一张，在有序部分找到合适的位置插入进去

           希尔排序  （插入排序的进化版本）
    */


    int[] array = {2,5,7,3,8,10,89};
    selectSort(array);
    for(int f : array){
        System.out.println(f);
    }
    }
}





