import java.util.*;

public class Longest_String_Chain implements Comparator<String> {

    public static boolean checkIfPossible(String s1, String s2) {
        if(s1.length() != s2.length() + 1) return false;

        int first = 0;
        int second = 0;
        
        while(first < s1.length()) {
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            }
            else {
                first++;
            }
        }

        if(first == s1.length() && second == s2.length()) return true;
        else return false;
    }

    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }

    public static int longestStringChain(String[] words, int n) {

        Arrays.sort(words, 0, n, new Longest_String_Chain());
        List<String> temp = Arrays.asList(words);

        System.out.println(temp);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int maxlen = 1;
        for(int i = 0; i < n; i++) {

            for(int prev_idx = 0; prev_idx < i; prev_idx++) {
                if(checkIfPossible(words[i], words[prev_idx]) && 1 + dp[prev_idx] > dp[i]){
                    dp[i] = 1 + dp[prev_idx];
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }

        return maxlen;
    }

    public static void main(String[] args) {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        int n = words.length;

        System.out.println("Longest String Chain is of size: " + longestStringChain(words, n)); 
    }
}
