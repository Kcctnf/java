package coms;

/**
 * Autor : dong
 * Time:2019/5/7
 */
public class Rview {
    /*
    1. 复杂度
       衡量算法好坏的标准
       时间复杂度  重点
       每秒执行的指令个数是固定的，利用指令个数，侧面反映算法的快慢

       大 O  渐进表示法

       1.只保留最高次项    2.最高次项系数为1

       O（1）       array取下标
       O（log(n)）  二分查找，推广   和二叉树高度有关的算法

       O（n）       便利查找。顺序表头插头删
                    链表的下标访问
                    二叉树的排序

       O（n * log(n)） 堆排序   快速排序  归并排序

       O（n ^2）     冒泡  插排  选择排序

       O（2^n）      斐波那契数列

     2. 空间复杂度

        排序     快排


    */



    /*
    数据结构

       1.线性表

          1.顺序表
             优点 ： 随机访问   通过下标访问时间复杂度O（1）




          2.链表
              优点 ： 头插尾插时间复杂度为O（1）


              集合库
                 java.util.ArrayList<E>

          3.栈 和 队列

              FILO  FIFO

              java.util.Stack<E>  类




       2.树形(二叉树)
           1. 链式存储  结点
              1.  遍历方式
                  前中后序遍历（栈的影子）
                  层序遍历（队列支持）
              2.递归的写法与理解
                 1.归纳法的方式去理解，不要在一开始的时候就进行递归展开
                   1.找到递推公式   2.找到终止条件

                 变化的只有参数
                 递推 ：
                 终止 ：

           2.堆

        3. 排序

        什么情况下进行外部排序
           1.内存放不下了
           2.先把数据切割成内存放的下的大小，一共n份
           3.把每一小块排序
           4.合并n个有序数组的过程（归并）
    */

    class Node {
        int value;
        Node left;
        Node right;
    }

    //第K层的节点个数
    private static int getKLevel(Node root,int k) {
        if (root == null) {
            return -1;
        }
        if(k == 1){
            return 1;
        }
        return getKLevel(root.left,k - 1) + getKLevel(root.right,k - 1);
    }
    //插排
    private static void insertSort(int[] array){

        for(int i = 0;i < array.length;i++){
            int j;
            for(j = i - 1;j >= 0 && array[i] < array[j];j--){
                int pos = j + 1;
                int key = array[i];

                for(int k = i;k > pos;k--){
                    array[k] = array[k - 1];
                }
                array[pos] = key;
            }
        }
    }

}
