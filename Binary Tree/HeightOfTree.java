public class HeightOfTree {

    // Class to define the node structure of a binary tree
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

    // Class to build the binary tree
    static class BinaryTree{
        static int idx = -1;

        // Function to build the binary tree
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // Function to calculate the height of a binary tree
    public static int heightOfTree(Node root){
        if(root == null) return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);

        System.out.println("The height of the binary tree is: " + heightOfTree(root));
    }
    
}
