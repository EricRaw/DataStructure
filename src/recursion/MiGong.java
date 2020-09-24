package recursion;

/**
 * @author EricRaww
 * @create 2020-03-08
 */
public class MiGong {
    public static void main(String[] args) {
        //二维数组
        int [][]map=new int [8][7];
        for (int i = 0; i <7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
//        map[1][2]=1;
//        map[2][2]=1;
        System.out.println("this is map");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");

            }
            System.out.println();
        }
//        boolean b = setWay(map, 1, 1);
//        System.out.println("after set way");
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(map[i][j]+" ");
//
//            }
//            System.out.println();
//        }
        setBetterWay(map,1,1);
        System.out.println("after set BETTER way");
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    //使用递归回溯

    /**
     *约定：0没有走过。2表示可以走。3表示已经走过
     * 走迷宫时，需要确定策略：下--》右--》上--》左
     * @param map
     * @param i
     * @param j
     * @return found true
     */
    public static boolean setWay(int [][] map, int i,int j){
        if(map[6][5] ==2){
            return true;
        }else {
            //当前点尚未走
            if(map[i][j]==0){
                map[i][j]=2;//假定可以走
                if (setWay(map, i + 1, j)) {
                    return true;
                }else if(setWay(map, i, j+1)){
                    return true;
                } else if (setWay(map, i - 1, j)) {
                   return true;
                }else if(setWay(map, i, j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                //如果map[i][j]！=0，可能是1，2，3
                return false;
            }
        }
    }

    /**
     *约定：0没有走过。2表示可以走。3表示已经走过
     * 走迷宫时，需要确定策略：上--》右--》下--》左
     * @param map
     * @param i
     * @param j
     * @return found true
     */
    public static boolean setBetterWay(int [][] map, int i,int j){
        if(map[6][5] ==2){
            return true;
        }else {
            //当前点尚未走
            if(map[i][j]==0){
                map[i][j]=2;//假定可以走
                if (setBetterWay(map, i - 1, j)) {
                    return true;
                }else if(setBetterWay(map, i, j+1)){
                    return true;
                } else if (setBetterWay(map, i + 1, j)) {
                    return true;
                }else if(setBetterWay(map, i, j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                //如果map[i][j]！=0，可能是1，2，3
                return false;
            }
        }
    }

}
