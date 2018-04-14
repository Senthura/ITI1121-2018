/**
*  @author Marcel Turcotte
*/

import java.util.NoSuchElementException;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;
        private Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node<E> root = null;

    /**
    * Inserts an object into this BinarySearchTree.
    *
    * @param elem item to be added
    * @return true if the object has been added and false otherwise
    */

    public boolean add(E elem) {

        // pre-condtion:

        if (elem == null) {
            throw new NullPointerException();
        }

        // special case:

        if (root == null) {
            root = new Node<E>(elem);
            return true;
        }

        // general case:

        return add(elem, root);
    }

    private boolean add(E elem, Node<E> current) {

        boolean result;
        int test = elem.compareTo(current.value);

        if (test == 0) {
            result = false; // already exists, not added
        } else if (test < 0) {
            if (current.left == null) {
                current.left = new Node<E>(elem);
                result = true;
            } else {
                result = add(elem, current.left);
            }
        } else {
            if (current.right == null) {
                current.right = new Node<E>(elem);
                result = true;
            } else {
                result = add(elem, current.right);
            }
        }
        return result;
    }

    public int count(E low, E high) {

        if (low == null || high == null) {
            throw new NullPointerException();
        }

        if (low.compareTo(high)>0) {
            throw new IllegalArgumentException();
        }

        return count(root, low, high);
    }

    private int count(Node<E> current, E low, E high) {
        int count = 0;
        if (current != null) {
            boolean greather = current.value.compareTo(low)>=0;
            boolean less = current.value.compareTo(high)<=0;
            if (greather && less) {
                count++;
            }
            if (current.left != null && greather) {
                count = count + count(current.left, low, high);
            }
            if (current.right != null && less) {
                count = count + count(current.right, low, high);
            }
        }
        return count;
    }

    // Non-recursive solution. Here, a stack is used to keep track of the unprocessed
    // (opened) nodes. The stack could be replaced by a queue since the order for
    // visiting the nodes is not important. Here, I am using java.util.Stack.

    public int countIter(E low, E high) {

        if (low == null || high == null) {
            throw new NullPointerException();
        }

        if (low.compareTo(high)>0) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        if (root != null) {
            Stack<Node<E>> open = new Stack<Node<E>>();
            open.push(root);
            while (! open.isEmpty()) {
                Node<E> current = open.pop();
                boolean greather = current.value.compareTo(low)>=0;
                boolean less = current.value.compareTo(high)<=0;
                if (greather && less) {
                    count++;
                }
                if (current.left != null && greather) {
                    open.push(current.left);
                }
                if (current.right != null && less) {
                    open.push(current.right);
                }
            }
        }
        return count;
    }

    public String toString() {
        return toString(root);
    }

    private String toString(Node<E> current) {

        if (current == null) {
            return "()";
        }

        return "(" + toString(current.left) + current.value + toString(current.right) + ")";
    }

}
