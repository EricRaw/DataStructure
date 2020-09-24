package linkedlist;

import java.util.Stack;

/**
 * @author EricRaww
 * @create 2020-03-04
 */
public class SingalLinkedlist1 {
    public static void main(String[] args) {
        singalLinkedList linkedlist1 = new singalLinkedList();
        HeroNode heroNode1 = new HeroNode(1, "松江1", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "松江2", "及时雨");
        HeroNode heroNode3 = new HeroNode(3, "松江3", "及时雨");
        HeroNode heroNode4 = new HeroNode(4, "松江4", "及时雨");
        linkedlist1.add(heroNode1);
        linkedlist1.add(heroNode2);
        linkedlist1.add(heroNode3);
        linkedlist1.add(heroNode4);
//        linkedlist1.delete(heroNode2);
//        System.out.println(getLength(linkedlist1.getHead()));

//        linkedlist1.modify(new HeroNode(2, "DD","s雨"));
//        linkedlist1.list();
//        linkedlist1.size(linkedlist1);
//        System.out.println();
//        System.out.println(getIndexNode(linkedlist1.getHead(), 2));
        linkedlist1.list();
//        reverse(linkedlist1.getHead());
        System.out.println("~~~~~~");
        fanzhuan(linkedlist1.getHead());
//        linkedlist1.list();
    }
    public static void fanzhuan(HeroNode head){
        if(head.next == null ) return;
        //创建一个栈
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode cur=head.next;
        while (cur != null){
            heroNodes.push(cur);
            cur=cur.next;

        }
       while (heroNodes.size()>0){
           System.out.println(heroNodes.pop());
       }

    }
    public static void reverse(HeroNode head){
        //Null?
        if(head.next == null || head.next.next ==null ) return;
        //定义一个辅助的指针（变量）
        HeroNode cur=head.next;
        HeroNode next=null;//指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0," "," ");
        while ( cur !=null){
            next=cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }


        head.next=reverseHead.next;
    }

    public static HeroNode getIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int length = getLength(head);
        if( index <=0 || index >length){
            System.out.println("   null ");
            return null;
        }
        HeroNode cur = head.next;
        for (int j = 0; j < length - index; j++) {
            cur = cur.next;
        }
        return cur;
    }

    public static int getLength(HeroNode head) {
        //isEmpty
        if (head.next == null ) {
            return 0;
        }
        HeroNode cur = head.next;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    static class singalLinkedList {
        //初始化头节点,不存放具体的数据
        public HeroNode head = new HeroNode(0, "", "");

        //返回头节点
        public HeroNode getHead() {
            return head;
        }

        //添加节点到单向链表
        //思路，不考虑编号顺序时
        //1。找到当前链表的最后节点
        //2.将最后的这个节点的next指向新的节点
        public void add(HeroNode heroNode) {
            HeroNode temp = head;
            boolean flag = false;
            //遍历链表，找到最后
            while (true) {
                //找到链表的最后
                if (temp.next == null) {
                    break;
                }
                //如果没有找到最后，将temp后移

                if (temp.next.no > heroNode.no) {
                    break;
                } else if (temp.next.no == heroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //flag?
            if (flag) {
                System.out.println("existed" + heroNode.no);
            } else {
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }

        //根据no来修改
        public void modify(HeroNode heroNode) {
            if (head.next == null) {
                return;
            }
            HeroNode temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.no == heroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
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
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no == heroNode.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.next = temp.next.next;
//            System.out.println(temp);
                System.out.println(temp.next);
//            System.out.println(temp.next.next);
            } else {
                System.out.println("one one");
            }
        }

        //显示链表
        public void list() {
            //isEmpty
            if (head.next == null) {
                return;
            }
            HeroNode temp = head;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }

        }

    }
}
