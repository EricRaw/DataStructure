package search;

/**
 * @author EricRaww
 * @create 2020-03-11
 */
public class SeqSearch {
    public static void main(String[] args) {
        int [] arr={1,44,22,3,-3,77,888,0,56767};
        int res=seqsearch(arr,0);
        System.out.println(res);
    }
    private static int seqsearch(int [] arr,int value){
        int res=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==value){
                res=1;
                return res;
            }else {
               res=0;
            }
        }
       return res;
    }
}
