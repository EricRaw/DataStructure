package stack;

/**
 * @author EricRaww
 * @create 2020-03-06
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(4);
        arrayStack.push(3);
        arrayStack.push(2);
        arrayStack.push(1);
        arrayStack.push(0);
        arrayStack.push(-1);
        arrayStack.pop();
        arrayStack.list();

    }
    static class  ArrayStack{
        private int maxSize;
        private int top=-1;
        private int [] stack;

    public ArrayStack(int max) {
        this.maxSize = max;
        stack=new int[this.maxSize];
    }
    public boolean isFull(){
        return maxSize-1==top;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(int i){
        if(isFull()){
            return;
        }
        top++;
        stack[top]=i;
    }
    public int pop(){
        if (isEmpty()){
           throw new RuntimeException(" stack is empty");
        }
        int value=stack[top];
        top--;
        return value;
    }
    public void list(){
        if(isEmpty()){
            System.out.println("stack is null");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}

}
