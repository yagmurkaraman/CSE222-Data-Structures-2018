import java.io.Serializable;

/**
 * Created by yagmur on 11.04.2018.
 */
public class BinaryTree_Part1<E> {

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
        public String toString() {
            return data.toString();
        }
    }
    public Node<E> root;

    /**
     * BinaryTree_Part1 constructor
     */
    public BinaryTree_Part1() {
        root = null;
    }

    /**
     * BinaryTree_Part1 constructor
     * @param root root node of tree
     */
    public BinaryTree_Part1(Node<E> root) {
        this.root = root;
    }

    /**
     * BinaryTree_Part1 constructor
     * @param data data of node
     * @param leftTree left tree of tree
     * @param rightTree right tree of tree
     */
    public BinaryTree_Part1(E data, BinaryTree_Part1<E> leftTree,
                            BinaryTree_Part1<E> rightTree) {
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
     * Get left tree of tree
     * @return tree
     */
    public BinaryTree_Part1<E> getLeftSubtree() {
        if(root != null && root.left != null)
            return new BinaryTree_Part1<E>(root.left);

        else
            return null;
    }
    /**
     * Get right tree of tree
     * @return tree
     */
    public BinaryTree_Part1<E> getRightSubtree() {
        if(root != null && root.right != null)
            return new BinaryTree_Part1<E>(root.right);

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
