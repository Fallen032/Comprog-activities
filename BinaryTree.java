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

    public void insert(int value) {
        root = insert(root, value);
    }

    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
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
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTree display = new BinaryTree();

        System.out.print("Enter the size of the tree: ");
        int size = input.nextInt();

        for (int i = 0; i < size; i++) {
            System.out.print("Enter the value for each node: ");
            int node = input.nextInt();
            display.insert(node);
        }

        System.out.print("\n[1]Display inorder,preorder,postorder\n[2]Search\n[3]Delete\n[4]Exit\nChoice: ");
        int choices = input.nextInt();
        
        switch(choices){
         case 1:
         System.out.print("inorder: ");
         display.inOrder();
         System.out.print("\npreorder: ");
         display.preOrder();
         System.out.print("\npostorder: ");
         display.postOrder();
         break;
         case 2:
        }
    }
}

   
