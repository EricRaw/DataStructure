package tree;

/**
 * @author EricRaww
 * @create 2020-03-13
 */
public class arrBinaryTreeDemo {
    public static void main(String[] args) {
        int [] arr= {1,2,3,4,5,6,7};
        //创建一个
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);//1,2,4,5,3,6,7
    }
}

class ArrBinaryTree{
    private int [] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //编写一个方法。完成顺序存储二叉树的前序遍历
    public void preOrder(int index){
        //  如果数组为null
        if(arr==null ||arr.length==0){
            System.out.println("array is null");
        }
        System.out.println(arr[index]);
        //向左递归遍历
        if((index*2+1)<arr.length){
            preOrder(2*index+1);
        }
        //向右递归遍历
        if((index*2+2)<arr.length){
            preOrder(2*index+2);
        }
    }
}
