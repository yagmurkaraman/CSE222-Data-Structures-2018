package Q4;

/** Implements the quicksort algorithm.
 *   @author Koffman and Wolfgang
 * */

public class QuickSort {

    /** Sort the table using the quicksort algorithm.
     pre: table contains Comparable objects.
     post: table is sorted.
     * @param table The array to be sorted
     * @param <T> generic
     * @return sorted array
     */
    public static < T extends Comparable < T >> int[] sort(int[] table) {
        // Sort the whole table.
        quickSort(table, 0, table.length - 1);
        return table;
        //printArray(table);
    }

    /** Sort a part of the table using the quicksort algorithm.
     post: The part of table from first through last is sorted.
     * @param table The array to be sorted
     * @param first The index of the low bound
     * @param last The index of the high bound
     * @param <T> generic
     */
    private static < T extends Comparable < T >> void quickSort(int[] table,
                                                                int first,
                                                                int last) {
        if (first < last) { // There is data to be sorted.
            // Partition the table.
            int pivIndex = partition(table, first, last);
            // Sort the left half.
            quickSort(table, first, pivIndex - 1);
            // Sort the right half.
            quickSort(table, pivIndex + 1, last);
        }
    }

    /** Partition the table so that values from first to pivIndex
     are less than or equal to the pivot value, and values from
     pivIndex to last are greater than the pivot value.
     @return The location of the pivot value
      * @param table The table to be partitioned
     * @param first The index of the low bound
     * @param last  The index of the high bound
     * @param <T> generic
     */
    private static < T extends Comparable < T >> int partition(int[] table,
                                                               int first,
                                                               int last) {
        // Select the first item as the pivot value.
        int pivot = table[first];
        int up = first;
        int down = last;
        do {
      /* Invariant:
         All items in table[first . . . up - 1] <= pivot
         All items in table[down + 1 . . . last] > pivot
       */
            while ( (up < last) && (pivot>=(table[up]))) {
                up++;
            }
            // assert: up equals last or table[up] > pivot.
            while (pivot<(table[down])) {
                down--;
            }
            // assert: down equals first or table[down] <= pivot.
            if (up < down) { // if up is to the left of down.
                // Exchange table[up] and table[down].
                swap(table, up, down);
            }
        }
        while (up < down); // Repeat while up is left of down.

        // Exchange table[first] and table[down] thus putting the
        // pivot value where it belongs.
        swap(table, first, down);

        // Return the index of the pivot value.
        return down;
    }

    /** Swap the items in table[i] and table[j].
     * @param table The array that contains the items
     * @param i The index of one item
     * @param j The index of the other item
     * @param <T> generic
     */
    private static < T extends Comparable < T >> void swap(int[] table,
                                                           int i, int j) {
        int temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }
    /**
     * Print sorted array
     * @param table sorted array
     */
    public static void printArray(int[] table) {

        for(int i=0; i<table.length; ++i) {
            System.out.print(table[i] + " ");
        }
    }

}
