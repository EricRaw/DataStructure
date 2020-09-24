package hashTable;

import java.util.Scanner;

/**
 * @author EricRaww
 * @create 2020-03-12
 */
public class HashTableDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTable hashTable = new HashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add");
            System.out.println("list");
            System.out.println("exit");
            System.out.println("find");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("input id");
                    int id = scanner.nextInt();
                    System.out.println("name");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("please input search ID");
                     id = scanner.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "delete":
                    System.out.println("please input delete id");
                    id=scanner.nextInt();
                    hashTable.deleteEmpById(id);
                case "exit":
                    scanner.close();
                    System.exit(0);

                default:
                    break;
            }
        }

    }
}

//hashTable,管理多条链表
class HashTable {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    //构造器
    public HashTable(int size) {
        this.size=size;
        empLinkedListArray = new EmpLinkedList[size];
        //？分别初始化每个链表
        for (int i = 0; i <size ; i++) {
            empLinkedListArray[i]=new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id，得到该员工应当加入到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //add
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //编写一个散列函数--》取模法
    public int hashFun(int id) {
        return id % size;
    }

    public void list() {
        //遍历
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }
    public void findEmpById(int id){
        //使用散列函数确定到哪条链表查找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findById(id);
        if(emp !=null){
            System.out.printf("在第%d条链表中找到雇员id=%d\n",(empLinkedListNo),id);
        }else {
            System.out.println("id is not existed");
        }
    }
    public void deleteEmpById(int id){
        int empLinkedListNo = hashFun(id);
        empLinkedListArray[empLinkedListNo].deleteById(id);
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList,表示链表
class EmpLinkedList {
    //头指针，执行第一个Emp，head指向第一个雇员
    private Emp head;

    //添加雇员到链表
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        //退出时直接将emp加入链表
        curEmp.next = emp;
    }

    public void list( int no) {
        if (head == null) {
            System.out.println("Linked "+no+" list is null");
            return;
        }
        System.out.println("Linked "+no+"  list  are");
        Emp curEmp = head;
        while (true) {
            System.out.printf("=>id=%d name=%s\t",
                    curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
    public Emp findById(int id){
        if(head==null){
            System.out.println("linkedlist is null");
            return null;
        }
        Emp curEmp=head;
        while (true){
            if(curEmp.id==id){
                break;
            }
            if(curEmp.next==null){
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;
    }
    public void deleteById(int id){
        if(head==null){
            System.out.println("LinkedList is null");
        }
        Emp curEmp=head;
        while (true){
            if(curEmp.id==id && curEmp.next.next!=null){
                curEmp.next=curEmp.next.next;
                break;
            }
            if(curEmp.next==null){
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;
        }
    }

}
