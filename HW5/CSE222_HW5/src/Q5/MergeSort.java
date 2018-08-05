package Q5;

/** Implements the recursive merge sort algorithm. In this version, copies
*   of the subtables are made, sorted, and then merged.
*   @author Koffman and Wolfgang
*/

public class MergeSort {
  /** Sort the array using the merge sort algorithm.
      pre: table contains Comparable objects.
      post: table is sorted.
   * @param table The array to be sorted
   * @param <T> generic
   * @return sorted array
   */
  public static < T
      extends Comparable < T >> Integer[] sort(Integer[] table) {
    // A table with one element is sorted already.
    if (table.length > 1) {
      // Split table into halves.
      int halfSize = table.length / 2;
      Integer[] leftTable = new Integer[halfSize];
      Integer[] rightTable = new Integer[table.length - halfSize];
      System.arraycopy(table, 0, leftTable, 0, halfSize);
      System.arraycopy(table, halfSize, rightTable, 0,
                       table.length - halfSize);

      // Sort the halves.
      sort(leftTable);
      sort(rightTable);

      // Merge the halves.
      merge(table, leftTable, rightTable);
      return table;
    }
    else
      return table;
  }

  /** Merge two sequences.
       pre: leftSequence and rightSequence are sorted.
       post: outputSequence is the merged result and is sorted.
   * @param outputSequence The destination
   * @param leftSequence The left input
   * @param rightSequence The right input
   * @param <T> generic
   */
  private static < T
      extends Comparable < T >> void merge(Integer[] outputSequence,
                                           Integer[] leftSequence,
                                           Integer[] rightSequence) {
    int i = 0; // Index into the left input sequence.
    int j = 0; // Index into the right input sequence.
    int k = 0; // Index into the output sequence.

    // While there is data in both input sequences
    while (i < leftSequence.length && j < rightSequence.length) {
      // Find the smaller and
      // insert it into the output sequence.
      if (leftSequence[i] < (rightSequence[j])) {
        outputSequence[k++] = leftSequence[i++];
      }
      else {
        outputSequence[k++] = rightSequence[j++];
      }
    }
    // assert: one of the sequences has more items to copy.
    // Copy remaining input from left sequence into the output.
    while (i < leftSequence.length) {
      outputSequence[k++] = leftSequence[i++];
    }
    // Copy remaining input from right sequence into output.
    while (j < rightSequence.length) {
      outputSequence[k++] = rightSequence[j++];
    }
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
