package coms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : dong
 * Time:2019/4/20
 */

class Rv{
    LNode node;
    int wsed;

    public Rv(LNode node, int wsed) {
        this.node = node;
        this.wsed = wsed;
    }
}
class LNode{
    char value;
    LNode left;
    LNode right;
    LNode(char v){
        this.value = v;
    }
}
public class BinaryTwoTree {
    Rv createTree(char[] preOrder){
        LNode root = new LNode(preOrder[0]);

        char[] leftpreOrder = new char[preOrder.length - 1];
        leftpreOrder = Arrays.copyOfRange(preOrder,1,preOrder.length);
        Rv leftReturn = createTree(leftpreOrder);//递归调用

        char[] rightpreOrder = new char[preOrder.length - leftReturn.wsed - 1];
        rightpreOrder = Arrays.copyOfRange(preOrder,leftReturn.wsed +1,preOrder.length);
        Rv rightReturn = createTree(rightpreOrder);

        root = leftReturn.node;
        root = rightReturn.node;

        return new Rv(root,1 + leftReturn.wsed +rightReturn.wsed);
    }


    /*
    你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
    空节点则用一对空括号 "()" 表示。
    而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

    输出: "1(2()(4))(3)"
    */
    private  static void preOrderTree2Str(LNode root,StringBuilder sb){
        if(root != null){
            sb.append('(');
            sb.append(root.value);
            if(root.left == null || root.right != null){
                sb.append("()");
            } else{
                preOrderTree2Str(root.left,sb);
            }
            preOrderTree2Str(root.right,sb);
            sb.append(')');
        }
    }
    private static String tree2str(LNode root){
        StringBuilder sb = new StringBuilder();
        preOrderTree2Str(root,sb);

        sb.delete(0,1);
        sb.delete(sb.length() - 1,sb.length());
        return sb.toString();
    }


    //判断是否找到为t的节点
    private static boolean find(Node root,Node t){
        if(root == null){
            return false;
        }
        if(root == t){
            return true;
        }
        if(find(root.left,t)){
            return true;
        }
        return find(root.right,t);
    }


    private static Node lowestCommonAncestor(Node root,Node p,Node q){
        if(root == p || root == q){
            return root;
        }
        boolean pInLeft = find(root.left,q);
        boolean qInLeft = find(root.left,q);
        if (pInLeft && qInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (!pInLeft && !qInLeft) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    /*
    层序遍历
    */
    private static void leverOrderTraversal(Node root){
        if(root == null){
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        //启动
        queue.addLast(root);
        //拉下线整个过程

        while(!queue.isEmpty()){
            Node front = queue.pollFirst();
            System.out.println(front.value);

            //拉下线  有要求  空的不要
            if(front.left != null){
                queue.addLast(front.left);
            }
            if(front.right != null){
                queue.addLast(front.right);
            }
        }
    }

    private static List<List<Character>> levelOrder2(Node root){
        List<List<Character>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        class NodeLevel{
            Node node;
            int level;

            public NodeLevel(Node node,int level){
                this.node = node;
                this.level = level;
            }

        }
        LinkedList<NodeLevel> queue = new LinkedList<>();
        queue.addLast(new NodeLevel(root,0));
        while(!queue.isEmpty()){
            NodeLevel front = queue.pollFirst();
            Node node = front.node;
            int level = front.level;
            //处理返回值
            if(list.size() == level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(node.value);

            if(node.left != null){
                queue.addLast(new NodeLevel(node.left,level + 1));
            }
            if(node.right != null){
                queue.addLast(new NodeLevel(node.right,level + 1));
            }
        }
        return list;
    }
}


