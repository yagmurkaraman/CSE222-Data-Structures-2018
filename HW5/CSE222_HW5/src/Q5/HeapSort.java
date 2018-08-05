package Q5;

/** Implementation of the heapsort algorithm.
 *  @author Koffman and Wolfgang
 * */

public class HeapSort {
  /** Sort the array using heapsort algorithm.
      pre: table contains Comparable items.
      post: table is sorted.
   * @param table array for sorted
   * @param <T> generic
   * @return sorted table
   */
  public static < T
      extends Comparable < T >> Integer[] sort(Integer[] table) {
    buildHeap(table);

    shrinkHeap(table);
    return table;
  }
  /** buildHeap transforms the table into a heap.
   pre:  The array contains at least one item.
   post: All items in the array are in heap order.
   * @param table The array to be transformed into a heap
   * @param <T> generic
   */
  private static < T
      extends Comparable < T >> void buildHeap(Integer[] table) {
    int n = 1;

    // Invariant: table[0 . . . n - 1] is a heap.
    while (n < table.length) {
      n++; // Add a new item to the heap and reheap.
      int child = n - 1;
      int parent = (child - 1) / 2; // Find parent.
      while (parent >= 0
             && table[parent] < (table[child])) {
        swap(table, parent, child);
        child = parent;
        parent = (child - 1) / 2;
      }
    }
  }

  /** shrinkHeap transforms a heap into a sorted array.
      pre: All items in the array are in heap order.
      post: The array is sorted.
   * @param table The array to be sorted
   * @param <T> generic
   */
  private static < T
      extends Comparable < T >> void shrinkHeap(Integer[] table) {
    int n = table.length;

    // Invariant: table[0 . . . n - 1] forms a heap.
    // table[n . . . table.length - 1] is sorted.
    while (n > 0) {
      n--;
      swap(table, 0, n);
      // table[1 . . . n - 1] form a heap.
      // table[n . . . table.length - 1] is sorted.
      int parent = 0;
      while (true) {
        int leftChild = 2 * parent + 1;
        if (leftChild >= n) {
          break; // No more children.
        }
        int rightChild = leftChild + 1;
        // Find the larger of the two children.
        int maxChild = leftChild;
        if (rightChild < n // There is a right child.
            && table[leftChild] < (table[rightChild])) {
          maxChild = rightChild;
        }
        // If the parent is smaller than the larger child,
        if (table[parent] < (table[maxChild])) {
          // Swap the parent and child.
          swap(table, parent, maxChild);
          // Continue at the child level.
          parent = maxChild;
        }
        else { // Heap property is restored.
          break; // Exit the loop.
        }
      }
    }
  }

  /** Swap the items in table[i] and table[j].
   * @param table The array that contains the items
   * @param i The index of one item
   * @param j The index of the other item
   * @param <T> generic
   */
  private static < T
      extends Comparable < T >> void swap(Integer[] table,
                                          int i, int j) {
    int temp = table[i];
    table[i] = table[j];
    table[j] = temp;
  }
  /**
   * Print the sorted array
   * @param table sorted array
   */
  public static void printArray(Integer[] table) {
    System.out.println();
    for(int i=0; i<table.length; ++i) {
      System.out.print(table[i] + " ");
    }
  }
}
