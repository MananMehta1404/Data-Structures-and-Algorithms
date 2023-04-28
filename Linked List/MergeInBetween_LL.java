import java.util.*;

public class MergeInBetween_LL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { 
            this.val = val; 
        }
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        List<Integer> l1 = new ArrayList<>();
        while(list1 != null){
            l1.add(list1.val);
            list1 = list1.next;
        }

        List<Integer> l2 = new ArrayList<>();
        while(list2 != null){
            l2.add(list2.val);
            list2 = list2.next;
        }

        while(a <= b){
            l1.remove(a);
            b--;
        }

        for(int i = l2.size() - 1; i >= 0; i--){
            l1.add(a, l2.get(i));
        }

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
        int[] arr1 = {0,1,2,3,4,5};
        int[] arr2 = {1000000,1000001,1000002};
        int a = 3, b = 4;

        ListNode list1 = new ListNode(arr1[0]);
        ListNode currNode = list1;
        for(int i = 1; i < arr1.length; i++){
            ListNode nextNode = new ListNode(arr1[i]);
            currNode.next = nextNode;
            currNode = nextNode;
        }

        ListNode list2 = new ListNode(arr2[0]);
        currNode = list2;
        for(int i = 1; i < arr2.length; i++){
            ListNode nextNode = new ListNode(arr2[i]);
            currNode.next = nextNode;
            currNode = nextNode;
        }

        ListNode result = mergeInBetween(list1, a, b, list2);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
