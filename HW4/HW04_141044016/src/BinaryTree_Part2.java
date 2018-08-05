import java.io.Serializable;

/**
 * Created by yagmur on 11.04.2018.
 */
public class BinaryTree_Part2<E extends Comparable<E>> implements SearchTree{

    public static class Node<E> implements Serializable {
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        /**
         * Node constructor
         * @param data data of node
         */
        public Node (E data) {
            this.data = data;
            right = null;
            left = null;
        }
    }
    public Node<E> root;
    protected boolean addReturn;
    protected E deleteReturn;

    /**
     * BinaryTree_Part2 constructor
     */
    public BinaryTree_Part2() {
        root = null;
    }

    /**
     * BinaryTree_Part2 constructor
     * @param root root of tree
     */
    public BinaryTree_Part2(Node<E> root) {
        this.root = root;
    }

    /**
     * BinaryTree_Part2 constructor
     * @param data data of node
     * @param leftTree left tree of tree
     * @param rightTree right tree of tree
     */
    public BinaryTree_Part2(E data, BinaryTree_Part2<E> leftTree,
                            BinaryTree_Part2<E> rightTree) {
        root = new Node<E>(data);
        if(leftTree!= null)
            root.left = leftTree.root;
        else
            root.left = null;

        if(rightTree!= null)
            root.right = leftTree.root;
        else
            root.right = null;
    }

    /**
     * Helper method of find method, call find method
     * @param target data of target node
     * @return object of finded node
     */
    public Object find(Object target) {
        return find(root, target);
    }

    /**
     * Find method that finds target node
     * @param localRoot root of tree
     * @param target target node for find
     * @return data of found target node, if root is null return null
     */
    private E find(Node<E> localRoot, Object target) {
        if(localRoot == null)
            return null;

        int compResult=0;
        if(compResult == 0)
            return localRoot.data;

        else if(compResult<0)
            return find(localRoot.left, target);

        else
            return find(localRoot.right, target);
    }

    /**
     * Helper method of add method
     * @param item item for add
     * @return addReturn true or false
     */
    public boolean add(Object item) {
        root=add(root, item);
        return addReturn;
    }

    /**
     * Add item to tree
     * @param localRoot root of tree
     * @param item item for add
     * @return added node
     */
    public Node<E> add(Node<E> localRoot, Object item) {
        if(localRoot == null) {
            addReturn = true;
            return new Node<E>(((E)item));
        }
        else if(((E)item).compareTo(localRoot.data) == 0) {
            addReturn = false;
            return localRoot;
        }
        else if(((E)item).compareTo(localRoot.data) < 0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        }
        else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    /**
     * Helper method for delete
     * @param target data of target node
     * @return object of deleted node
     */
    public Object delete(Object target) {
        root = delete(root, target);
        return deleteReturn;
    }
    public Node<E> delete(Node<E> localRoot, Object item) {
        if(localRoot == null) {
            deleteReturn = null;
            return localRoot;
        }
        int compResult = 0;
        if(compResult < 0) {
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }
        else if(compResult > 0) {
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
        else {
            deleteReturn = localRoot.data;
            if(localRoot.left == null)
                return localRoot.right;

            else if(localRoot.right == null)
                return localRoot.left;

            else {
                if(localRoot.left.right == null) {
                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }
                else {
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    /**
     * Find largest child of parent
     * @param parent parent node
     * @return data of largest child
     */
    private E findLargestChild(Node<E> parent) {
        if(parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }
        else
            return findLargestChild(parent.right);
    }
    /**
     * Find an item in the tree.
     * @param target the item to search for.
     * @return true if not found.
     */
    public boolean contains(Object target) {
        return contains(target, root);
    }
    /**
     * Internal method to find an item in a subtree.
     * @param target is item to search for.
     * @param node the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains(Object target, Node<E> node)
    {
        if(node == null)
            return false;

        int compareResult = 0;

        if( compareResult < 0 )
            return contains(target, node.left);

        else if( compareResult > 0 )
            return contains(target, node.right);

        else
            return true;
    }
    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param target the item to remove.
     */
    public boolean remove(Object target) {
        if(root == null)
            return false;

        root = remove(target, root);
        return true;
    }
    /**
     * Internal method to remove from a subtree.
     * @param target the item to remove.
     * @param node the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private Node<E> remove(Object target, Node<E> node) {

        if(node == null)
            return node;

        int compareResult = 0;

        if(compareResult < 0)
            node.left = remove(target, node.left);

        else if(compareResult > 0)
            node.right = remove(target, node.right);

        else if(node.left != null && node.right != null) // Two children
        {
            node.data = findMin(node.right).data;
            node.right = remove(node.data, node.right);
        }
        else
            node = (node.left != null) ? node.left : node.right;
        return node;
    }
    /**
     * Internal method to find the smallest item in a subtree.
     * @param node the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private Node<E> findMin(Node<E> node) {
        if(node == null)
            return null;

        else if(node.left == null)
            return node;

        return findMin(node.left);
    }

    /**
     * Get left tree of tree
     * @return tree
     */
    public BinaryTree_Part2<E> getLeftSubtree() {
        if(root != null && root.left != null)
            return new BinaryTree_Part2<E>(root.left);

        else
            return null;
    }
    /**
     * Get right tree of tree
     * @return tree
     */
    public BinaryTree_Part2<E> getRightSubtree() {
        if(root != null && root.right != null)
            return new BinaryTree_Part2<E>(root.right);

        else
            return null;
    }

    /**
     * Checks tree is leaf or not
     * @return true or false
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    /**
     * Override the toString method, call preOrderTraverse method
     * @return string representation of tree
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root,1,sb);
        return sb.toString();
    }

    /**
     * Traverse the tree as pre order and prints nodes
     * @param node root of tree
     * @param depth total level of tree
     * @param sb StringBuilder
     */
    private void preOrderTraverse(Node<E> node, int depth,
                                  StringBuilder sb) {
        for(int i=1; i<depth; ++i) {
            sb.append(" ");
        }
        if(node == null) {
            sb.append("null\n");
        }
        else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth+1, sb);
            preOrderTraverse(node.right, depth+1, sb);
        }
    }

}
