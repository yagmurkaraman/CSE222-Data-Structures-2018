package Q4;

import org.junit.Test;

/**
 * Created by yagmur on 06.05.2018.
 */
public class MergeSortDllTest {

    MergeSortDll mergeSortDll = new MergeSortDll();
    KWLinkedList<Integer> testLinkedList = new KWLinkedList<>();

    @Test
    public void sort() throws Exception {

        testLinkedList.add(0, 15);
        testLinkedList.add(1, 7);
        testLinkedList.add(2, 33);
        testLinkedList.add(3, 17);
        testLinkedList.add(4, 9);

        KWLinkedList.Node newHead = mergeSortDll.sort(testLinkedList.head);
        mergeSortDll.printList(newHead);

    }

}