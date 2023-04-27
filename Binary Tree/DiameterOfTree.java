public class DiameterOfTree {

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

    // Time Complexity: O(n^2)
    public static int diameterOfTree(Node root){
        if(root == null) return 0;
        int leftMaxDiameter = diameterOfTree(root.left);
        int rigthMaxDiameter = diameterOfTree(root.right);
        int rootDiameter = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(Math.max(leftMaxDiameter, rigthMaxDiameter), rootDiameter);
    }

    // Alternate Approach  Time Complexity: O(n)
    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter(Node root){
        if(root == null) return new TreeInfo(0, 0);

        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int myDiam = Math.max(Math.max(diam2, diam1), diam3);

        TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
        return myInfo;
    }


    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);

        System.out.println("Diameter of tree is: " + diameterOfTree(root));
        System.out.println("Diameter of tree is: " + diameter(root).diam);
    }
}
