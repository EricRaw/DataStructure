package search;

import java.util.Arrays;

/**
 * @author EricRaww
 * @create 2020-03-11
 */
public class FibonacciSearch {
    public static int maxSize=20;
    public static void main(String[] args) {
        int [] arr={1,8,10,89,1000,1234};
    }

    private static int[] fib(){
        int [] f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i = 2; i < maxSize; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    //编写斐波那契查找算法
    public static int fibSearch(int []a,int key){
        int low=0;
        int high=a.length-1;
        int k=0;//表示分割数值的下标
        int mid=0;//for mid value
        int f[]=fib();
        //获取到k
        while (high>f[k]-1){
            k++;
        }
        //因为f[k]值大于a的长度
        //不足会填充0
        int [] temp= Arrays.copyOf(a,f[k]);
        for (int i = high+1; i <temp.length ; i++) {
            temp[i]=a[high];
        }
       return 1;
    }
}
