import java.util.HashSet;

public class PrintAllUniqueSubsequences {

    // Time Complexity -> O(2^n)
    public static void printAllUniqueSubsequences(String str, int idx, String newString, HashSet<String> set){
        if(idx == str.length()){
            if(set.contains(newString)) return;
            else{
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char curr_char = str.charAt(idx);
        // Every character has two choices
        // to be in a string
        printAllUniqueSubsequences(str, idx + 1, newString + curr_char, set);
        // not to be in a string
        printAllUniqueSubsequences(str, idx + 1, newString, set);
    }
    public static void main(String[] args) {
        String s1 = "aaa";
        HashSet<String> set = new HashSet<>();
        printAllUniqueSubsequences(s1, 0, "", set);
    }    
}
