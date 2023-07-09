import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static boolean isAnagram(int[] arr1, int[] arr2){

        for(int i = 0; i < 26; i++) {
            if(arr1[i] != arr2[i]) return false;
        }
        
        return true;
    }


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> l1 = new ArrayList<Integer>();

        if(s.length() < p.length()) return l1;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0; i < p.length(); i++) {
            int idx1 = p.charAt(i) - 'a';
            arr1[idx1]++;

            int idx2 = s.charAt(i) - 'a';
            arr2[idx2]++;
        }

        if(s.length() == p.length()) {
            if(isAnagram(arr1, arr2)) l1.add(0);
            return l1;
        }

        if(isAnagram(arr1, arr2)) l1.add(0);

        for(int i = p.length(); i < s.length(); i++){

            int idx1 = s.charAt(i) - 'a';
            arr2[idx1]++;

            int idx2 = s.charAt(i - p.length()) - 'a';
            arr2[idx2]--;

            if(isAnagram(arr1, arr2)) l1.add(i - p.length() + 1);
        }

        return l1;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }
}
