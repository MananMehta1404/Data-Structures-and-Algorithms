public class BST_From_Sorted_Array {

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

    public static Node createBST(int[] nums, int low, int high) {
        if(low > high) return null;

        int rootIdx = (low + high) / 2;
        
        Node root = new Node(nums[rootIdx]);

        root.left = createBST(nums, low, rootIdx - 1);
        root.right = createBST(nums, rootIdx + 1, high);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        
        Node root = createBST(arr, 0, arr.length - 1);
        inOrder(root);
    }
}
