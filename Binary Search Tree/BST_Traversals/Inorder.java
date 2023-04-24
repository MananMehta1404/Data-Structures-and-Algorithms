package BST_Traversals;

public class Inorder {

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

    // Inorder successor: Left most node in the right subtree.
    // Inorder successor always has 0 or 1 child.
    public static Node inOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    // Function to delete the node with given value.
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

    // Inorder traversal of a BST gives a sorted increasing sequence.
    // Time Complexity: O(n)
    public static void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < nodes.length; i++){
            root = insert(root, nodes[i]);
        }
        
        System.out.print("Inorder traversal is: ");
        inOrder(root);
    }
}
