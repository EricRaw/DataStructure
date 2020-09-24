package data;

import java.util.Scanner;

/**
 * @author EricRaww
 * @create 2020-03-03
 */
public class ArrayQueue {
    public static void main(String[] args) {
        CycleArrayQueue arrayQueue1 = new CycleArrayQueue(3);
        char key=' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while (loop) {
            System.out.println("s show");
            System.out.println("e:exit");
            System.out.println("a ddd");
            System.out.println("g:get");
            System.out.println("h: h");
            key=scanner.next().charAt(0);
            switch(key){
                case 's':
                    arrayQueue1.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入");
                    int i = scanner.nextInt();
                    arrayQueue1.addQueue(i);
                    break;
                case 'g':
                    try{
                        int res = arrayQueue1.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = arrayQueue1.headQueue();
                        System.out.printf("头部的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                    default:break;
            }

        }
        System.out.println(" exit 88");
    }
}

