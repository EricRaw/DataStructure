package huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author EricRaww
 * @create 2020-03-14
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int [] arr={13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        //test
        preOrder(root);

    }
    public static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else {
            System.out.println("tree is empty");
        }

    }
    //create huffman tree
    public static Node createHuffmanTree(int [] arr){
        //1.遍历arr数组
        //2。将arr的每个元素构建成一个Node
        //3。将Node放入到ArrayList中
        List<Node> nodes=new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size()>1) {
            //先排序--小--》大
            Collections.sort(nodes);
            System.out.println("nodes+ " + nodes);
            //取出权值最小的两颗二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //3.构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //4.从arrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5.将parent加入到nodes
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

//创建节点类
//让Node对象支持排序Collection集合排序
//让Node实现Comparable接口
class Node implements Comparable<Node>{
    int value;//节点权值
    char c;
    Node left;//指向左子节点
    Node right; //指向右子节点

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    public Node(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大排序
        return this.value-o.value;
    }
}
