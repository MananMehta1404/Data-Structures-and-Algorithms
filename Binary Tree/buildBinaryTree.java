import java.util.*;

public class buildBinaryTree{
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

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1) return null;
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
        }
    }

    public static int countOfNodes(Node root){
        if(root == null) return 0;
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root){
        if(root == null) return 0;
        int sumLeftNodes = sumOfNodes(root.left);
        int sumRightNodes = sumOfNodes(root.right);
        return sumLeftNodes + sumRightNodes + root.data;
    }

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

    // Function to find the leaf nodes of a tree
    public static List<Integer> leafNodes(Node root){
        List<Integer> l1 = new ArrayList<>();
        if(root.left == null && root.right == null) {
            l1.add(root.data);
            return l1;
        }

        List<Integer> leftTree = leafNodes(root.left);
        List<Integer> rightTree = leafNodes(root.right);

        for(int i = 0; i < leftTree.size(); i++){
            l1.add(leftTree.get(i));
        }

        for(int i = 0; i < rightTree.size(); i++){
            l1.add(rightTree.get(i));
        }

        return l1;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);
        // System.out.println(root.data);
        // System.out.print("Preorder Traversal: ");
        // preOrder(root);
        // System.out.println("");
        // System.out.print("Inorder Traversal: ");
        // inOrder(root);
        // System.out.println("");
        // System.out.print("Postorder Traversal: ");
        // postOrder(root);
        // System.out.println("");
        // System.out.println("Levelorder Traversal: ");
        // levelOrder(root);
        // System.out.println("");
        System.out.println("Count of nodes is: " + countOfNodes(root));
        System.out.println("Sum of nodes is: " + sumOfNodes(root));
        System.out.println("Height of tree is: " + heightOfTree(root));
        System.out.println("Diameter of tree is: " + diameterOfTree(root));
        System.out.println("Diameter of tree is: " + diameter(root).diam);
    }
}