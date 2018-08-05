package Q5;

/** Implements the bubble sort algorithm.
 *  @author Koffman and Wolfgang
 * */

public class BubbleSort {

  /**
   * Sort the array using bubble sort algorithm.
   * pre:  table contains Comparable objects.
   * post: table is sorted.
   * @param table array for sorted
   * @param <T> generic
   * @return sorted table
   */
  public static < T
      extends Comparable < T >> Integer[] sort(Integer[] table) {
    int pass = 1;
    boolean exchanges = false;
    do {
      // Invariant: Elements after table.length - pass + 1
      // are in place.
      exchanges = false; // No exchanges yet.
      // Compare each pair of adjacent elements.
      for (int i = 0; i < table.length - pass; i++) {
        if (table[i] > (table[i + 1])) {
          // Exchange pair.
          int temp = table[i];
          table[i] = table[i + 1];
          table[i + 1] = temp;
          exchanges = true; // Set flag.
        }
      }
      pass++;
    }
    while (exchanges);
    return table;
    // assert: Array is sorted.
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
