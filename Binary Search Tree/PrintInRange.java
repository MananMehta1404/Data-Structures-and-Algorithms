public class PrintInRange {
    
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

    public static void main(String[] args) {
        int nodes[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < nodes.length; i++){
            root = insert(root, nodes[i]);
        }

        System.out.println("Nodes in the range 4 to 10 are: ");
        printInRange(root, 4, 10);
    }
}
