package huffmancode;

import java.util.*;

/**
 * @author EricRaww
 * @create 2020-03-14
 */
public class Huffmancode {
    public static void main(String[] args) {
        String content="i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);
        List<Node> nodes = getNodes(contentBytes);
        System.out.println(nodes);

        //通过list构建霍夫曼树
        Node huffmantree = createHuffmantree(nodes);
        System.out.println("前序遍历");
       huffmantree.preOrder();

    }
    //生成霍夫曼对应的霍夫曼编码
    

    //前序遍历
    private static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else {
            System.out.println("tree is null");
        }
    }

    /**
     * 
     * @param bytes 接受字符数组
     * @return List
     */
    private static List<Node> getNodes(byte[] bytes){
        //1.创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        //遍历byte，统计每个byte出现的次数-->map[key,value]
        for (byte b : bytes) {
            Integer count=counts.get(b);
            if(count==null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
        //把每个键值对转成一个Node，并加入Nodes集合
        for(Map.Entry<Byte,Integer>entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    private static Node createHuffmantree(List<Node> nodes){
        while (nodes.size()>1){
            //sort
            Collections.sort(nodes);
            //取出第一课二叉树
            Node leftNode=nodes.get(0);
            Node rightNode=nodes.get(1);
            //创建新的二叉树
            //确定根节点
            Node parent=new Node(null,leftNode.weight+rightNode.weight);
            parent.left=leftNode;
            parent.right=rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树加入到nodes
            nodes.add(parent);


        }
        //返回的节点
        return nodes.get(0);
    }

}

//创建Node,数据和权值
class Node implements Comparable<Node>{
    Byte data;//存放数据（字符）本身'a'=97
    int weight;//权值，表示出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}