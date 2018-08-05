package Q5;

import Q4.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by yagmur on 03.05.2018.
 */
public class MainTest {
    public static void main(String args[]) {

        System.out.print("\n-------------------------------------");
        System.out.print("\n      RUNNING-TIME FOR SIZE 100");
        System.out.print("\n-------------------------------------");
        createTestArrays(100);

        System.out.print("\n-------------------------------------");
        System.out.print("\n      RUNNING-TIME FOR SIZE 1000");
        System.out.print("\n-------------------------------------");
        createTestArrays(1000);

        System.out.print("\n-------------------------------------");
        System.out.print("\n      RUNNING-TIME FOR SIZE 5000");
        System.out.print("\n-------------------------------------");
        createTestArrays(5000);

        System.out.print("\n-------------------------------------");
        System.out.print("\n      RUNNING-TIME FOR SIZE 10000");
        System.out.print("\n-------------------------------------");
        createTestArrays(10000);
    }
    public static void createTestArrays(int size) {

        Integer[] testList = new Integer[size];
        KWLinkedList<Integer> testLinkedList = new KWLinkedList<>();

        for(int i=0; i<testList.length; ++i)
            testList[i]=-1;

        Random rand = new Random();
        int counter = 0;
        while (counter < size) {
            int randValue = Math.abs((rand.nextInt() % size * 3) + 7);/* a larger interval! */
            if(!iscontains(testList, randValue)) {
                testList[counter] = randValue;
                ++counter;
            }
        }
        callSortAlgorithms(testList);
    }
    public static Integer[] reverseArray(Integer[] testList) {
        Arrays.sort(testList, Collections.reverseOrder()); // arrayi tersten sıraladım, worst case için
        return testList;
    }
    public static boolean iscontains(Integer[] array, int random) {

        boolean result = false;

        for(int i : array) {
            if (i == random) {
                result = true;
                break;
            }
        }
        return result;
    }
    public static void callSortAlgorithms(Integer[] testList) {

        HeapSort heapSort = new HeapSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        ShellSort shellSort = new ShellSort();

        testList=reverseArray(testList);
        long startTime = System.nanoTime();
        heapSort.sort(testList);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("\nHeapSort Time: " + estimatedTime + " ns");

        testList=reverseArray(testList);
        startTime = System.nanoTime();
        insertionSort.sort(testList);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("InsertionSort Time: " + estimatedTime + " ns");

        testList=reverseArray(testList);
        startTime = System.nanoTime();
        mergeSort.sort(testList);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("MergeSort Time: " + estimatedTime + " ns");

        testList=reverseArray(testList);
        startTime = System.nanoTime();
        quickSort.sort(testList);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("QuickSort Time: " + estimatedTime + " ns");

        testList=reverseArray(testList);
        startTime = System.nanoTime();
        bubbleSort.sort(testList);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("BubbleSort Time: " + estimatedTime + " ns");

        testList=reverseArray(testList);
        startTime = System.nanoTime();
        selectionSort.sort(testList);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("SelectionSort Time: " + estimatedTime + " ns");

        testList=reverseArray(testList);
        startTime = System.nanoTime();
        shellSort.sort(testList);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ShellSort Time: " + estimatedTime + " ns");
    }
}