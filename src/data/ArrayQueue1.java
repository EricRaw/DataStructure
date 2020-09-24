package data;

/**
 * @author EricRaww
 * @create 2020-03-04
 */
public class ArrayQueue1 {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //创建队列的构造器
    public ArrayQueue1(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return maxSize - 1 == rear;
    }

    public boolean isEmpty() {

        return front == rear;
    }

    public void addQueue(int in) {
        if (isFull()) {
            System.out.println("队列已满不能添加");
            return;
        }
        rear++;
        arr[rear] = in;
    }
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列已空，不能取");
        }
        front++;
        return arr[front];
    }
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列已空，不能取");
        }
        for (int i=0;i<arr.length;i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列已空，不能取");
        }

        return arr[front+1];
    }

}


