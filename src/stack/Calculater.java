package stack;

/**
 * @author EricRaww
 * @create 2020-03-07
 */
public class Calculater {
    public static void main(String[] args) {
        String expression = "10*3+1-2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum ="";
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            //judge
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        //大于
                        operStack.push(ch);

                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                //numStack.push(ch - 48);
                //多位数。如何处理
                //处理数，index再往后扫描
                 //定义一个字符串变量，链接
                keepNum+=ch;
                if(index ==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                    //如果后一位是运算符
                    numStack.push(Integer.parseInt(keepNum));
                    //clear keepNum
                    keepNum="";}
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        while (true){
            if (operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("表达式%s=%d",expression,numStack.pop());

    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //return stack top
    public int peek() {
        return stack[top];
    }

    public boolean isFull() {
        return maxSize - 1 == top;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int i) {
        if (isFull()) {
            return;
        }
        top++;
        stack[top] = i;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //返回运算符优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //
    public boolean isOper(char val) {
        return val == '+' || val == '-'
                || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }

}
