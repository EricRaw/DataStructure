package linkedlist;

/**
 * @author EricRaww
 * @create 2020-03-06
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        // out of cycle
        circleSingleLinkedList.countBoy(1,2,5);

    }
}

class CircleSingleLinkedList {
    //创建一个first节点
    private Boy first = null;

    //添加小孩节点，构建成环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums are wrong");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy() {
        if (first == null) {
            System.out.println("list is null");
        }
        //
        Boy curBoy = first;
        while (true) {
            System.out.println("Boy no:" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();

        }
    }
    public void countBoy(int startNo,int countNum,
                         int nums){
        if(first ==null || startNo<1 ||
        startNo>nums){
            System.out.println("nums is not right");
        }
        //创建辅助指针
        Boy helper=first;
        while (true){
            if(helper.getNext()==first){
                break;
            }
            helper= helper.getNext();
        }
        for (int i = 0; i < startNo-1; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        while (true){
            if(helper ==first){
                break;
            }
            //让first。helper move
            for (int i = 0; i <countNum-1; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("boy%dout\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("the last one%d \n",first.getNo());
    }
    
}

//boy 类，表示节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }


}

