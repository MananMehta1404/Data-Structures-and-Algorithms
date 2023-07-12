import java.util.Arrays;

public class MaxNoOf_K_SumPairs {
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;

        while(i < j) {
            if(nums[i] + nums[j] == k) {
                i++;
                j--;
                count++;
            }
            else if(nums[i] + nums[j] < k) i++;
            else j--;
        }

        return count;
   }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, 1 };
        int k = 6;
        
        System.out.println(maxOperations(arr, k));
    }
}
