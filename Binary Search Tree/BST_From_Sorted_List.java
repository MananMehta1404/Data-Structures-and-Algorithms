import java.util.List;

public class BST_From_Sorted_List {

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

    public static Node createBST(List<Integer> l1, int low, int high) {
        if(low > high) return null;

        int rootIndex = (low + high) / 2;
        Node root = new Node(l1.get(rootIndex));

        root.left = createBST(l1, low, rootIndex - 1);
        root.right = createBST(l1, rootIndex + 1, high);

        return root;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        Node root = createBST(list, 0, list.size() - 1);
        inOrder(root);
    }
}
