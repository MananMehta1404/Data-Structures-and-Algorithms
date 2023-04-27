import java.util.*;

public class BTFrom_In_Post {

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

    public static void postOrder(Node root){
        if(root == null) return;
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static Node constructTree(List<Integer> inorder, List<Integer> postorder) {
        if(postorder.size() == 0) return null;
        else if(postorder.size() == 1) return new Node(postorder.get(0));

        Node root = new Node(postorder.get(postorder.size() - 1));
        int idx = inorder.indexOf(postorder.get(postorder.size() - 1));

        List<Integer> leftInorder = new ArrayList<>();
        for(int i = 0; i < idx; i++) leftInorder.add(inorder.get(i));
        List<Integer> rightInorder = new ArrayList<>();
        for(int i = idx + 1; i < inorder.size(); i++) rightInorder.add(inorder.get(i));

        List<Integer> leftPostorder = new ArrayList<>();
        List<Integer> rightPostorder = new ArrayList<>();
        for(int i = 0; i < postorder.size() - 1; i++) {
            if(i < leftInorder.size()) leftPostorder.add(postorder.get(i));
            else rightPostorder.add(postorder.get(i));
        }

        root.left = constructTree(leftInorder, leftPostorder);
        root.right = constructTree(rightInorder, rightPostorder);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        for(int i = 0; i < inorder.length; i++) in.add(inorder[i]);
        for(int i = 0; i < postorder.length; i++) post.add(postorder[i]);

        Node root = constructTree(in, post);

        inOrder(root);
        System.out.println();
        postOrder(root);
    }
}
