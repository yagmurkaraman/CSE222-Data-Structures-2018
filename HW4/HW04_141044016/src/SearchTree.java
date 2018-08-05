/**
 * Created by yagmur on 14.04.2018.
 */
public interface SearchTree<E> {

    /**
     * Inserts item where it belongs in the tree. Returns true
     * if item is inserted; false if it isn't (already in tree).
     * @param item data of node
     * @return true or false
     */
    boolean add(E item);

    /**
     * Returns true if target is found in the tree.
     * @param target data of target node
     * @return true or false
     */
    boolean contains(E target);

    /**
     * Returns a reference to the data in the node that is equal to target.
     * If no such node is found, returns null.
     * @param target data of target node
     * @return data of found node
     */
    E find(E target);

    /**
     * Removes target (if found) from tree and returns it; otherwise, return null.
     * @param target data of target node
     * @return data of deleted node
     */
    E delete(E target);

    /**
     * Removes target (if found) from tree and returns true; otherwise, return false.
     * @param target data of target node
     * @return true or false
     */
    boolean remove(E target);

}
