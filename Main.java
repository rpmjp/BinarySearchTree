import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the Tree: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        System.out.println("Enter the number to search in the Tree: ");
        int searchElement = scanner.nextInt();

        System.out.println("Enter an element to delete from the tree: ");
        int deleteValue = scanner.nextInt();

        if (tree.search(searchElement)) {
            System.out.println("\nValue " + searchElement + " found in the Tree.");
        } else {
            System.out.println("\nValue " + searchElement + " not found in the Tree.");
        }

        System.out.println("Inorder Traversal of the Tree: ");
        tree.inorderTraversal();

        System.out.println("\nPreorder Traversal of the Tree: ");
        tree.preorderTraversal();

        System.out.println("\nPostorder Traversal of the Tree: ");
        tree.postorderTraversal();

        tree.delete(deleteValue);
        System.out.println("\nInorder Traversal after deletion: ");
        tree.inorderTraversal();

        System.out.println("\nThis is the height of the tree: ");
        System.out.println(tree.height());

        scanner.close();
    }
}