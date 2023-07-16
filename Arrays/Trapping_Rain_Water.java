public class Trapping_Rain_Water {

    // Time Complexity: 3*O(N)
    // Space Complexity: 2*O(N)
    public static int trap1 (int[] height) {
        int n = height.length;

        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = height[0];
        suffixSum[n - 1] = height[n - 1];

        for(int i = 1, j = n - 2; i < n && j >= 0; i++, j--) {
            prefixSum[i] = Math.max(height[i], prefixSum[i - 1]);
            suffixSum[j] = Math.max(height[j], suffixSum[j + 1]);
        }

        int water = 0;
        for(int i = 0; i < n; i++) {
            water += Math.min(prefixSum[i], suffixSum[i]) - height[i];
        }

        return water;
    }

    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public static int trap2(int[] height) {
        int n = height.length;

        int water = 0;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;

        for(int i = 0; i < n; i++) {
            if(height[left] <= height[right]) {
                if(leftMax <= height[left]) leftMax = height[left];
                else water += leftMax - height[left];

                left++;
            }
            else {
                if(rightMax <= height[right]) rightMax = height[right];
                else water += rightMax - height[right];

                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] height = { 4, 2, 0, 3, 2, 5 };

        int ans1 = trap1(height);
        int ans2 = trap2(height);

        System.out.println(ans1);
        System.out.println(ans2);
    }
}