package binarySearch;

/**
 * Binary Search Tree implementation.
 *
 * This class represents a binary search tree (BST) where each node contains a key-value pair.
 * The keys are comparable, allowing for efficient searching, insertion, and deletion operations.
 *
 * INVARIANT: The left subtree of a node contains only nodes with keys less than the root's key,
 * and right subtree contains only nodes with keys greater than the root's key.
 *
 * @param <Key>   The type of keys in the BST, which must implement Comparable.
 * @param <Value> The type of values associated with the keys in the BST.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    public BinarySearchTree(Node root){
        this.root = root;
    }

    private Node root;

    public Node get(Key key) {
        while (root.key != null) {
            int cmp = key.compareTo((Key) root.key);
            if (cmp < 0) {
                root = root.left;
            } else if (cmp > 0) {
                root = root.right;
            } else {
                return root; // Key found
            }
        }
        return null;
    }



}
