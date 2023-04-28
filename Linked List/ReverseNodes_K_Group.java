import java.util.*;

public class ReverseNodes_K_Group {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        List<Integer> l1 = new ArrayList<>();
        while(head != null){
            l1.add(head.val);
            head = head.next;
        }

        int rem = l1.size() % k;
        for(int i = 0; i < l1.size() - rem; i++){
            List<Integer> l2 = new ArrayList<>();
            for(int j = i; j < i + k; j++){
                l2.add(l1.get(j));
            }
            Collections.reverse(l2);
            for(int j = 0; j < l2.size(); j++){
                l1.set(i, l2.get(j));
                if(j != l2.size() - 1) i += 1;
            }
        }

        ListNode result = new ListNode(l1.get(0));
        if(l1.size() == 1) return result;
        ListNode currNode = result;
        for(int i = 1; i < l1.size(); i++){
            ListNode nextNode = new ListNode(l1.get(i));
            currNode.next = nextNode;
            currNode = nextNode;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode currNode = list1;
        for(int i = 2; i <= 5; i++){
            ListNode nextNode = new ListNode(i);
            currNode.next = nextNode;
            currNode = nextNode;
        }

        int k = 2;
        ListNode result = reverseKGroup(list1, k);

        // Print result
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
