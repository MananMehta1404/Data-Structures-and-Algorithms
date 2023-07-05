import java.util.*;

public class Largest_Divisible_Subset {
    public static List<Integer> largestDivisibleSubset(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        Arrays.fill(hash, 1);

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            hash[i] = i;

            for(int prev_idx = 0; prev_idx < i; prev_idx++) {
                if(arr[i] % arr[prev_idx] == 0 && 1 + dp[prev_idx] > dp[i]){
                    dp[i] = 1 + dp[prev_idx];
                    hash[i] = prev_idx;
                }
            }
        }

        int maxlen = -1;
        int lastIndex =-1;
        
        for(int i = 0; i <= n - 1; i++){
            if(dp[i] > maxlen){
                maxlen = dp[i];
                lastIndex = i;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        result.add(arr[lastIndex]);
        
        while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
            lastIndex = hash[lastIndex];
            result.add(arr[lastIndex]);    
        }

        Collections.reverse(result);

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 16, 7, 8};
        int n = arr.length;

        System.out.println(largestDivisibleSubset(arr, n));
    }
}
