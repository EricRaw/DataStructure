package stack;

/**
 * @author EricRaww
 * @create 2020-03-07
 */
public class LinkedStackDemo {
    public static void main(String[] args) {

    }
    static class Node{
        private int no;

        public Node(int no) {
            this.no = no;
        }

        private Node next;

    }
    public  Node head=new Node(0);
    public void push(Node node){
        Node temp=head;
        boolean flag=false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no>node.no){
                break;
            }else if(temp.next.no==node.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            System.out.println("existed"+node.no);
        }
        else {
            node.next=temp.next;
            temp.next=node;
        }
    }
    public int pop(){
        if (head.next ==null){
            return -1;
        }
       Node temp=head;
        while (true){
            if(temp==null){
                break;
            }

        }
        return 0;
    }

}
