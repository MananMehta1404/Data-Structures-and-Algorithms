public class Increasing_Triplet_Subsequence {

    public static boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > mid) return true;
            else if(nums[i] > left) mid = nums[i];
            else if(nums[i] < left) left = nums[i];
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3};

        boolean ans = increasingTriplet(nums);

        System.out.println(ans);
    }
}
