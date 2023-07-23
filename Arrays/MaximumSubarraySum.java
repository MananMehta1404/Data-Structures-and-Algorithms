public class MaximumSubarraySum {

    // Kadane's Algorithm
    public static int maxSubArray(int[] nums){
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(max < sum) max = sum;
            if(sum < 0) sum = 0;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(maxSubArray(arr));
    }
}
