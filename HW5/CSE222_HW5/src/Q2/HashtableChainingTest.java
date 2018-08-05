package Q2;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by yagmur on 06.05.2018.
 */
class HashtableChainingTest {

    HashtableChaining hashtable = new HashtableChaining();

    @Test
    void add() {
        Assert.assertEquals(true, hashtable.add(11));
        Assert.assertEquals(true, hashtable.add(12));
        Assert.assertEquals(true, hashtable.add(13));
        Assert.assertEquals(true, hashtable.add("a"));
        Assert.assertEquals(true, hashtable.add("b"));
        Assert.assertEquals(true, hashtable.add("c"));
    }
    @Test
    void contains() {
        add();
        Assert.assertEquals(true, hashtable.contains(11));
        Assert.assertEquals(true, hashtable.contains(13));

    }
    @Test
    void isEmpty() {
        Assert.assertEquals(true, hashtable.isEmpty());
    }
}