import java.util.ArrayList;

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

    // Function to print the nodes in the given range.
    public static void printInRange(Node root, int x, int y){
        if(root == null) return;
        if(root.data < x) printInRange(root.right, x, y);
        else if(root.data > y) printInRange(root.left, x, y);
        
        else if(root.data >= x && root.data <= y){
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    // Function to print all paths between root and leaf nodes.
    public static void printRootToLeaf(Node root, ArrayList<Integer> path){
        if(root == null) return;

        path.add(root.data);

        // Leaf Node
        if(root.left == null && root.right == null) printPath(path);
        // Non-leaf Node
        else{
            printRootToLeaf(root.left, path);
            printRootToLeaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < nodes.length; i++){
            root = insert(root, nodes[i]);
        }

        // System.out.println("Root node is: " + root.data);
        // System.out.print("Inorder traversal is: ");
        // inOrder(root);
        // System.out.println();
        // System.out.println(searchBST(root, 7));

        // deleteNode(root, 4);
        // System.out.print("Inorder traversal is: ");
        // inOrder(root);
        // System.out.println();
        // deleteNode(root, 11);
        // System.out.print("Inorder traversal is: ");
        // inOrder(root);
        // System.out.println();
        // deleteNode(root, 5);
        // System.out.print("Inorder traversal is: ");
        // inOrder(root);
        // System.out.println();
        // printInRange(root, 4, 10);

        printRootToLeaf(root, new ArrayList<>());

    }
    
}
