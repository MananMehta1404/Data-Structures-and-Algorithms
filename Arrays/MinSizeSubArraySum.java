public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;

        int n = nums.length;

        int minSize = (int)(1e9);

        int sum = 0;
        int len = 0;
        int j = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            len++;

            if(sum >= target) {
                while(sum - nums[j] >= target) {
                    sum -= nums[j];
                    len--;
                    j++;
                }
                minSize = Math.min(minSize, len);
            }
        }

        if(minSize == (int)1e9) minSize = 0;

        System.out.println(minSize);
    }
}
