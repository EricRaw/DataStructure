package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author EricRaww
 * @create 2020-03-07
 */
public class Poland {
    public static void main(String[] args) {
        //polan
        //(3+4)*5-6
        String Expr="3 4 + 5 * 6 -";
        //1.expr-->放入ArrayList中
        //将ArrayList传给方法，配合栈完成计算
        List<String> rpnList=getListString(Expr);
        System.out.println(rpnList);
        int res=calculate(rpnList);
        System.out.println(res);
    }
    //expr放入Arraylist
    public static List<String> getListString(String expr){
        String[] split = expr.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;


    }
    //cacula
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            if(s.matches("\\d+")){
                stack.push(s);
            }else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res=0;
                if(s.equals("+")){
                    res=num1+num2;
                }else if(s.equals("-")){
                    res=num1-num2;
                }else if(s.equals("*")){
                    res=num1*num2;
                }else if(s.equals("/")){
                    res=num1/num2;
                }else {
                    throw new RuntimeException("oper is wrong");
                }
                stack.push(res+"");
            }

        }
       return Integer.parseInt(stack.pop());
    }
}
