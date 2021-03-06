package Q4;

import org.junit.Assert;
import org.junit.Test;
/**
 * Created by yagmur on 06.05.2018.
 */
public class HeapSortTest {

    HeapSort heapSort = new HeapSort();

    int[] array = {5, 33, 1, 44, 23};
    int[] sorted = {1, 5, 23, 33, 44};
    @Test
    public void sort() throws Exception {
        Assert.assertArrayEquals(sorted, heapSort.sort(array));
    }

}