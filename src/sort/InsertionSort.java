package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author EricRaww
 * @create 2020-03-09
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr1 = {101, 34, 119, 1};
        int[] arr2=new int[80000];
        for (int i = 0; i <80000; i++) {
            arr2[i]=(int)(Math.random()*80000);
        }
        System.out.println("排序前");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("before Insertion  "+format);

        insertSort(arr2);
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat1.format(date1);
        System.out.println("after insert  "+format1);
//        System.out.println(Arrays.toString(arr2));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            //给insertVal找到插入的位置
            //保证数组不越界
            //将arr[insertIndex]后移
            while (
                    insertIndex >= 0 &&
                            insertVal < arr[insertIndex]
            ) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环是，说明插入的位置找到，insertIndex+1
            if(insertIndex+1!=i){

                arr[insertIndex + 1] = insertVal;
            }
//            System.out.println("第 " + i + " 轮插入后");

        }
//        System.out.println(Arrays.toString(arr));
    /*
    //{101,34,119,1}=>{34,101,119,1}
        //定义待插入的数
        int insertVal=arr[1];
        int insertIndex=1-1;

        //给insertVal找到插入的位置
        //保证数组不越界
        //将arr[insertIndex]后移
        while (
                insertIndex>=0 &&
                insertVal<arr[insertIndex]
        ){
          arr[insertIndex+1]=arr[insertIndex];
          insertIndex--;
        }
        //当退出while循环是，说明插入的位置找到，insertIndex+1
        arr[insertIndex+1]=insertVal;
        System.out.println("第一轮插入后");
        System.out.println(Arrays.toString(arr));

        //{34,101,119,1}=>{34,101,119,1}
        //定义待插入的数
         insertVal=arr[2];
         insertIndex=2-1;

        //给insertVal找到插入的位置
        //保证数组不越界
        //将arr[insertIndex]后移
        while (
                insertIndex>=0 &&
                        insertVal<arr[insertIndex]
        ){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        //当退出while循环是，说明插入的位置找到，insertIndex+1
        arr[insertIndex+1]=insertVal;
        System.out.println("第二轮插入后");
        System.out.println(Arrays.toString(arr));


        //{34,101,119,1}=>{1，34,101,119}
        //定义待插入的数
        insertVal=arr[3];
        insertIndex=3-1;

        //给insertVal找到插入的位置
        //保证数组不越界
        //将arr[insertIndex]后移
        while (
                insertIndex>=0 &&
                        insertVal<arr[insertIndex]
        ){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        //当退出while循环是，说明插入的位置找到，insertIndex+1
        arr[insertIndex+1]=insertVal;
        System.out.println("第三轮插入后");
        System.out.println(Arrays.toString(arr));
        */
    }
}
