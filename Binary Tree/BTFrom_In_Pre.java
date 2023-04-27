import java.util.*;

public class BTFrom_In_Pre {

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

    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(Node root){
        if(root == null) return;

        System.out.print(root.data + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node constructTree(List<Integer> inorder, List<Integer> preorder) {
        if(preorder.size() == 0) return null;
        else if(preorder.size() == 1) return new Node(preorder.get(0));

        Node root = new Node(preorder.get(0));
        int idx = inorder.indexOf(preorder.get(0));

        List<Integer> leftInorder = new ArrayList<>();
        for(int i = 0; i < idx; i++) leftInorder.add(inorder.get(i));
        List<Integer> rightInorder = new ArrayList<>();
        for(int i = idx + 1; i < inorder.size(); i++) rightInorder.add(inorder.get(i));

        List<Integer> leftPreorder = new ArrayList<>();
        List<Integer> rightPreorder = new ArrayList<>();
        for(int i = 1; i < preorder.size(); i++) {
            if(i <= leftInorder.size()) leftPreorder.add(preorder.get(i));
            else rightPreorder.add(preorder.get(i));
        }

        root.left = constructTree(leftInorder, leftPreorder);
        root.right = constructTree(rightInorder, rightPreorder);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};

        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();

        for(int i = 0; i < inorder.length; i++) in.add(inorder[i]);
        for(int i = 0; i < preorder.length; i++) pre.add(preorder[i]);

        Node root = constructTree(in, pre);

        inOrder(root);
        System.out.println();
        preOrder(root);
    }
}
