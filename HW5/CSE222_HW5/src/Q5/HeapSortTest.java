package Q5;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yagmur on 05.03.2018.
 */
public class HeapSortTest {

    HeapSort heapSort = new HeapSort();
    Integer[] array = {5, 33, 1, 44, 23};
    Integer[] sorted = {1, 5, 23, 33, 44};
    @Test
    public void sort() throws Exception {
        Assert.assertEquals(sorted, heapSort.sort(array));
    }
}