package Q4;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by yagmur on 02.05.2018.
 */
public class MainTest < T
        extends Comparable < T >> {

    public static int heap=0;
    public static int insertion=0;
    public static int merge=0;
    public static int merdll=0;
    public static int quick=0;

    public static void main(String args[]) throws InterruptedException {

        System.out.println("\n-------------------------");
        System.out.println("RUNNING-TIME FOR SIZE 1000");
        System.out.println("-------------------------");
        for(int i=0; i<10; ++i) {
            createTestArrays(1000);
            System.out.print("\n");
        }

        printAverage(1000);

        System.out.println("\n-------------------------");
        System.out.println("RUNNING-TIME FOR SIZE 2000");
        System.out.println("-------------------------");
        for(int i=0; i<10; ++i) {
            createTestArrays(2000);
            System.out.print("\n");
        }
        printAverage(2000);

        System.out.println("\n-------------------------");
        System.out.println("RUNNING-TIME FOR SIZE 3000");
        System.out.println("-------------------------");
        for(int i=0; i<10; ++i) {
            createTestArrays(3000);
            System.out.print("\n");
        }
        printAverage(3000);

        System.out.println("\n-------------------------");
        System.out.println("RUNNING-TIME FOR SIZE 4000");
        System.out.println("-------------------------");
        for(int i=0; i<10; ++i) {
            createTestArrays(4000);
            System.out.print("\n");
        }
        printAverage(4000);

        System.out.println("\n-------------------------");
        System.out.println("RUNNING-TIME FOR SIZE 5000");
        System.out.println("-------------------------");
        for(int i=0; i<10; ++i) {
            createTestArrays(5000);
            System.out.print("\n");
        }
        printAverage(5000);

        System.out.println("\n-------------------------");
        System.out.println("RUNNING-TIME FOR SIZE 6000");
        System.out.println("-------------------------");
        for(int i=0; i<10; ++i) {
            createTestArrays(6000);
            System.out.print("\n");
        }
        printAverage(6000);

        System.out.println("\n-------------------------");
        System.out.println("RUNNING-TIME FOR SIZE 7000");
        System.out.println("-------------------------");
        for(int i=0; i<10; ++i) {
            createTestArrays(7000);
            System.out.print("\n");
        }
        printAverage(7000);

        System.out.println("\n-------------------------");
        System.out.println("RUNNING-TIME FOR SIZE 8000");
        System.out.println("-------------------------");
        for(int i=0; i<10; ++i) {
            createTestArrays(8000);
            System.out.print("\n");
        }
        printAverage(8000);

        System.out.println("\n-------------------------");
        System.out.println("RUNNING-TIME FOR SIZE 9000");
        System.out.println("-------------------------");
        for(int i=0; i<10; ++i) {
            createTestArrays(9000);
            System.out.print("\n");
        }
        printAverage(9000);

        System.out.println("\n-------------------------");
        System.out.println("RUNNING-TIME FOR SIZE 10000");
        System.out.println("-------------------------");
        for(int i=0; i<10; ++i) {
            createTestArrays(10000);
            System.out.print("\n");
        }
        printAverage(10000);

    }
    public static void createTestArrays(int size) {

        int[] testList = new int[size];
        KWLinkedList<Integer> testLinkedList = new KWLinkedList<>();

        Random rand = new Random();
        int counter = 0;
        int counter1 = 0;
        while (counter < size) {
            int randValue = Math.abs((rand.nextInt() % size*3) + 7);/* a larger interval! */
            if(!iscontains(testList, randValue)) {
                testList[counter1] = randValue;
                counter1++;
            }
            testLinkedList.add(counter, randValue);
            ++counter;
        }
        callSortAlgorithms(testList, testLinkedList);
    }
    public static boolean iscontains(int[] array, int random) {

        boolean result = false;

        for(int i : array) {
            if (i == random) {
                result = true;
                break;
            }
        }
        return result;
    }
    public static void callSortAlgorithms(int[] testList, KWLinkedList<Integer> testLinkedList) {

        int[] tempList = new int[testList.length];
        for(int i=0; i<testList.length; ++i)
            tempList[i]=testList[i];

        KWLinkedList<Integer> tempLinkedList = new KWLinkedList<>();
        for(int i=0; i<testLinkedList.size; ++i)
            tempLinkedList.add(i, testLinkedList.get(i));

        HeapSort heapSort = new HeapSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        MergeSortDll mergeSortDll = new MergeSortDll();

        for(int i=0; i<testList.length; ++i)
            testList[i]=tempList[i];

        long startTime = System.nanoTime();
        heapSort.sort(testList);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("HeapSort Time: " + estimatedTime + " ns");
        heap+=estimatedTime;

        for(int i=0; i<testList.length; ++i)
            testList[i]=tempList[i];

        startTime = System.nanoTime();
        insertionSort.sort(testList);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("InsertionSort Time: " + estimatedTime + " ns");
        insertion+=estimatedTime;

        for(int i=0; i<testList.length; ++i)
            testList[i]=tempList[i];

        startTime = System.nanoTime();
        mergeSort.sort(testList);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("MergeSort Time: " + estimatedTime + " ns");
        merge+=estimatedTime;

        for(int i=0; i<testList.length; ++i)
            testList[i]=tempList[i];

        startTime = System.nanoTime();
        quickSort.sort(testList);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("QuickSort Time: " + estimatedTime + " ns");
        quick+=estimatedTime;

        testLinkedList=null;
        testLinkedList = new KWLinkedList<>();
        for(int i=0; i<tempLinkedList.size; ++i)
            testLinkedList.add(i, tempLinkedList.get(i));

        startTime = System.nanoTime();
        KWLinkedList.Node newHead = mergeSortDll.sort(testLinkedList.head);
        //mergeSortDll.printList(testLinkedList.head);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("MergeSort with dll Time: " + estimatedTime + " ns");
        merdll+=estimatedTime;
    }
    public static void printAverage(int size) {

        System.out.println("\n-------------------------");
        System.out.println("AVERAGE-TIME FOR SIZE " + size);
        System.out.println("-------------------------");

        System.out.println("HeapSort: " + heap/10);
        System.out.println("InsertionSort: " + insertion/10);
        System.out.println("MergeSort: " + merge/10);
        System.out.println("QuickSort: " + quick/10);
        System.out.println("MergeSortDll: " + merdll/10);

        heap=0;
        insertion=0;
        merge=0;
        quick=0;
        merdll=0;
    }
}
