package coms;

import java.util.Arrays;

/**
 * Autor : dong
 * Time:2019/4/18
 */
/*
带空节点的前序可以确定一个二叉树才能知道
根据前序遍历，容易找到根的值，下标为0的位置
创建树的的过程中,才能知道一棵树用了几个前序遍历
 */
//返回根节点以及前序遍历的次数
class CreateTreeReturnValues{

    //创建好的二叉树的根节点
    public Node node;

    //使用个数
    public int used;

    CreateTreeReturnValues(Node node,int used){
        this.node = node;
        this.used = used;
    }
}

class Node {
    char value;
    Node left;
    Node right;

    Node(char v) {
        this.value = v;
        //this.left = left;
        //this.right = right;
    }
}
public class BinaryTreeTwo {

    CreateTreeReturnValues creatTree(char[] preOrder){
        //判断
        if(preOrder.length == 0){
            return new CreateTreeReturnValues(null,0);
        }


        //preOrder[0]就是根的值，拿根的值去创建根节点
        char rootValue = preOrder[0];

        if(rootValue == '#'){

            return new CreateTreeReturnValues(
                    null,1
            );
        }

        Node root = new Node(rootValue);

        //利用preOrder找到左子树前序遍历数组，去掉第一个值
        char[] liftPreOrder = new char[preOrder.length - 1];
        liftPreOrder = Arrays.copyOfRange(preOrder,1,preOrder.length);

        //递归调用，返回两个值，创建左子树，以及左子树使用的个数
        CreateTreeReturnValues liftReturn =  creatTree(liftPreOrder);
        //返回的liftReturn.root  为根节点 liftReturn.used为左子树使用次数

        //利用preOrder找到右子树前序遍历数组，去掉第一个值，去掉左边用的值
        char[] rightPreOrder = new char[preOrder.length - 1 - liftReturn.used];
        rightPreOrder = Arrays.copyOfRange(preOrder,1 + liftReturn.used,preOrder.length);

        //递归调用，返回两个值，创建右子树，以及右子树使用的个数
        CreateTreeReturnValues rightReturn = creatTree(rightPreOrder);

        //将左树和右数树关联起来
        root.left = liftReturn.node;
        root.right = rightReturn.node;

        return new CreateTreeReturnValues(root, 1 + liftReturn.used + rightReturn.used);


    }
    /*
       二叉树中查找
    */

    private static Node find1(Node root,char v){
        if(root == null){
            return null;
        }
        if(root.value == v){
            return root;
        }
        Node left = find1(root.left,v);
        if(left != null){
            return left;
        }
        return find1(root.right,v);
    }

     /*
       数组中查找
     */

    private static int find(char[] array,char v){
        for(int i = 0;i < array.length;i++){
            if(array[i] == v){
                return i;
            }
        }
        return -1;
    }

    /*
    根据前序和中序创建一个二叉树
     */
    private static Node buildTree1(char[] preorder,char[] inorder){

        if(preorder.length == 0){
            return null;
        }
        //根据前序找到根的值，并且创建根节点
        char rootValue = preorder[0];
        Node root = new Node(rootValue);


        //在中序中找到根值所在的下标

        int leftSize = find(inorder,rootValue);

        /*
        切出左子树的前序和中序
         */

        char[] leftPreorder = Arrays.copyOfRange(preorder,1,leftSize + 1);
        char[] leftInorder  = Arrays.copyOfRange(inorder,0,leftSize);

        //递归
        root.left = buildTree1(leftPreorder,leftInorder);

        /*
        切出右子树的前序和中序
         */
        char[] rightPreorder = Arrays.copyOfRange(preorder,1 + leftSize,preorder.length);
        char[] rightInorder = Arrays.copyOfRange(inorder,leftSize +1,preorder.length);

        //递归
        root.right = buildTree1(rightPreorder,rightInorder);

        return root;
    }

    /*
    根据中序和后序创建一个二叉树
    */
    private static Node buildTree2(char[] inorder,char[] postorder){
        if(inorder.length == 0){
            return null;
        }
        char rootValue = postorder[postorder.length - 1];

        Node root = new Node(rootValue);
        int leftSize = find(inorder,rootValue);

        char[] leftInorder = Arrays.copyOfRange(inorder,0,leftSize);
        char[] leftPostorder  = Arrays.copyOfRange(postorder,0,leftSize);
        root.left = buildTree2(leftInorder,leftPostorder);

        char[] rightInorder = Arrays.copyOfRange(inorder,leftSize + 1,inorder.length);
        char[] rightPostorder = Arrays.copyOfRange(postorder,leftSize,postorder.length - 1);
        root.right = buildTree2(rightInorder,rightPostorder);
        return root;
    }

    public static void main(String[] args) {

        char[] preorder = new char[]{'A','B','C','D','E'};

        char[] inorder = new char[]{'C','D','B','A','E'};

        char[] postorder = new char[]{'D','C','B','A','E'};


        Node root = buildTree1(preorder,inorder);
        find1(root,'E');


        root = buildTree2(inorder,postorder);
        find1(root,'E');
    }
}
