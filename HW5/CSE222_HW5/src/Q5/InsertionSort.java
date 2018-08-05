package Q5;

import javax.swing.plaf.synth.SynthTextAreaUI;

/** Implements the insertion sort algorithm.
 *  @author Koffman and Wolfgang
 * */

public class InsertionSort {
  /** Sort the table using insertion sort algorithm.
      pre:  table contains Comparable objects.
      post: table is sorted.
   * @param table The array to be sorted
   * @param <T> generic
   * @return sorted array
   */
  public static < T
      extends Comparable < T >> Integer[] sort(Integer[] table) {
    for (int nextPos = 1; nextPos < table.length; nextPos++) {
      // Invariant: table[0 . . . nextPos - 1] is sorted.
      // Insert element at position nextPos
      // in the sorted subarray.
      insert(table, nextPos);
    }
    return table;
  } // End sort.

  /** Insert the element at nextPos where it belongs
      in the array.
      pre:  table[0 . . . nextPos - 1] is sorted.
      post: table[0 . . . nextPos] is sorted.
   * @param table The array being sorted
   * @param nextPos The position of the element to insert
   * @param <T> generic
   */
  private static < T
      extends Comparable < T >> void insert(Integer[] table,
                                            int nextPos) {
    int nextVal = table[nextPos]; // Element to insert.
    while ((nextPos > 0)
            && (nextVal < (table[nextPos - 1]))) {
      table[nextPos] = table[nextPos - 1]; // Shift down.
      nextPos--; // Check next smaller element.
    }
    // Insert nextVal at nextPos.
    table[nextPos] = nextVal;
  }
  /**
   * Print the sorted array
   * @param table sorted array
   */
  public static void printArray(Integer[] table) {
    for(int i=0; i<table.length; ++i) {
      System.out.print(table[i] + " ");
    }
  }
}
