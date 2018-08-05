import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by yagmur on 14.04.2018.
 */
class Part2_MultidimensionalTreeTest {

    /* 2 boyutlu */
    Part2_MultidimensionalTree test = new Part2_MultidimensionalTree(2);
    ArrayList node1 = new ArrayList();
    ArrayList node2 = new ArrayList();
    ArrayList node3 = new ArrayList();

    /* addHelper methodu icerisinde add methodunu cagirdigi icin o da test edilmis oldu */
    @Test
    void addHelper() {
        node1.add(20);
        node1.add(30);
        test.addHelper(node1);
        Assert.assertEquals(test.root.data, node1);

        node2.add(25);
        node2.add(13);
        test.addHelper(node2);
        Assert.assertEquals(test.root.right.data, node2);

        node3.add(12);
        node3.add(45);
        test.addHelper(node3);
        Assert.assertEquals(test.root.left.data, node3);
    }
    @Test
    void printNode() {
        addHelper();
        test.printNode(node1);
    }
}