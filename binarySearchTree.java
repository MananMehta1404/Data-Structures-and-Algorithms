public class binarySearchTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Time Complexity: O(H) where H is the height of the BST
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            // Insert into left subtree
            root.left = insert(root.left, val);
        }
        else{
            // Insert into right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Inorder traversal of a BST gives a sorted increasing sequence.
    // Time Complexity: O(n)
    public static void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Time Complexity: O(H) where H is the height of the BST
    public static boolean searchBST(Node root, int val){
        if(root == null) return false;

        if(root.data == val) return true;

        if(root.data > val){
            // Search in the left subtree
            return searchBST(root.left, val);
        }
        // Search in the right subtree
        return searchBST(root.right, val);
    }

    // Inorder successor: Left most node in the right subtree.
    // Inorder successor always has 0 or 1 child.
    public static Node inOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    public static Node deleteNode(Node root, int val){
        if(root.data > val) root.left = deleteNode(root.left, val);
        else if(root.data < val) root.right = deleteNode(root.right, val);

        // If root.data == val
        else{
            // Case 1: Node has no child
            if(root.left == null && root.right == null) return null;
    
            // Case 2: Node has only one child
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
    
            // Case 3: Node has both the childs
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data); 
        }

        return root;
    }

    public static void main(String[] args) {
        int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < nodes.length; i++){
            root = insert(root, nodes[i]);
        }

        System.out.println("Root node is: " + root.data);
        System.out.print("Inorder traversal is: ");
        inOrder(root);
        System.out.println();
        // System.out.println(searchBST(root, 7));

        deleteNode(root, 4);
        System.out.print("Inorder traversal is: ");
        inOrder(root);
        System.out.println();
        deleteNode(root, 11);
        System.out.print("Inorder traversal is: ");
        inOrder(root);
        System.out.println();
        deleteNode(root, 5);
        System.out.print("Inorder traversal is: ");
        inOrder(root);

    }
    
}
