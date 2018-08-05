package Q3;

import java.util.Random;

/**
 * Created by yagmur on 02.05.2018.
 */
public class MainTest {

    public static void main(String args[]) {

        KWLinkedList<Integer> myList = new KWLinkedList<>();
        MergeSortDll<Integer> mergeSortDll = new MergeSortDll<>();
        Random rand = new Random();
        int counter = 0;
        while (counter < 10) {
            int randValue = Math.abs((rand.nextInt() % 10*3) + 7);/* a larger interval! */
            myList.add(counter++, randValue);
        }
        System.out.print("Before sorting: ");
        for(int i=0; i<myList.size; ++i) {
            System.out.print(myList.get(i)+" ");
        }
        System.out.print("\n");
        KWLinkedList.Node newHead =mergeSortDll.sort(myList.head);
        System.out.print("After sorting: ");
        mergeSortDll.printList(newHead);
    }
}
