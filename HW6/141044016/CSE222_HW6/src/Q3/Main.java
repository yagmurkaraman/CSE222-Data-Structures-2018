package Q3;

public class Main {
    public static void main(String[] args){

        AVLTree<String> myAVL1 = new AVLTree<String>();

        /* Kitabın 479. sayfasındaki örnekten alınmıştır. */
        myAVL1.add("The");
        myAVL1.add("quick");
        myAVL1.add("brown");
        myAVL1.add("fox");
        myAVL1.add("jumps");
        myAVL1.add("over");
        myAVL1.add("the");
        myAVL1.add("lazy");
        myAVL1.add("dog");

        System.out.println("*************************");
        System.out.println("***  AFTER INSERTING  ***");
        System.out.println("*************************");
        System.out.println(myAVL1.toString());
        System.out.println();

        System.out.println("*****************************");
        System.out.println("*** AFTER <lazy> DELETING ***");
        System.out.println("*****************************");
        myAVL1.delete("lazy");
        System.out.println(myAVL1.toString());
        System.out.println();

        System.out.println("*****************************");
        System.out.println("*** AFTER <the> DELETING  ***");
        System.out.println("*****************************");
        myAVL1.delete("The");
        System.out.println(myAVL1.toString());
        System.out.println();

        System.out.println("********************************");
        System.out.println("*** TEST a BST is AVL Tree?  ***");
        System.out.println("********************************");

        System.out.println("FIRST TREE:");
        AVLTree<Integer> testAVL1 = new AVLTree<Integer>();
        BinarySearchTree<Integer> testBST1 = new BinarySearchTree<Integer>();
        testBST1.add(6);
        testBST1.add(10);
        testBST1.add(4);
        testBST1.add(3);
        testBST1.add(5);
        testBST1.add(7);
        testBST1.add(11);
        testBST1.add(12);
        System.out.println(testBST1.toString());
        System.out.println("Is this BST is a AVL Tree?: " + testAVL1.AVLTree(testBST1));

        System.out.println("\nSECOND TREE:");
        AVLTree<Integer> testAVL2 = new AVLTree<Integer>();
        BinarySearchTree<Integer> testBST2 = new BinarySearchTree<Integer>();
        testBST2.add(3);
        testBST2.add(2);
        testBST2.add(4);
        testBST2.add(5);
        testBST2.add(6);

        System.out.println(testBST2.toString());
        System.out.println("Is this BST is a AVL Tree?: " + testAVL2.AVLTree(testBST2));
    }
}