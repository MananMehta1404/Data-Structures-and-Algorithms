// Number of non-empty distinct subsequences of a string.
import java.util.*;

public class Distinct_Subsequences_II {
    public static void main(String[] args) {
        String s = "abcbac";

        int mod = (int)(1e9 + 7);
        int n = s.length();
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        HashMap<Character,Integer> prev_occur = new HashMap<>();
        for(int i = 1; i < dp.length; i++){
            dp[i] = (2 * dp[i - 1]) % mod;
            
            char ch = s.charAt(i - 1);
            if(prev_occur.containsKey(ch)){
                int j = prev_occur.get(ch);
                dp[i] = dp[i] - dp[j - 1];
            }
            
            if(dp[i] <= 0){
                dp[i] += mod;
            }
            
            prev_occur.put(ch, i);
        }

        // Note: We have to subtract 1 from the final answer because we have to exclude the empty string.
        System.out.println(dp[n] - 1);
    }
}
