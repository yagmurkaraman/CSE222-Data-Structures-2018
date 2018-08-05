package Q5;

/** Implements the selection sort algorithm.
 *  @author Koffman and Wolfgang
 * */

public class SelectionSort {

  /** Sort the array using selection sort algorithm.
      pre:  table contains Comparable objects.
      post: table is sorted.
   * @param table The array to be sorted
   * @return sorted array
   */
  public static Integer[] sort(Integer[] table) {
    int n = table.length;
    for (int fill = 0; fill < n - 1; fill++) {
      // Invariant: table[0 . . . fill � 1] is sorted.
      int posMin = fill;
      for (int next = fill + 1; next < n; next++) {
        // Invariant: table[posMin] is the smallest item in
        // table[fill . . . next - 1].
        if (table[next] < (table[posMin])) {
          posMin = next;
        }
      }
      // assert: table[posMin] is the smallest item in
      // table[fill . . . n - 1].
      // Exchange table[fill] and table[posMin].
      Comparable temp = table[fill];
      table[fill] = table[posMin];
      table[posMin] = (int) temp;
      // assert: table[fill] is the smallest item in
      // table[fill . . . n - 1].
    }
    return table;
    // assert: table[0 . . . n - 1] is sorted.
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
