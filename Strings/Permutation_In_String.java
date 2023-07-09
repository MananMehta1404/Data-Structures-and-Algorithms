public class Permutation_In_String {

    public static boolean isPermutation(int[] arr1, int[] arr2){

        for(int i = 0; i < 26; i++) {
            if(arr1[i] != arr2[i]) return false;
        }
        
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0; i < s1.length(); i++){
            int idx1 = s1.charAt(i) - 'a';
            arr1[idx1]++;

            int idx2 = s2.charAt(i) - 'a';
            arr2[idx2]++;
        }

        if(s1.length() == s2.length()) {
            if(isPermutation(arr1, arr2)) return true;
            else return false;
        }

        if(isPermutation(arr1, arr2)) return true;

        for(int i = s1.length(); i < s2.length(); i++){

            int idx1 = s2.charAt(i) - 'a';
            arr2[idx1]++;

            int idx2 = s2.charAt(i - s1.length()) - 'a';
            arr2[idx2]--;

            if(isPermutation(arr1, arr2)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "eb";
        String t = "eidbaooo";

        System.out.println(checkInclusion(s, t));
    }
}
