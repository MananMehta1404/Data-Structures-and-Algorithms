public class MoveXtoEnd {

    // Time Complexity -> O(n)
    public static String moveAllX_ToEnd(String str, String newString, int idx, int count){
        if(idx == str.length()){
            for(int i = 0; i < count; i++){
                newString += 'x';
            }
            return newString;
        }
        char curr_char = str.charAt(idx);
        if(curr_char == 'x'){
            count += 1;
            return moveAllX_ToEnd(str, newString, idx + 1, count);
        }
        else{
            newString += curr_char;
            return moveAllX_ToEnd(str, newString, idx + 1, count);
        }
    }
    
    public static void main(String[] args) {
        String s1 = "axbcxxd";
        System.out.println("New String is: " + moveAllX_ToEnd(s1, "", 0, 0));
    }
}
