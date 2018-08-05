package Q4;

/**
 * Created by yagmur on 02.05.2018.
 */
public class MergeSortDll<E> extends KWLinkedList<E>{

    /**
     * Sort two sequences
     * @param head head of list
     * @param <T> generic
     * @return head of sorted sequence
     */
    public static < T extends Comparable < T >> Node sort(Node head) {

        Node temp = head;
        int halfSize = sizeOfList(head) / 2;
        if(head.next == null)
            return head;

        while(halfSize-1 > 0) {
            temp = temp.next;
            halfSize--;
        }
        Node second = temp.next;
        temp.next = null;
        temp = head;

        Node left = sort(temp);//make recursive calls
        Node right = sort(second);
        return merge(left, right); // merge the sorted lists
    }
    /** Merge two sequences.
     pre: leftSequence and rightSequence are sorted.
     post: outputSequence is the merged result and is sorted.
     @param leftSequence The destination
     @param rightSequence The left input
     * @param <T> generic
     */
    private static < T extends Comparable < T >> Node merge(Node leftSequence, Node rightSequence) {

        Node result = null;
        if (leftSequence == null)
            return rightSequence;

        if (rightSequence == null)
            return leftSequence;

        if ((Integer)leftSequence.data > (Integer) rightSequence.data) {
            result = rightSequence;
            result.next = merge(leftSequence, rightSequence.next);

        } else {
            result = leftSequence;
            result.next = merge(leftSequence.next, rightSequence);
        }
        return result;
    }

    /**
     * Find size of double linked list
     * @param head head node of linked list
     * @return size
     */
    public static int sizeOfList(Node head) {

        Node temp = head;
        int i=0;
        while(temp.next != null) {
            temp = temp.next;
            ++i;
        }
        return i;
    }

    /**
     * Print sorted list
     * @param head head of list
     */
    public void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}