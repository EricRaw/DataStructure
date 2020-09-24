package recursion;

/**
 * @author EricRaww
 * @create 2020-03-07
 */
public class RecursionTest {
    public static void main(String[] args) {
       /// test(5);
        int res = factorial(3);
        System.out.println(res);
    }
    public static void test(int n){
        if(n>2){
            test(n-1);
        }else {
        System.out.println("n="+ n );
    }}

    public static int factorial(int n){
        if(n ==1){
            return 1;
        }else {
            return factorial(n-1)*n;
        }

    }
}
