package search;

/**
 * @author EricRaww
 * @create 2020-03-11
 */
public class InsertValueSort {
    public static void main(String[] args) {
        int [] arr=new int [100];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=i;
        }
        System.out.println(inserValuesearch(arr, 0, arr.length-1, 1));
    }
    //要求数组是有序的
        private static int inserValuesearch(int [] arr,int left,int right,int findVal) {
        int i=0;
            System.out.println(i++);

        if(left>right || findVal<arr[0]
        || findVal>arr[arr.length-1]
        ){
            return -1;
        }
        int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[mid];
        if(findVal>midVal){//向右递归查找
            return inserValuesearch(arr,mid+1,right,findVal);
        }
        if(findVal<midVal){//向左查找
            return inserValuesearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }

    }
}
