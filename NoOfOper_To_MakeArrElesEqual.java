import java.util.Arrays;

public class NoOfOper_To_MakeArrElesEqual {
    public static void main(String[] args) {
        int nums[] = {7, 9, 10, 8, 6, 4, 1, 5, 2, 3};

        Arrays.sort(nums);
        int n = nums.length;

        int min = nums[0];
        int count = 0;
        for(int i = n - 1; i >= 0; i--) {
            int j = i - 1;
            while(j >= 0 && nums[j] >= nums[i]) {
                j--;
            }
            if(j < 0) continue;
            nums[i] = nums[j];
            count++;
            if(nums[j]!= min) i++;
        }

        System.out.println(count);
    }
}
