package coms;

/**
 * Author : dong
 * Time:2019/4/1
 */
public class MyLinkList {
    private class Node {
        public int value;//要保存的数据
        public Node next;//下一个节点的线索

        Node(int v) {
            this.value = v;
            this.next = null;
        }
    }

    //如果一个节点都没有，head = null
    private Node head;//节点的头

    MyLinkList() {
        this.head = null;
    }

    //头插
    void pushFrist(int item) {
        Node node = new Node(item);
        node.next = this.head;
        this.head = node;
    }

    //头删
    void popFrist() {
        if (this.head == null) {
            throw new Error();
        }
        this.head = this.head.next;
    }

    //得到最后一个节点
    private Node getLast() {
        if (this.head == null) {
            throw new Error();
        }
        Node cur = this.head;
        while (cur != null) {
            cur = cur.next;
        }
        return cur;
    }

    public void display() {
        //如何通过循环遍历链表的每一个节点
        Node cur = this.head;
        while (cur != null) {
            //System.out.format(" %d --> ",cur.value);也可以
            System.out.print(" %d --> " + cur.value);
            cur = cur.next;
        }
    }

    //尾插
    void pushBack(int item) {
        Node node = new Node(item);
        if (this.head == null) {
            this.head = node;
        } else {
            Node cur = getLast();
            cur.next = node;
        }
    }

    //
    private Node getLastLast() {
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    //尾删
    void popBack(int item) {
        Node node = new Node(item);
        if (this.head == null) {
            throw new Error();
        }
        if (this.head.next == null) {
            this.head = null;
        } else {
            Node cur = getLastLast();
            cur.next = null;
        }
    }


    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.pushFrist(1);
        myLinkList.pushFrist(2);
        myLinkList.pushFrist(3);
        myLinkList.pushFrist(4);
        myLinkList.pushFrist(5);
        myLinkList.display();

    }
}
