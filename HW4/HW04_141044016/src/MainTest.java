import java.util.ArrayList;

/**
 * Created by yagmur on 10.04.2018.
 */
public class MainTest {

    public static void main(String[] args) throws Exception {

        System.out.println("**************************************************");
        System.out.println("*******************  PART 1   ********************");
        System.out.println("**************************************************");

        System.out.println("\n########## TREE 1 - ENGLAND FAMILY ##########");
        Part1_GeneralToBinaryTree englandFamily = new Part1_GeneralToBinaryTree();
        System.out.println("Tree is empty. Add -> Parent-William 1 and Child-Robert:");
        englandFamily.add("William 1", "Robert");
        englandFamily.toString("William 1");

        System.out.println("Parent-William 1 and Child-William 2:");
        englandFamily.add("William 1", "William 2");
        englandFamily.toString("Robert");

        System.out.println("Parent-William 1 and Child-Adela:");
        englandFamily.add("William 1", "Adela");
        englandFamily.toString("William 2");

        System.out.println("Parent-William 1 and Child-Henry 1:");
        englandFamily.add("William 1", "Henry 1");
        englandFamily.toString("Adela");

        System.out.println("Parent-Robert and Child-William:");
        englandFamily.add("Robert", "William");
        englandFamily.toString("Robert");

        System.out.println("Parent-Adela and Child-Stephen:");
        englandFamily.add("Adela", "Stephen");
        englandFamily.toString("Adela");

        System.out.println("Parent-Henry 1 and Child-William:");
        englandFamily.add("Henry 1", "William");
        englandFamily.toString("Henry 1");

        System.out.println("Parent-Henry 1 and Child-Matilda:");
        englandFamily.add("Henry 1", "Matilda");
        englandFamily.toString("William");

        System.out.println("Parent-Matilda and Child-Henry 2:");
        englandFamily.add("Matilda", "Henry 2");
        englandFamily.toString("Matilda");

        System.out.println("Parent-Henry 2 and Child-Henry:");
        englandFamily.add("Henry 2", "Henry");
        englandFamily.toString("Henry 2");

        System.out.println("Parent-Henry 2 and Child-Richard 1:");
        englandFamily.add("Henry 2", "Richard 1");
        englandFamily.toString("Henry");

        englandFamily.helperPreOrder();
        System.out.print("\n\n");
        System.out.println("BinaryTreeClass PreOrderTraverse: \n" + englandFamily.toString());

        System.out.println("\n################   TREE 2   ################");
        Part1_GeneralToBinaryTree myTree = new Part1_GeneralToBinaryTree();

        System.out.println("Tree is empty. Add -> Parent-Ahmet and Child-Ecrin:");
        myTree.add("Ahmet", "Ecrin");
        myTree.toString("Ahmet");

        System.out.println("Parent-Ahmet and Child-Mehmet:");
        myTree.add("Ahmet", "Mehmet");
        myTree.toString("Ecrin");

        System.out.println("Parent-Mehmet and Child-Ali:");
        myTree.add("Mehmet", "Ali");
        myTree.toString("Mehmet");

        System.out.println("Parent-Mehmet and Child-Veli:");
        myTree.add("Mehmet", "Veli");
        myTree.toString("Ali");

        System.out.println("Parent-Ecrin and Child-Esila:");
        myTree.add("Ecrin", "Esila");
        myTree.toString("Ecrin");

        System.out.println("Parent-Ahmet and Child-Ayse:");
        myTree.add("Ahmet", "Ayse");
        myTree.toString("Mehmet");

        System.out.println("Parent-Ecrin and Child-Yagmur:");
        myTree.add("Ecrin", "Yagmur");
        myTree.toString("Esila");

        System.out.println("Parent-Yagmur and Child-Erdi:");
        myTree.add("Yagmur", "Erdi");
        myTree.toString("Yagmur");

        System.out.println("Parent-Ahmet and Child-Filiz:");
        myTree.add("Ahmet", "Filiz");
        myTree.toString("Ayse");

        System.out.println("Parent-Ayse and Child-Fatma:");
        myTree.add("Ayse", "Fatma");
        myTree.toString("Ayse");

        System.out.println("Parent-Filiz and Child-Yıldız:");
        myTree.add("Filiz", "Yıldız");
        myTree.toString("Filiz");

        myTree.helperPreOrder();
        System.out.print("\n\n");
        System.out.println("BinaryTreeClass PreOrderTraverse: \n" + myTree.toString());

        System.out.println("\n\n**************************************************");
        System.out.println("*******************  PART 2   ********************");
        System.out.println("**************************************************");

        System.out.println("\n############# TREE 1: 2 DIMENSION ##############");

        Part2_MultidimensionalTree part2 = new Part2_MultidimensionalTree(2);
        ArrayList node1 = new ArrayList();
        node1.add(40);
        node1.add(45);
        part2.addHelper(node1);
        part2.printNode(node1);

        ArrayList node2 = new ArrayList();
        node2.add(15);
        node2.add(70);
        part2.addHelper(node2);
        part2.printNode(node1);

        ArrayList node3 = new ArrayList();
        node3.add(70);
        node3.add(10);
        part2.addHelper(node3);
        part2.printNode(node1);

        ArrayList node4 = new ArrayList();
        node4.add(69);
        node4.add(50);
        part2.addHelper(node4);
        part2.printNode(node3);

        ArrayList node5 = new ArrayList();
        node5.add(66);
        node5.add(85);
        part2.addHelper(node5);
        part2.printNode(node4);

        ArrayList node6 = new ArrayList();
        node6.add(85);
        node6.add(90);
        part2.addHelper(node6);
        part2.printNode(node4);

        System.out.println("\n############## TREE 2: 3 DIMENSION #############");

        Part2_MultidimensionalTree part22 = new Part2_MultidimensionalTree();

        ArrayList node12 = new ArrayList();
        node12.add(4);
        node12.add(5);
        node12.add(10);
        part22.addHelper(node12);
        part22.printNode(node12);

        ArrayList node22 = new ArrayList();
        node22.add(2);
        node22.add(20);
        node22.add(40);
        part22.addHelper(node22);
        part22.printNode(node12);

        ArrayList node32 = new ArrayList();
        node32.add(10);
        node32.add(15);
        node32.add(8);
        part22.addHelper(node32);
        part22.printNode(node12);

        ArrayList node42 = new ArrayList();
        node42.add(20);
        node42.add(13);
        node42.add(7);
        part22.addHelper(node42);
        part22.printNode(node32);

        ArrayList node52 = new ArrayList();
        node52.add(8);
        node52.add(18);
        node52.add(30);
        part22.addHelper(node52);
        part22.printNode(node32);

        ArrayList node62 = new ArrayList();
        node62.add(15);
        node62.add(28);
        node62.add(40);
        part22.addHelper(node62);
        part22.printNode(node52);
    }
}