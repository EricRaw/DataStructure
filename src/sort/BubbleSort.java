package sort;

import java.util.Arrays;

/**
 * @author EricRaww
 * @create 2020-03-08
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] array = {3,6,7,9,10,20};

        System.out.println("before bublle ");
        System.out.println(Arrays.toString(array));
        boolean flag=false;
        for (int i = 0; i <array.length; i++) {
            for (int j = 0; j <array.length; j++) {
                if(array[i]<=array[j]){
                    flag=true;
                    int k=array[i];
                    array[i]=array[j];
                    array[j]=k;
                }
            }
            System.out.println(i);
            if(!flag){
                break;
            }else {
                flag=false;
            }
        }
        System.out.println("after bublle ");
        System.out.println(Arrays.toString(array));

    }
}
