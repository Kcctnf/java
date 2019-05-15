package coms;

/**
 * Autor : dong
 * Time:2019/4/13
 */
public class Main {

    private static class Node {
        char value;
        Node left;
        Node right;

        Node(char v) {
            this.value = v;
        }
    }

    //前序遍历
    private static void fomalXu(Node root) {
        if (root != null) {
            //前序遍历二叉树
            System.out.println(root.value + " ");
            //提前定义一个count并进行初始化
            //count++
            fomalXu(root.left);
            fomalXu(root.right);
        }
    }

    //二叉树有多少个节点
    private static int count(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return count(root.left) + count(root.right) + 1;
        }
    }

    //叶子节点的的个数
    private static int leafCount(Node root) {
        if (root == null) {
            return 0;
        }
        //必须要进行判断
        else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return count(root.left) + count(root.right);
        }
    }

    //求二叉树的高度
    private static int height(Node root) {
        if (root == null) {
            return 0;
        }
        //可以不进行判断，因为左右为0时+1就行
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = height(root.left);
        int right = height(root.right);
        // return Math.max(left,right) + 1;这个也可以
        return (left > right ? left : right) + 1;
    }

    //求第K层的节点个个数
    //得先知道k - 1 层的数目
    private static int kLevel(Node root, int k) {
        if (root == null) {
            return 0;
        } else if (k == 1) {
            return 1;
        } else {
            return kLevel(root.left, k - 1) + kLevel(root.right, k - 1);
        }
    }

    //寻找是 V 节点
    private static Node serach(Node root, int v) {
        if (root == null) {
            return null;
        }
        /*if(root.left == null && root.right == null){
            return root;
        }*/
        else if (root.value == v) {
            return root;
        }
        //左子树
        Node r = serach(root.left, v);
        if (r != null) {
            return r;
        }
        //右子树
        r = serach(root.right, v);
        if (r != null) {
            return r;
        }
        return null;
    }

//
    public Node find(Node root, char v) {
        if (root == null) {
            return null;
        }
        //比较根节点
        else if (root.value == v) {
            return root;
        }
        //去左子树查找
        Node r = new Node(v);
        r = find(root.left, v);
        if (r != null) {
            return r;
        }
        r = find(root.right, v);
        if (r != null) {
            return r;
        }
        return null;
    }



    public static void main(String[] args) {

    }
}
