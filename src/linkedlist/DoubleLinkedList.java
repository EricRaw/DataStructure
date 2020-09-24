package linkedlist;

/**
 * @author EricRaww
 * @create 2020-03-05
 */
public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode heroNode1 = new HeroNode(1, "Eric1", "e");
        HeroNode heroNode2 = new HeroNode(2, "宋江", "宋");
        HeroNode heroNode3 = new HeroNode(3,"无用","智多星");
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.list();
//        doubleLinkedList.delete(heroNode2);
//        System.out.println("*****after delete ****");
//        doubleLinkedList.list();

        doubleLinkedList.update(new HeroNode(1,"AAA","CCC"));
        doubleLinkedList.delete(heroNode3);
        System.out.println("*****after update ****");
        doubleLinkedList.list();
    }

    private static HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //遍历双向链表
    public void list() {
        if (head.next == null) {
            System.out.println("DoubleLinkedList is null");
            return;
        }
        //因为头节点不能动，需要一个辅助变量
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }


    }

    public static void add(HeroNode heroNode) {
        //head不能动，
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，就将temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("DoubleLinkList is null");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.next== null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag=true;
                break;
            }
            temp=temp.next;

        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        } else {
            System.out.println("no one");
        }
    }

    public void delete(HeroNode heroNode) {
        if (head.next == null) {
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {

            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("No one for delete++++++++++");
        }
    }

    static class HeroNode {
        public int no;
        public String name;
        public String nickname;
        public HeroNode next;
        public HeroNode pre;
        //构造器


        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
}
