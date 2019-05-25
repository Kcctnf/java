package coms;

import java.util.function.Predicate;

/**
 * Author : dong
 * Time:2019/5/23
 */
public class AVLTree {
    public static class Node {
        int key;
        int value;
        //int factor;//-1,0,1负载因子
        int height = 1;

        Node left = null;
        Node right = null;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root = null;

    public boolean insert(int key, int value) {

        try {
            root = insertInternal(root, key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }


    private int height(Node node) {

        return node == null ? 0 : node.height;

    }

    private int max(int a, int b) {
        return a > b ? a : b;

    }

    private int updateHeight(Node node) {
        return max(height(node.left), height(node.right));
    }


    /*
    插入，保持平衡
     */
    private Node insertInternal(Node node, int key, int value) throws Exception {
        if (node == null) {
            return new Node(key, value);
        }

        if (key == node.key) {
            throw new Exception("key 冲突了");
        } else if (key < node.key) {
            node.left = insertInternal(node.left, key, value);
            if (height(node.left) - height(node.right) >= 2) {
                // 看 node.left 的左右子树谁更高
                if (height(node.left.left) > height(node.left.right)) {
                    node = rightRotate(node);
                } else {
                    node.left = leftRotate(node.left);
                    node = rightRotate(node);
                }
            }
        } else {
            node.right = insertInternal(node.right, key, value);
            if (height(node.right) - height(node.left) >= 2) {
                if (height(node.right.right) > height(node.right.left)) {
                    node = leftRotate(node);
                } else {
                    node.right = rightRotate(node.right);
                    node = leftRotate(node);
                }
            }
        }

        node.height = updateHeight(node);

        return node;
    }


    /*
     * 右旋
     */
    private Node rightRotate(Node node) {
        Node originalLeft = node.left;
        node.left = originalLeft.left;
        originalLeft.right = node;


        node.height = updateHeight(node);
        originalLeft.height = updateHeight(node);


        return originalLeft;
    }

    /*
    左旋
     */

    private Node leftRotate(Node node) {
        Node originalRight = node.right;
        node.right = originalRight.left;
        originalRight.left = node;


        node.height = updateHeight(node);
        originalRight.height = updateHeight(node);

        return originalRight;
    }




    /**
     * 1.验证每个节点中的高度 == 真实的高度
     * 2.每个节点的左右子树高度差不能超过1
     * 3.中序是有序的
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return max(left, right) + 1;
    }

    private void inorder(Node node, Predicate<Node> tester) {
        if (node != null) {
            inorder(node.left, tester);
            if (!tester.test(node)) {
                throw new RuntimeException("key: " + node.key);
            }
            inorder(node.right, tester);
        }
    }

    public void verifyHeights() {
        inorder(root, (Node node) -> {
            int actualHeight = getHeight(node);
            return actualHeight == node.height;
        });
    }

    public void verifyBalance() {
        inorder(root, (Node node) -> {
            int differ = height(node.left) - height(node.right);
            return differ >= -1 && differ <= 1;
        });
    }

    public void verifyOrdering() {
        class Cache {
            public int lastKey = Integer.MIN_VALUE;
        }

        final Cache cache = new Cache();

        inorder(root, (Node node) -> {
            // 要保证 node.key 永远是大于等于上一个给过来的 node.key
            boolean r = node.key >= cache.lastKey;
            cache.lastKey = node.key;
            return r;
        });
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        for (int i = 1000; i > 0; i--) {
            tree.insert(i, i);
        }

        tree.verifyHeights();
        tree.verifyBalance();
        tree.verifyOrdering();
    }

}