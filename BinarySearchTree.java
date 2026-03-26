public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = recursiveInsert(root, value);
    }

    private Node recursiveInsert(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

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
        if (current == null) {
            return null;
        }

        if (value < current.value) {
            current.left = recursiveDelete(current.left, value);
        } else if (value > current.value) {
            current.right = recursiveDelete(current.right, value);
        } else {
            // Node with only one child or no child
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            current.value = minValue(current.right);

            // Delete the inorder successor
            current.right = recursiveDelete(current.right, current.value);
        }
        return current;
    }

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
            return -1; // Height of an empty tree is -1
        }
        int leftHeight = recursiveHeight(node.left);
        int rightHeight = recursiveHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
