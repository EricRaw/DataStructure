package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author EricRaww
 * @create 2020-03-09
 */
public class ShellSort {
    public static void main(String[] args) {
//        int [] arr1={8,9,1,7,2,3,5,4,6,0,-1,2,3,2,1,888,22,23,4,888888,4,3333,4444,66655,33343434,724726};
        int [] arr=new int[80000];
        for (int i = 0; i <80000; i++) {
            arr[i]=(int)(Math.random()*80000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);

        System.out.println("before shell sort "+format);

        shellSort2(arr);
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat1.format(date1);


        System.out.println("after shell sort "+ format1);
        //System.out.println(Arrays.toString(arr));

    }
    //逐步推导
    //交换式
    private static void shellSort(int [] arr){
        int temp;
//        int k=0;
        for (int gap = arr.length/2; gap >0 ; gap/=2) {

            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共5组，每组2个元素），步长5
                for (int j = i-gap; j >=0 ; j-=gap) {
                    //如果当前元素大于步长后的那个元素，交换
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
//            k++;
//            System.out.println("Shell sort round "+k);
//            System.out.println(Arrays.toString(arr));
        }
        /*
        //第一轮
        //将10个数据分成10/2组
        int temp=0;
        for (int i = 5; i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素），步长5
            for (int j = i-5; j >=0 ; j-=5) {
                //如果当前元素大于步长后的那个元素，交换
                if(arr[j]>arr[j+5]){
                   temp=arr[j];
                   arr[j]=arr[j+5];
                   arr[j+5]=temp;
                }
            }
        }
        System.out.println("Shell sort round1");
        System.out.println(Arrays.toString(arr));


        //第二轮
        //将10个数据分成10/2/2组

        for (int i = 2; i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素），步长5
            for (int j = i-2; j >=0 ; j-=2) {
                //如果当前元素大于步长后的那个元素，交换
                if(arr[j]>arr[j+2]){
                    temp=arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                }
            }
        }
        System.out.println("Shell sort round2");
        System.out.println(Arrays.toString(arr));

        //第三轮
        //将10个数据分成10/2/2/2组

        for (int i = 1; i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素），步长5
            for (int j = i-1; j >=0 ; j-=1) {
                //如果当前元素大于步长后的那个元素，交换
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("Shell sort round 3");
        System.out.println(Arrays.toString(arr));

    */
    }
    //对交换式的希尔排序进行优化-》位移法
    private static void shellSort2(int [] arr){
        //增量gap，并逐步的缩小增量
        for (int gap = arr.length/2; gap>0 ; gap /=2) {
            //从第gap个元素
            for (int i = gap; i <arr.length; i++) {
                //插入排序
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j]-gap){
                    while (j-gap >=0
                    &&temp<arr[j-gap]
                    ){
                        //移动，当前的往后移动
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    //当退出while后，就给temp找到了插入的位置a
                    arr[j]=temp;
                }

            }
        }

    }
}
