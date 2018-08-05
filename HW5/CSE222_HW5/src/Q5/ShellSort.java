package Q5;

/** Implements the Shell sort algorithm.
 *  @author Koffman and Wolfgang
 * */

public class ShellSort {
  /** Sort the table using Shell sort algorithm.
      pre:  table contains Comparable objects.
      post: table is sorted.
   * @param table The array to be sorted
   * @param <T> generic
   * @return sorted array
   */
  public static < T
      extends Comparable < T >> Integer[] sort(Integer[] table) {
    // Gap between adjacent elements.
    int gap = table.length / 2;
    while (gap > 0) {
      for (int nextPos = gap; nextPos < table.length;
           nextPos++) {
        // Insert element at nextPos in its subarray.
        insert(table, nextPos, gap);
      } // End for.

      // Reset gap for next pass.
      if (gap == 2) {
        gap = 1;
      }
      else {
        gap = (int) (gap / 2.2);
      }
    }
    return table;// End while.
  } // End sort.

  /** Inserts element at nextPos where it belongs in array.
      pre:  Elements through nextPos - gap in subarray are sorted.
      post: Elements through nextPos in subarray are sorted.
   * @param table The array being sorted
   * @param nextPos The position of element to insert
   * @param gap The gap between elements in the subarray
   * @param <T> generic
   */
  private static < T
      extends Comparable < T >> void insert(Integer[] table,
                                            int nextPos,
                                            int gap) {
    int nextVal = table[nextPos]; // Element to insert.
    // Shift all values > nextVal in subarray down by gap.
    while ( (nextPos > gap - 1) // First element not shifted.
           && (nextVal < (table[nextPos - gap]))) {
      table[nextPos] = table[nextPos - gap]; // Shift down.
      nextPos -= gap; // Check next position in subarray.
    }
    table[nextPos] = nextVal; // Insert nextVal.
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
