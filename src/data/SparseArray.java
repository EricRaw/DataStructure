package data;

/**
 * @author EricRaww
 * @create 2020-03-03
 */
public class SparseArray {
    public static void main(String[] args) {
        int chessArr1 [] []=new int [11] [11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[4][3]=1;
//        for (int i = 0; i <11 ; i++) {
//            for (int j = 0; j <11; j++) {
//                System.out.print(chessArr1[i][j]+ " ");
//            }
//            System.out.println();
//        }
        System.out.println("原始的二维数组");
        for(int [] row:chessArr1){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //1.遍历原始数组
        int sum=0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if (chessArr1[i][j] != 0)
                    sum++;
            }
        }
        System.out.println("sum "+ sum);
        //2.创建对应的稀疏数组
        int sparseArr [][]=new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //遍历二维数组，将非0的值存放到sparseArr
        int count=0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println();


        System.out.println("得到的稀疏数组为～～～～～");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();
        int chessArr2[][] =new int[sparseArr[0][0]][sparseArr[0][1]];

        //2.在读取稀疏数组后几行的数据（第二行开始），并赋值到原始的二维数据
        for (int i = 1; i <sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        System.out.println("恢复的二维数组");
        for(int [] row:chessArr2){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //写入磁盘
//        File file = new File("/Users/ericraw/Documents/test");
//        System.out.println(file.exists());
//        System.out.println(file.canRead()+"  "+file.canWrite());
//        try {
//            FileWriter fileWriter = new FileWriter("sparsearr.txt");
//            fileWriter.w
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
