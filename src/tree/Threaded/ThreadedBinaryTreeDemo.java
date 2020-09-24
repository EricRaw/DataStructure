package tree.Threaded;

/**
 * @author EricRaww
 * @create 2020-03-13
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        binaryTree binaryTree = new binaryTree();
        binaryTree.setRoot(node1);
        binaryTree.threadedNodes();
        binaryTree.thInfixOrder();


    }
}

class binaryTree {
    private HeroNode root;
    //指向当前节点的前驱节点
    private HeroNode pre=null;


    public void setRoot(HeroNode root) {
        this.root = root;
    }
    public void threadedNodes(){
        this.threadedNodes(root);
    }
    public void thInfixOrder(){
        //定义一个临时变量
        HeroNode node= root;
        while ((node !=null)){
            //leftType==1,该节点按线索化处理后的有效节点
            while (node.getLeftType()==0 ){
                node=node.getLeft();
            }
            System.out.println(node);
            //
            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }
            //替换遍历的节点
            node=node.getRight();
        }

        //递归左子树

        //输出父节点
        //递归右子树
    }

    //中序线索化
    public void threadedNodes(HeroNode heroNode){
        if(heroNode==null){
            return;
        }
        //1.一先线索化左子树
        threadedNodes(heroNode.getLeft());
        //2.线索化当前节点
        if(heroNode.getLeft()==null){
            //让当前节点的左指针指向前驱节点
            heroNode.setLeft(pre);
            heroNode.setLeftType(1);
        }
        //处理后继节点
        if(pre !=null && pre.getRight()==null){
            pre.setRight(heroNode);
            pre.setRightType(1);
        }
        //!!!!每处理完后，让当前节点是下一个节点的前驱节点
        pre=heroNode;
        //3.线索化右子树
        threadedNodes(heroNode.getRight());

    }


    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void deleteByNo(int no) {
        if (this.root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.deleteByNo(no);
            }
        } else {
            System.out.println("tree is null");
        }
    }

    public HeroNode findperOrder(int id) {
        if (this.root != null) {
            return this.root.findperOrder(id);
        } else {
            return null;
        }
    }

    public HeroNode findInfixOrder(int no) {
        if (this.root != null) {
            return this.root.findInfixOrder(no);
        } else {
            return null;
        }
    }

    public HeroNode findPostOrder(int no) {
        if (this.root != null) {
            return this.root.findPostOrder(no);
        } else {
            return null;
        }
    }


    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    //left==0,指向左子树，1表示指向前驱节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        //先输出父节点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //前序查找
    public HeroNode findperOrder(int no) {
        //当前节点是不是
        if (this.no == no) {
            return this;
        }
        //1.则判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //2。如果左递归前序查找，找到节点，则返回
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.findperOrder(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.findperOrder(no);
        }
        return heroNode;
    }

    //删除子节点
    public void deleteByNo(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.deleteByNo(no);
        }
        if (this.right != null) {
            this.right.deleteByNo(no);
        }
    }


    public HeroNode findInfixOrder(int no) {
        //中序查找
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.findInfixOrder(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        //当前节点
        if (this.no == no) {
            return this;
        }
        //向右递归
        if (this.right != null) {
            heroNode = this.right.findInfixOrder(no);
        }
        return heroNode;
    }

    //后序遍历查找
    public HeroNode findPostOrder(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.findPostOrder(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.findPostOrder(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.no == no) {
            return this;
        }
        return heroNode;
    }


    //中序遍历
    public void infixOrder() {
        //递归向左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }


    //后序遍历
    public void postOrder() {
        //递归左子树
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归右子树
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }
}
