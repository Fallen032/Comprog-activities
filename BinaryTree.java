import java.util.Scanner;

public class BinaryTree {

    private TreeNode root;

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public BinaryTree() {
        // Constructor can be left empty for user input
    }

    // Method to insert a new node into the binary tree
    private TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Method to take user input for building the binary tree
    public void buildTree() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes in the binary tree:");
        int numNodes = scanner.nextInt();

        System.out.println("Enter the values of the nodes, one by one:");
        for (int i = 0; i < numNodes; i++) {
            int data = scanner.nextInt();
            root = insert(root, data);
        }
    }

    // Method to display the binary tree using inorder traversal
    private void display(TreeNode root) {
        if (root != null) {
            display(root.left);
            System.out.print(root.data + " ");
            display(root.right);
        }
    }

    public void displayTree() {
        System.out.print("Binary Tree (Inorder Traversal): ");
        display(root);
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.buildTree();
        binaryTree.displayTree();
    }
}
   