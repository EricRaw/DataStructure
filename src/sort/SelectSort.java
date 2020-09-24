package sort;

/**
 * @author EricRaww
 * @create 2020-03-08
 */
public class SelectSort {
    public static void main(String[] args) {
//        int [] array= {101,34,119,1,-1,1,2,3,4,7,6,5};
        int[]arr=new int[800000];
        for (int i = 0; i <800000 ; i++) {
            arr[i]=(int)(Math.random()*800000);
        }
        System.out.println("排序前");
        System.out.println(System.nanoTime());
        selectMin(arr);
        System.out.println("排序后");
        System.out.println(System.nanoTime());


    }
    public static void selectMin(int [] array){
        //第一轮
        for (int i = 0; i <array.length-1 ; i++) {
            int minIndex=i;
            int min=array[i];
            for (int j = i+1; j < array.length; j++) {
                if(min<array[j]  ){
                    min=array[j];
                    minIndex=j;
                }
            }
            int temp=array[i];
            array[i]=array[minIndex];
            array[minIndex]=temp;

        }



    }
}
