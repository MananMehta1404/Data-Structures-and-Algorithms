public class PrintKeypadCombination {
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    // Time Complexity -> O(4^n)  {4 -> maximum length of keypad string, n -> maximum length of string of numbers}
    public static void printCombinations(String str, int idx, String combination){
        if(idx == str.length()){
            System.out.println(combination);
            return;
        }

        char currChar = str.charAt(idx);
        String mapped = keypad[currChar - '0'];

        for(int i = 0; i < mapped.length(); i++){
            printCombinations(str, idx + 1, combination + mapped.charAt(i));
        }
    }
    public static void main(String[] args) {
        String s1 = "23";
        printCombinations(s1, 0, "");
    }
}
