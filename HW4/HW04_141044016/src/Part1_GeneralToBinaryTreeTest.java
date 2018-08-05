import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by yagmur on 14.04.2018.
 */
class Part1_GeneralToBinaryTreeTest<E> {

    Part1_GeneralToBinaryTree testFamily = new Part1_GeneralToBinaryTree();

    /* add() methodu icerisinde serach methodlari bulundugu icin onlar da test edilmis oldu. */
    @Test
    void add() {
        /* Tree bos oldugu icin root'a Ali eklenir, sol tarafina veli eklenir. */
        Assert.assertEquals(true, testFamily.add("Ali", "Veli"));
        testFamily.toString("Ali");

        /* Agacta Ayse diye biri yok, bu yuzden false doner */
        Assert.assertEquals(false, testFamily.add("Ayse", "Fatma"));
        testFamily.toString("Ayse");

        /* Velinin soluna Mehmet eklenir. */
        Assert.assertEquals(true, testFamily.add("Veli", "Mehmet"));
        testFamily.toString("Veli");
    }
}