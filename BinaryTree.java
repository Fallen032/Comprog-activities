import java.util.InputMismatchException;
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

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(TreeNode root, int key) {
        if (root == null || root.data == key) {
            return root != null;
        }

        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    private TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = delete(root.right, root.data);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTree display = new BinaryTree();

        boolean rootInserted = false;

        while (!rootInserted) {
            try {
                System.out.print("Enter the value for the root node: ");
                int rootValue = input.nextInt();
                display.insert(rootValue);
                rootInserted = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                input.nextLine(); 
            }
        }

        while (true) {
            System.out.print("[1]Insert another value\n[2]Display inorder, preorder, postorder\n[3]Search\n[4]Delete\n[5]Exit\nChoice: ");
            int choice;

            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                input.nextLine(); 
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter another value: ");
                    try {
                        display.insert(input.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a valid integer.");
                        input.nextLine();
                    }
                    break;
                case 2:
                    System.out.print("Inorder: ");
                    display.inOrder();
                    System.out.print("\nPreorder: ");
                    display.preOrder();
                    System.out.print("\nPostorder: ");
                    display.postOrder();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter a number to search: ");
                    try {
                        int searchValue = input.nextInt();
                        if (display.search(searchValue)) {
                            System.out.println("Value found: " + searchValue);
                        } else {
                            System.out.println("Value is not found!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a valid integer.");
                        input.nextLine();
                    }
                    break;
                case 4:
                    System.out.print("Enter a value to delete: ");
                    try {
                        int deleteValue = input.nextInt();
                        display.root = display.delete(display.root, deleteValue);
                        System.out.println(deleteValue + " is deleted from the tree.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a valid integer.");
                        input.nextLine(); 
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}


   
