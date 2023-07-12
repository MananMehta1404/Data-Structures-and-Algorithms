import java.util.Hashtable;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Hashtable<Character, Integer> ht1 = new Hashtable<>();
        Hashtable<Character, Integer> ht2 = new Hashtable<>();

        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            if(ht1.containsKey(ch1)) ht1.put(ch1, ht1.get(ch1) + 1);
            else ht1.put(ch1, 1);

            char ch2 = t.charAt(i);
            if(ht2.containsKey(ch2)) ht2.put(ch2, ht2.get(ch2) + 1);
            else ht2.put(ch2, 1);
        }

        for(char ch : ht1.keySet()) {
            if(!ht2.containsKey(ch)) return false;
            else if(ht1.get(ch) != ht2.get(ch)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}
