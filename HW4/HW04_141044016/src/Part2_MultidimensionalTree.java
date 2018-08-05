import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yagmur on 11.04.2018.
 */
public class Part2_MultidimensionalTree extends BinaryTree_Part2 {

    public static class Node implements Serializable {
        protected ArrayList<Integer> data;
        protected Node left;
        protected Node right;

        /**
         * Node constructor
         * @param data data of node
         */
        public Node (ArrayList<Integer> data) {
            this.data = data;
            right = null;
            left = null;
        }
    }
    public Node root;
    private int dimension;

    /**
     * Default constructor
     */
    public Part2_MultidimensionalTree() {

        dimension=3;
        root = null;
    }

    /**
     * Constructor
     * @param dimension dimension of node
     */
    public Part2_MultidimensionalTree(int dimension) {
        this.dimension=dimension;
    }

    /**
     * Helper method of add method
     * @param node node of tree
     * @return root node of tree
     */
    public Node addHelper(ArrayList<Integer> node) {

        ArrayList<Integer> dimen = new ArrayList<>();
        for(int i=0; i<dimension; ++i)
            dimen.add(i);

        root = add(root, node, dimen, 0);

        return root;
    }

    /**
     * Aaa the node to tree, if root is null, added to root. Otherwise, search the tree and add the node
     * @param root root of tree
     * @param node node for add
     * @param dimen arraylist of dimension, if dimension is 3, dimen array is 0,1,2
     * @param index flag for add method
     * @return root of tree
     */
    public Node add(Node root, ArrayList<Integer> node, ArrayList<Integer> dimen, int index) {

        if(root == null) {
            root = new Node(node);
            return root;
        }
        if(index != 0)
            dimen.remove(0);

        if(dimen.size() == 0){
            for(int i=0; i<node.size(); ++i)
                dimen.add(i);
        }
        if ((node.get(dimen.get(0))) <= root.data.get(dimen.get(0))) {
            root.left = add(root.left, node, dimen, 1);
        }
        else if (node.get(dimen.get(0)) > root.data.get(dimen.get(0))) {
            root.right = add(root.right, node, dimen, 1);
        }
        return root;
    }

    /**
     * Print the node, left of node and right of node
     * @param node node for print
     */
    public void printNode(ArrayList<Integer> node) {

        Node found = levelOrderTraversal(node);

        if(found != null) {
            System.out.println("Found: " + found.data);
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
     * Level order traverse for search a node
     * @param node node for search
     * @return node, if node in tree. otherwise return null
     */
    public Node levelOrderTraversal(ArrayList<Integer> node) {

        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node tempNode=queue.poll();

            if(node.equals(tempNode.data))
                return tempNode;

            if(tempNode.left!=null)
                queue.add(tempNode.left);

            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }
        return null;
    }
}