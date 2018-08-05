package Q2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yagmur on 16.05.2018.
 */
public class BTreeTest {

    BTree<Integer> test1 = new BTree<>(3);
    BTree<Integer> test2 = new BTree<>(3);

    @Test
    public void add() throws Exception {
        test1.add(15);
        test1.add(6);
        test1.add(13);
        test1.add(11);
        test1.add(7);
        test1.add(9);
        test1.add(10);
        test1.add(16);
        System.out.print(test1.toString());

        test2.add(11);
        test2.add(10);
        test2.add(9);
        test2.add(6);
        test2.add(12);
        test2.add(14);
        test2.add(5);
        test2.add(1);
        System.out.print(test2.toString());
    }
}