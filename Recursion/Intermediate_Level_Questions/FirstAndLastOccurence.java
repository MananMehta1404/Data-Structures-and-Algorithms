public class FirstAndLastOccurence {
    static int first = -1;
    static int last = -1;

    // Time Complexity -> O(n)
    public static void printOccurence(String str, int idx, char element){
        if(idx == str.length()){
            System.out.println("First Occurence is: " + first);
            System.out.println("Last Occurence is: " + last);
            return;
        }
        char curr_char = str.charAt(idx);
        if(curr_char == element){
            if(first == -1) {
                first = idx;
                last = idx;
            }
            else last = idx;
        }
        printOccurence(str, idx + 1, element);
    }
    public static void main(String[] args) {
        String s1 = "abaacdaefaah";
        printOccurence(s1, 0, 'a');
    }
}
