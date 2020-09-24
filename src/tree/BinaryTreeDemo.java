package tree;

/**
 * @author EricRaww
 * @create 2020-03-12
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先创建一个二叉树
        binaryTree binaryTree = new binaryTree();
        //新建节点
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴勇");
        HeroNode node3 = new HeroNode(3, "jun yi");
        HeroNode node4 = new HeroNode(4, "lin");
        HeroNode node5 = new HeroNode(5, "guan");


        binaryTree.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        //binaryTree.preOrder();//1,2,3,5,4
        //2,1,5,3,4
        //binaryTree.infixOrder();
        //2,5,4,3,1
        // binaryTree.postOrder();
//        HeroNode heroNode = binaryTree.findperOrder(9);
        //System.out.println(heroNode.toString());
//        HeroNode infixOrder = binaryTree.findInfixOrder(4);
//        System.out.println(infixOrder.toString());


//        System.out.println(binaryTree.findPostOrder(2).toString());
        binaryTree.deleteByNo(1);
        binaryTree.preOrder();
    }

}

//binaryTree
class binaryTree {
    private HeroNode root;


    public void setRoot(HeroNode root) {
        this.root = root;
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
