package sort;

import java.util.Arrays;

/**
 * @author EricRaww
 * @create 2020-03-09
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] arr={-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);

    }
    private static void quickSort(int [] arr,
                                  int left,
                                  int right){
        int l=left;
        int r=right;
        //pivot
        int pivot=arr[(right+left)/2];
        int temp=0;
        //while循环的目的是让pivot值放到左边
        //比pivot值大放到右边
        while (l<r){

            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l]<pivot){
                l+=1;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r]>pivot){
                r-=1;
            }
            //如果l>=r说明pivot的左右两边的值
            //已经左边全部是小于pivot的值
            //右边占全部大于
            if(l>=r){
                break;
            }
            //交换
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            //如果交换完后，发现arr【l】==pivot
            if(arr[l]==pivot){
                r-=1;
            }
            //如果交换完后，发现arr[r]==pivot
            if(arr[r]==pivot){
                l+=1;
            }
        }
        System.out.println("递归之前"+Arrays.toString(arr));
        //如果l==r,必须l++,r--,否则出现栈溢出
        if(l==r){
            l+=1;
            r-=1;
        }
        //向左递归
        if(left<r){
            quickSort(arr,left,r);
        }
        System.out.println("左递归之后"+Arrays.toString(arr));
        //向右递归
        if(right>l){
           quickSort(arr,l,right);
        }
        System.out.println("右递归之后"+Arrays.toString(arr));
    }

}
