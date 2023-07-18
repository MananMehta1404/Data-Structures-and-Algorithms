import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Window_Maximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            // Remove numbers out of range k
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            // Remove smaller numbers in k range as they are useless
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // Store the element
            dq.offer(i);
            
            // When the subarray starts store the maximum
            if (i >= k - 1) {
                ans[idx++] = nums[dq.peek()];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        int[] ans = maxSlidingWindow(arr, k);
        
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
