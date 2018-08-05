package Q1;

/**
 * Created by yagmur on 16.05.2018.
 */
public class Main {
    public static void main(String args[]) {
        RedBlackTree<Integer> myTree1 = new RedBlackTree<Integer>();
        RedBlackTree<Integer> myTree2 = new RedBlackTree<Integer>();

        System.out.println("*******************************");
        System.out.println("*******  First Tree   *********");
        System.out.println("*******************************");
        myTree1.createWorstRBTree();

        System.out.println("*******************************");
        System.out.println("*******  Second Tree   ********");
        System.out.println("*******************************");
        myTree2.createWorstRBTree();
    }
}
