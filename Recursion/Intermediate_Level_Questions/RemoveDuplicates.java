package Recursion.Intermediate_Level_Questions;

public class RemoveDuplicates {
    public static boolean[] map = new boolean[26];

    // Time Complexity -> O(n)
    public static void removeDuplicates(String str, int idx, String newString){
        if(idx == str.length()){
            System.out.println(newString);
            return;
        };
        char curr_char = str.charAt(idx);
        if(map[curr_char - 'a']) removeDuplicates(str, idx + 1, newString);
        else{
            newString += curr_char;
            map[curr_char - 'a'] = true;
            removeDuplicates(str, idx + 1, newString);
        }
    }
    
    public static void main(String[] args) {
        String s1 = "abbcdda";
        removeDuplicates(s1, 0, "");
    }
}
