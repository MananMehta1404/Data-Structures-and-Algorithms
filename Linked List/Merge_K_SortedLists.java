import java.util.*;
public class Merge_K_SortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        List<Integer> l1 = new ArrayList<Integer>();

        for(int i = 0; i < lists.length; i++){
            ListNode curr = lists[i];
            while(curr != null){
                l1.add(curr.val);
                curr = curr.next;
            }
        }

        Collections.sort(l1);

        if(l1.size() == 0 && lists[0] == null) return lists[0];
        ListNode result = new ListNode(l1.get(0));
        ListNode currNode = result;
        for(int i = 1; i < l1.size(); i++){
            ListNode nextNode = new ListNode(l1.get(i));
            currNode.next = nextNode;
            currNode = nextNode;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        lists[2].next.next = new ListNode(7);

        ListNode result = mergeKLists(lists);

        // Print the result
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
