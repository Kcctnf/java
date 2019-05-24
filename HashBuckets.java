package coms;

/**
 * Author : dong
 * Time:2019/5/23
 */

/**
 * 1.哈希桶的代码实现
 *
 *    给定数据，得到下标   O（1）
 *    根据下标存到数组中   O（1）
 *
 *
 *    数组的容量永远小于存放的数据，不同的数据会得到相同的下标，叫做哈希冲突
 *        1.当保存的个数 / 容量 > 阈值
 *            进行扩容
 *        2.恶意制造数据，当哈希的某一个链表过长，就进行树化，再哈希（超过8时）
 *
 *    1.尽可能减少冲突的发生
 *    2.如果真的冲突，怎么办
 *        线性探测
 *        用链表穿起来
 */
public class HashBuckets {

    private static class Node{
        int key;
        int value;

        Node next = null;

        Node(int key,int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
           return String.format("Node(k = d%,v = d%)",key,value);
        }
    }

    private Node[] buckets = null;
    private  int size = 0;

    /**
     * void insert(int key,int value);
     * int get(int key);
     */
    public HashBuckets() {

        buckets = new Node[11];
        size = 0;
    }

    public int get(int key){
        //1.根据Key计算下标，利用哈希函数
        int index = (key % buckets.length);
        //根据下标，访问数组，得到聊表的第一个节点
        Node node = buckets[index];
        //3.在链表中查找包含key的节点，返回value
        //影响查找效率的就是冲突的节点个数，也就是链表的长度

        while(node != null){

            if(node.key == key){
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public boolean insert(int key, int value) {
        int index = (key % buckets.length);
        Node head = buckets[index];
        for (Node node = head; node != null; node = node.next) {
            if (node.key == key) {
                return false;
            }
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        // head.next = newNode;
        // head = newNode;
        buckets[index] = newNode;
        size++;

        return true;
    }

}




