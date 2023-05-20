import java.util.*;

public class Zigzag_Levelorder {

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

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> l1 = new ArrayList<List<Integer>>();

        if(root == null) return l1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> l2 = new ArrayList<>();

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                if(l1.size() % 2 == 0) l1.add(l2);
                else {
                    Collections.reverse(l2);
                    l1.add(l2);
                }
                l2 = new ArrayList<Integer>();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                l2.add(currNode.data);
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
        }

        return l1;
    }

    public static void main(String[] args) {
        int nodes[] = {3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1};
        Node root = BinaryTree.buildTree(nodes);

        System.out.print("Zigzag levelorder traversal is: " + zigzagLevelOrder(root));
    }
}
