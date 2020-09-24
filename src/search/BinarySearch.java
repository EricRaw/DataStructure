package search;

import java.util.ArrayList;

/**
 * @author EricRaww
 * @create 2020-03-11
 */
public class BinarySearch {
    //二分查找，排好序的数组
    public static void main(String[] args) {
        int [] arr={-1,0,1,333,524};
        ArrayList arrayList = binarysearchAll(arr, 0, arr.length - 1, 2);
        System.out.println(arrayList);
    }
//    private static int binarysearch(int [] arr,int left,int right,int findVal){
//        if(left>right){
//            return -1;
//        }
//        int mid=(left+right)/2;
//        int midVal=arr[mid];
//
//        if(findVal>midVal){//向左递归
//            return binarysearch(arr,mid+1,right,findVal);
//        }
//        if(findVal<arr[mid]){//向右递归
//            return binarysearch(arr,left,mid-1,findVal);
//        } else  {
//
//            return mid;
//        }
//
//    }
    private static ArrayList binarysearchAll(int [] arr, int left, int right, int findVal){
        if(left>right){
            return new ArrayList<Integer>();
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];

        if(findVal>midVal){//向左递归
            return binarysearchAll(arr,mid+1,right,findVal);
        }
        if(findVal<arr[mid]){//向右递归
            return binarysearchAll(arr,left,mid-1,findVal);
        } else  {
            //二分查找所有的值
            //1。找到值，不应马上返回
            //2。向mid的索引值的左边扫描，满足则加入ArrayList
            //3.向mid索引值的右边扫描，将所有满足的下标加入集合
            //4，将ArrayList返回
            ArrayList<Integer> resList = new ArrayList<>();

            int temp=mid-1;
            while (true){
                if(temp<0 || arr[temp] !=findVal){
                    break;
                }
                //否则将temp add to list
                resList.add(temp);
                temp-=1;
            }
            resList.add(mid);
             temp=mid+1;
            while (true){
                if(temp>right || arr[temp] != findVal){
                    break;
                }
                resList.add(temp);
                temp+=1;
            }

            return resList;
        }

    }
}
