package recursion;

/**
 * @author EricRaww
 * @create 2020-03-08
 */
public class Queue {
    int max=8;
    //array result
    int [] array=new int [max];
    static int count =0;
    static int judge=0;
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.check(0);
        System.out.println(judge);
    }
    //编写一个方法，放置第n个
    private void check(int n){
        if(n==max){
            print();
            return;
        }
        //依次放入，
        for (int i = 0; i <max; i++) {
            array[n]=i;
            if(judge(n)){

                check(n+1);
            }
        }

    }




    //查看第n个queue，检测和之前的皇后是否冲突

    /**
     * 
     * @param n 第n个queue
     * @return
     */
    private boolean judge(int n){
        judge++;
        for (int i = 0; i <n; i++) {

            if(array[i]==array[n]
            || Math.abs(n-i)==
                Math.abs(array[n]-array[i])){

                return false;
            }
        }
       return true;
    }
    
    private void print(){
        count++;
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }
}
