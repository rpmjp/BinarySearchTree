public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = recursiveInsert(root, value);
    }

    private Node recursiveInsert(Node current, int value) {
        // hit an empty spot, put the new node here
        if (current == null) {
            return new Node(value);
        }

        // go left if smaller, right if bigger
        if (value < current.value) {
            current.left = recursiveInsert(current.left, value);
        } else if (value > current.value) {
            current.right = recursiveInsert(current.right, value);
        }

        return current;
    }

    public boolean search(int value) {
        Node result = recursiveSearch(root, value);
        if (result != null) {
            return true;
        } else {
            return false;
        }
    }

    // returns the node if found, null if not
    private Node recursiveSearch(Node current, int value) {
        if (current == null || current.value == value) {
            return current;
        }

        if (value < current.value) {
            return recursiveSearch(current.left, value);
        } else {
            return recursiveSearch(current.right, value);
        }
    }

    // prints inorder: left, root, right
    public void inorderTraversal() {
        if (root == null) {
            System.out.println("Empty");
            return;
        }
        recursiveInorder(root);
    }

    private void recursiveInorder(Node node) {
        if (node != null) {
            recursiveInorder(node.left);
            System.out.print(node.value + " ");
            recursiveInorder(node.right);
        }
    }

    // prints postorder: left, right, root
    public void postorderTraversal() {
        if (root == null) {
            System.out.println("Empty");
            return;
        }
        recursivePostorder(root);
    }

    private void recursivePostorder(Node node) {
        if (node != null) {
            recursivePostorder(node.left);
            recursivePostorder(node.right);
            System.out.print(node.value + " ");
        }
    }

    // prints preorder: root, left, right
    public void preorderTraversal() {
        if (root == null) {
            System.out.println("Empty");
            return;
        }
        recursivePreorder(root);
    }

    private void recursivePreorder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            recursivePreorder(node.left);
            recursivePreorder(node.right);
        }
    }

     public void delete(int value) {
        root = recursiveDelete(root, value);
     }

    private Node recursiveDelete(Node current, int value) {
        // base case - value isn't in the tree
        if (current == null) {
            return null;
        }

        // navigate left or right to find the node
        if (value < current.value) {
            current.left = recursiveDelete(current.left, value);
        } else if (value > current.value) {
            current.right = recursiveDelete(current.right, value);
        } else {
            // found it - now handle the 3 cases
            // if theres no left child just replace with right (also covers leaf)
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // has both children so we swap with the smallest on the right
            current.value = minValue(current.right);
            // then remove that value from the right subtree
            current.right = recursiveDelete(current.right, current.value);
        }
        return current;
    }

    // goes all the way left to find the smallest value
    private int minValue(Node node) {
        int minv = node.value;
        while (node.left != null) {
            minv = node.left.value;
            node = node.left;
        }
        return minv;
    }

    public int height() {
        return recursiveHeight(root);
    }

    private int recursiveHeight(Node node) {
        if (node == null) {
            return -1; // empty tree is -1 per the assignment
        }
        int leftHeight = recursiveHeight(node.left);
        int rightHeight = recursiveHeight(node.right);
        // take the bigger side and add 1 for current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
