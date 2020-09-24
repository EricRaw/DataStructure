package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author EricRaww
 * @create 2020-03-10
 */
public class RadixSort {
    public static void main(String[] args) {
//        int [] arr={53,3,542,748,14,214,1,3333,8888888,99999999};
        int [] arr=new int [800000000];
        for (int i = 0; i < 800000000; i++) {
            arr[i]=(int)Math.random()*8000000;
        }
        System.out.println("before"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        radixSort(arr);
        System.out.println("after"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
    }
    private static void radixSort(int [] arr){

        //1.得到数组中最大的数的位数
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max=arr[i];
            }
        }
        int maxLength=(max+"").length();


        //第一轮
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //1。二维数组包含10个一维数组
        //2。为了防止数据溢出，
        //3。空间换时间
        int [][] bucket=new int[10][arr.length];
        //记录每个桶存放多少数据
        //bucketElementCounts,记录的就是bucket【0】的个数
        int [] bucketElementCounts=new int [10];

        for (int m = 0,n=1; m <maxLength ; m++,n*=10) {

            for (int i = 0; i <arr.length ; i++) {
                //取出每个元素的对应位
                int digitOfElement=arr[i]/n%10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
                bucketElementCounts[digitOfElement]++;
            }
            int index=0;
            for (int k = 0; k <bucketElementCounts.length ; k++) {
                //如果桶中有数据
                if(bucketElementCounts[k]!=0){
                    //循环该桶，即第k个一维数组
                    for (int l = 0; l <bucketElementCounts[k] ; l++) {
                        //放入数组中
                        arr[index++]=bucket[k][l];
                        //  index++;
                    }
                }
                //第m轮处理后，需要将
                bucketElementCounts[k]=0;
            }
//            System.out.println("round  "+m+" "+Arrays.toString(arr));
        }
        /*
        //round 1
        for (int i = 0; i <arr.length ; i++) {
            //取出每个元素的个位
            int digitOfElement=arr[i]%10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        int index=0;
        for (int k = 0; k <bucketElementCounts.length ; k++) {
            //如果桶中有数据
            if(bucketElementCounts[k]!=0){
                //循环该桶，即第k个一维数组
                for (int l = 0; l <bucketElementCounts[k] ; l++) {
                    //放入数组中
                    arr[index++]=bucket[k][l];
                   //  index++;
                }
            }
            //第一轮处理后，需要将
            bucketElementCounts[k]=0;
        }
        System.out.println("round 1 "+ Arrays.toString(arr));

        //第二轮

        //round 1
        for (int i = 0; i <arr.length ; i++) {
            //取出每个元素的个位
            int digitOfElement=arr[i]/10%10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        index=0;
        for (int k = 0; k <bucketElementCounts.length ; k++) {
            //如果桶中有数据
            if(bucketElementCounts[k]!=0){
                //循环该桶，即第k个一维数组
                for (int l = 0; l <bucketElementCounts[k] ; l++) {
                    //放入数组中
                    arr[index++]=bucket[k][l];
                    //  index++;
                }
                bucketElementCounts[k]=0;
            }
        }
        System.out.println("round 2 "+ Arrays.toString(arr));

        //第三轮

        //round 1
        for (int i = 0; i <arr.length ; i++) {
            //取出每个元素的个位
            int digitOfElement=arr[i]/10/10%10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        index=0;
        for (int k = 0; k <bucketElementCounts.length ; k++) {
            //如果桶中有数据
            if(bucketElementCounts[k]!=0){
                //循环该桶，即第k个一维数组
                for (int l = 0; l <bucketElementCounts[k] ; l++) {
                    //放入数组中
                    arr[index++]=bucket[k][l];
                    //  index++;
                }
                bucketElementCounts[k]=0;
            }
        }
        System.out.println("round 3 "+ Arrays.toString(arr));
        /*
         */
    }
}
