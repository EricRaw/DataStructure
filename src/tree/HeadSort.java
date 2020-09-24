package tree;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author EricRaww
 * @create 2020-03-13
 */
public class HeadSort {
    public static void main(String[] args) {
        int arr[]={4,6,8,5,9};

        int arr1[]=new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            arr1[i]=(int)(Math.random()*800000);
        }
        System.out.println("before "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
        heapSort(arr1);
        System.out.println("after "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));

    }
    //编写一个堆排序的方法
    public static void heapSort(int arr[]){
        int temp=0;
       // System.out.println("堆排序！！");
        //分布完成
//        adjustHead(arr,1,arr.length);
//        System.out.println("第一次"+ Arrays.toString(arr));
//        //49856
//        adjustHead(arr,0,arr.length);
//        System.out.println("second"+Arrays.toString(arr));
//        //96854
        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjustHead(arr,i,arr.length);
        }
        for (int j = arr.length-1; j >0 ; j--) {
            //交换
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHead(arr,0,j);
        }
        //System.out.println(Arrays.toString(arr));

    }

    /**
     * {4,6,8,5,9}==》
     * i=1==>{4,9,8,5,6}==>
     * i=0==>{9,6,8,5,4}
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 元素个数，逐渐减少
     */
    public static void adjustHead(
            int arr[],
            int i,
            int length
    ){
        int temp=arr[i];
        //adjust
        //1.k=i*2+1 k是i节点的左子节点
        for (int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length && arr[k]<arr[k+1]){
                //左子节点小于右子节点的值
                k++;
            }
            if(arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        //当for 循环结束后，以i为父节点的最大值，放到了最顶
        arr[i]=temp;
    }
}
