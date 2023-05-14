// Two Pointer Approach
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if(height[left] <= height[right]) left++;
            else right--;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum amount of water a container can store is: " + maxArea(height));
    }    
}
