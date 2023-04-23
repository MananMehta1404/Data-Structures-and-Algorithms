package Basic_Operations;
public class InsertNode {
    
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

    public static void main(String[] args) {
        int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < nodes.length; i++){
            root = insert(root, nodes[i]);
        }

        System.out.println("Root node is: " + root.data);
    }
}
