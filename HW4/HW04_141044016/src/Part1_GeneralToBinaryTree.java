import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yagmur on 10.04.2018.
 */
public class Part1_GeneralToBinaryTree<E> extends BinaryTree_Part1<E> {

    /**
     * Default constructor
     */
    public Part1_GeneralToBinaryTree() {
        root = null;
    }

    /**
     * Add method, if root is null, parent item added to root and child item added to left of root.
     * İf root is not null, search the parent item, if left of parent item is null, add the child item left of parent.
     * Else add the child item right of the first child.
     * If parent item is not in tree, return false
     * @param parentItem parent item
     * @param childItem child item
     * @return true if child added, else return false
     */
    public boolean add(E parentItem, E childItem) {

        if(root == null) {
            root = new Node<E>(parentItem);
            root.left = new Node<E>(childItem);
            return true;
        }
        else {
            Node<E> temp = root;
            Node found = levelOrderSearch(parentItem, temp);
            if (found != null) {
                if (found.left == null) {
                    found.left = new Node<E>(childItem);
                    //System.out.println("İF left: " + found.left.data);
                    return true;
                } else {
                    Node<E> temp1 = found.left;
                    while (temp1.right != null)
                        temp1 = temp1.right;

                    temp1.right = new Node<E>(childItem);
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * Level order search in tree
     * @param parentItem parent item
     * @param root root of tree
     * @return node if in tree, null if node is not in tree
     */
    public Node<E> levelOrderSearch(E parentItem, Node<E> root) {

        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node tempNode=queue.poll();
            if(parentItem.equals(tempNode.data))
                return tempNode;

            if(tempNode.left!=null)
                queue.add(tempNode.left);

            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }
        return null;
    }

    /**
     * Post order search in tree
     * @param parentItem parent item
     * @param root root of tree
     * @return parent item if it is in tree, null if parent item is not in tree
     */
    public Node<E> postOrderSearch(E parentItem, Node<E> root) {
        if(root !=  null) {
            postOrderSearch(parentItem, root.left);
            postOrderSearch(parentItem, root.right);

            if(root.data.equals(parentItem))
                return root;
        }
        return null;
    }

    /**
     * Find node of data and print data of node, data of left node of root and data of right node of root.
     * @param data data of node
     */
    public void toString(E data) {

        Node<E> temp = root;
        Node<E> found = levelOrderSearch(data, temp);

        if(found != null) {
            System.out.println("Node: " + found.data);
            if(found.left != null)
                System.out.println("Left: " + found.left.data);

            else
                System.out.println("Left: null");

            if(found.right != null)
                System.out.println("Right: " + found.right.data);

            else
                System.out.println("Right: null");
        }
        System.out.println("--------------------------------------------------");
        return;
    }

    /**
     * Helper method of preOrderTraverse method
     */
    public void helperPreOrder() {
        Node<E> node = root;
        System.out.println("My PreOrderTraverse:");
        preOrderTraverse(node);
    }

    /**
     * Pre order traverse method for tree
     * @param root root of tree
     */
    public void preOrderTraverse(Node<E> root) {
        if(root !=  null) {
            //Visit the node by Printing the node data
            System.out.print(root.data + " -> ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }
}
