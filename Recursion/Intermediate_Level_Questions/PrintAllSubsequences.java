package Recursion;

public class PrintAllSubsequences {

    // Time Complexity -> O(2^n)
    public static void printAllSubsequences(String str, int idx, String newString){
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }
        char curr_char = str.charAt(idx);
        // Every character has two choices
        // to be in a string
        printAllSubsequences(str, idx + 1, newString + curr_char);
        // not to be in a string
        printAllSubsequences(str, idx + 1, newString);
    }
    public static void main(String[] args) {
        String s1 = "abc";
        printAllSubsequences(s1, 0, "");
    }
}
