package sort;

import java.util.Arrays;

/**
 * @author EricRaww
 * @create 2020-03-10
 */
public class MergeSort {
    public static void main(String[] args) {
        //归并算法
        int [] arr={8,4,5,7,1,3,6,2};
        int [] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));

    }
    //分+合
    private static void mergeSort(
            int [] arr, int left,int right,
            int [] temp
    ){
        if(left<right){
            //中间索引
            int mid=(left+right)/2;
            //向左递归进行分解
            mergeSort(arr,left,mid,temp);
            //向右递归进行分解
            mergeSort(arr,mid+1,right,temp);

            merge(arr,left,mid,right,temp);
        }

    }



    //合并的方法

    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 中转数组
     */
    private static void merge(int [] arr,int left,int mid,int right,
                            int [] temp){
        int i=left; //左边初始索引
        int j=mid+1;//右边初始索引
        int t=0;    //temp数组的当前索引

        //1。把左右两边的数据填充到temp数组
        while (i<=mid && j<=right){
            //如果左边的有序序列的当前元素，小于等于
            //右边有序序列的当前元素
            if(arr[i]<arr[j]){
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }else {
                temp[t]=arr[j];
                t+=1;
                j+=1;
            }
        }

        //2。剩余数据的一边数据依次全部填充个
        while (i<=mid){//左边的有序序列还有剩余元素
            temp[t]=arr[i];
            t+=1;
            i+=1;

        }
        while (j<=right){
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }
        //3。将temp数据元素拷贝到arr
        //并不是每次都拷贝
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }

    }
}
