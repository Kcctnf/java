package coms;

/**
 * Author: dong
 * Time:2019/4/11
 */
public class Solution {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    链表逆置
    遍历原链表中的每一个节点
    把每一个节点，按头插的方式插入到一个新的链表中（空链表）
    返回新链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode result = null;//记录链表的第一个节点，作为整个链表

        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;//提前将cur.next记录下来

            cur.next = result;
            result = cur;
            cur = next;

        }
        return result;
    }


    class RNode {
        int val;
        RNode next;
        RNode random;//链表中任意节点的引用或为null

        RNode(int v) {
            this.val = v;
        }
    }

    /*
    链表的复制，包含随机指针
     */
    RNode copyRandomList(RNode head) {

        if (head == null) {
            return null;
        }
        //遍历原链表中的每一个节点，创建新节点
        //吧新节点插入到原节点后边
        RNode cur = head;
        while (cur != null) {
            RNode newNode = new RNode(cur.val);
            //将newNode插入到cur后边
            newNode.next = cur.next;
            cur.next = newNode;
            //让cur走向下一个
            cur = cur.next.next;
        }
        //设置新的节点random
        cur = head;
        while (cur != null) {
            RNode newNode = cur.next;

            if (cur.random == null) {
                newNode.random = null;
            } else {
                newNode.random = newNode.random.next;
            }
            //cur走向下一个节点
            cur = cur.next.next;

        }

        //拆
        cur = head;
        RNode result = head.next;
        while (cur != null) {
            RNode newNode = cur.next;

            cur.next = newNode.next;
            if (newNode != null) {
                newNode.next = newNode.next.next;
            }

            cur = cur.next;
        }
        return result;
    }


    class Node {

        int value;
        Node next;
    }

    /*
    将一个有续链表重复的节点删除
    1 2 3 3 4 5 ---》 1 2 3 4 5

     */
    private static Node deleteDuplicate(Node head) {
        Node p1 = head;
        Node p2 = head.next;
        Node prev = null;

        while (p2 != null && p1 != null) {
            if (p1.value != p2.value) {
                prev = p1;
                p1 = p1.next;
                p2 = p2.next;
            } else {
                while (p2.value == p1.value) {
                    p2 = p2.next;
                }
                if (p1 == head) {
                    head = p2;
                } else {
                    prev.next = p2;
                }
                p1 = p2;
            }
        }
        return head;
    }

    /*
    以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
    注意：分割以后保持原来的数据顺序不变。
     */
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode small = null;//小于x
        ListNode smallLast = null;//小于X的最后一个节点
        ListNode big = null;//大于等于
        ListNode bigLast = null;//大于等于的最后一个节点
        ListNode cur = pHead;

        while(cur != null){
            ListNode next = cur.next;
            //小于尾插到small，大于等于尾插到big
            if(cur.val < x){
                if(small == null){
                    small = cur;
                }else{
                    smallLast.next = cur;
                }
                //更新最后一个节点的记录
                smallLast = cur;
            }else{
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                //更新
                bigLast = cur;
            }
            cur = next;
        }
        if(small == null){
            return big;
        }
        else{
            smallLast.next = big;
            return small;
        }
    }


    /*
    输入一个链表，输出该链表中倒数第k个结点
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode front = head;
        ListNode back = head;
        int i;
        for(i = 0;front != null && i < k;i++){
            front = front.next;
        }
        if(front == null && i < k){
            return null;
        }else if(front == null){
            return head;
        }
        while(front != null){
            front = front.next;
            back = back.next;
        }
        return back;
    }

    /*
    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode last = null;
        ListNode n1 = l1;
        ListNode n2 = l2;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        /*
        尾插
        node.next = null;
        if(result == null){
        result = node;
        }else{
        ListNode last = null;
        last.next = node;
        }
        */
        while(n1 != null && n2 != null){
            if(n1.val <= n2.val){
                if(result == null){
                    result = n1;
                }else{
                    last.next = n1;
                }
                last = n1;
                n1 = n1.next;
            }else{
                if(result == null){
                    result = n2;
                }else{
                    last.next = n2;
                }
                last = n2;
                n2 = n2.next;
            }if(n1 != null){
                //n1的节点还没处理完
                last.next = n1;
            }else{
                //n2的节点还没处理完
                last.next = n2;
            }
        }
        return result;
    }

}







