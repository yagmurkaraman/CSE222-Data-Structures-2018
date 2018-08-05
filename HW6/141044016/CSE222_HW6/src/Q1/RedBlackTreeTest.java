package Q1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yagmur on 16.05.2018.
 */
public class RedBlackTreeTest {

    RedBlackTree<Integer> test = new RedBlackTree<Integer>();
    @Test
    public void createWorstRBTree() throws Exception {
        test.createWorstRBTree();
        System.out.println(test.toString());
    }
}