package Q2;

/**
 * Created by yagmur on 15.05.2018.
 */
public class Main {
    public static void main(String[] args){
        BTree<Integer> myBTree = new BTree<>(3);
        myBTree.add(10);
        myBTree.add(22);
        myBTree.add(30);
        myBTree.add(40);
        myBTree.add(13);
        myBTree.add(15);
        myBTree.add(18);
        myBTree.add(20);
        myBTree.add(5);
        myBTree.add(7);
        myBTree.add(8);
        myBTree.add(26);
        myBTree.add(27);
        myBTree.add(32);
        myBTree.add(35);
        myBTree.add(38);
        myBTree.add(42);
        myBTree.add(46);

        System.out.println(myBTree.toString());
    }
}
