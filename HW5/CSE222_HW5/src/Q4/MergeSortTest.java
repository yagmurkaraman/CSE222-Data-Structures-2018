package Q4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yagmur on 05.03.2018.
 */
public class MergeSortTest {

    MergeSort mergeSort = new MergeSort();
    int[] array = {5, 33, 1, 44, 23};
    int[] sorted = {1, 5, 23, 33, 44};
    @Test
    public void sort() throws Exception {
        Assert.assertArrayEquals(sorted, mergeSort.sort(array));
    }
}