public class FindTheTarget {

    // Iterative Approach
    public static int findTarget(int[] nums, int target) {
        int n = nums.length;

        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    // Recursive Approach
    public static int findTarget(int[] nums, int target, int low, int high) {
        if(low > high) return -1;

        int mid = (low + high) / 2;

        if(nums[mid] == target) return mid;
        else if(nums[mid] < target) return findTarget(nums, target, mid + 1, high);
        else return findTarget(nums, target, low, mid - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 6, 7, 8, 9, 10 };
        int n = nums.length;
        int target = 3;

        // Time Complexity: O(logn)
        System.out.println("The target is at index: " + findTarget(nums, target));
        System.out.println("The target is at index: " + findTarget(nums, target, 0, n - 1));
    }
}