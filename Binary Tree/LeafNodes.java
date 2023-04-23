package Binary_Tree;

import java.util.*;

public class LeafNodes {

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

    // Function to find the leaf nodes of a tree
    public static List<Integer> leafNodes(Node root){
        List<Integer> l1 = new ArrayList<>();
        if(root.left == null && root.right == null) {
            l1.add(root.data);
            return l1;
        }

        List<Integer> leftTree = new ArrayList<>();
        List<Integer> rightTree = new ArrayList<>();

        if(root.left != null) leftTree = leafNodes(root.left);
        if(root.right != null) rightTree = leafNodes(root.right);

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

        System.out.println("The leaf nodes of the tree are: " + leafNodes(root));
    }
}
