package data;

/**
 * @author EricRaww
 * @create 2020-03-04
 */
public class CycleArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //创建队列的构造器
    public CycleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int in) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = in;
        //必须考虑%
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为null");
        }
        int i = arr[front];
        //%
        front = (front + 1) % maxSize;
        return i;
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为null");
        }
        //思路：1。从Front开始遍历
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列的有效数据
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为null");
        }
        return arr[front];
    }

}
