package linkedlist;

/**
 * @author EricRaww
 * @create 2020-03-04
 */
public class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点
    //构造器
    public HeroNode (int hNo,String hName,String hNickName){
        this.no=hNo;
        this.name=hName;
        this.nickName=hNickName;
    }
    //重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +

                '}';
    }
}
