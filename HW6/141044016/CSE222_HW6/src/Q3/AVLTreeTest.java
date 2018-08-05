package Q3;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yagmur on 16.05.2018.
 */
public class AVLTreeTest {

    AVLTree<Integer> test1 = new AVLTree<Integer>();
    BinarySearchTree<Integer> testBST1 = new BinarySearchTree<Integer>();
    BinarySearchTree<Integer> testBST2 = new BinarySearchTree<Integer>();

    @Test
    public void checkAVLTree() throws Exception {
        testBST1.add(6);
        testBST1.add(14);
        testBST1.add(12);
        testBST1.add(1);
        testBST1.add(10);
        System.out.println("testBST1 is not a BST");
        Assert.assertEquals(false, test1.checkAVLTree(testBST1.root));

        testBST2.add(6);
        testBST2.add(14);
        testBST2.add(12);
        testBST2.add(1);
        testBST2.add(17);
        System.out.println("testBST2 is a BST");
        Assert.assertEquals(true, test1.checkAVLTree(testBST2.root));
    }
    @Test
    public void add() throws Exception {

        System.out.println("\nadd() methodu test:");
        test1.add(6);
        test1.add(5);
        test1.add(2);
        test1.add(3);
        test1.add(8);
        System.out.print(test1.toString());
    }
    @Test
    public void delete() throws Exception {

        System.out.println("\ndelete() methodu test:");
        test1.add(6);
        test1.add(5);
        test1.add(2);
        test1.add(3);
        test1.add(8);
        test1.delete(5);
        System.out.print(test1.toString());
    }
}