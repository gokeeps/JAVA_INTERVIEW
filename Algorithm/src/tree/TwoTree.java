package tree;
public class TwoTree {
    public Tree root;

    /**
     * 二叉搜索树创建
     * @param number
     */
    public void insert(Integer number) {
        Tree tree = new Tree(number);
        if (root == null) {
            root = tree;
            return;
        }
        Tree treeTmp = root;
        while (true) {
            if (treeTmp.value.equals(number)) {
                break;
            }
            if (number < treeTmp.value) {
                if (treeTmp.left == null) {
                    treeTmp.left = tree;
                    break;
                }else {
                    treeTmp = treeTmp.left;
                }
            }else {
                if (treeTmp.right == null) {
                    treeTmp.right = tree;
                    break;
                }else {
                    treeTmp = treeTmp.right;
                }
            }
        }
    }


    public void beforeSort(Tree tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.value + " ");
        beforeSort(tree.left);
        beforeSort(tree.right);
    }


    public void centerSort(Tree tree) {
        if (tree == null) {
            return;
        }
        centerSort(tree.left);
        System.out.print(tree.value + " ");
        centerSort(tree.right);
    }

    public void afterSort(Tree tree) {
        if (tree == null) {
            return;
        }
        afterSort(tree.left);
        afterSort(tree.right);
        System.out.print(tree.value + " ");

    }

    @Override
    public String toString() {
        return "TwoTree{" + "root=" + root + '}';
    }

    public static void main(String[] args) {
        TwoTree twoTree = new TwoTree();
        twoTree.insert(5);
        twoTree.insert(4);
        twoTree.insert(3);
        twoTree.insert(7);
        twoTree.insert(2);
        twoTree.insert(8);
        twoTree.insert(1);
        twoTree.insert(6);
        System.out.println(twoTree);
        twoTree.beforeSort(twoTree.root);
        System.out.println();
        twoTree.centerSort(twoTree.root);
        System.out.println();
        twoTree.afterSort(twoTree.root);
    }
}

class Tree {
    public Tree(Integer value) {
        this.value = value;
    }

    public Integer value;
    public Tree left;
    public Tree right;

    @Override public String toString() {
        return "Tree{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
    }
}