import java.util.Hashtable;

public class Minimum_Window_Substring {
    public static boolean contains(Hashtable<Character, Integer> ht1, Hashtable<Character, Integer> ht) {
        for(char key: ht.keySet()) {
            if(!ht1.containsKey(key)) return false;
            if(ht1.get(key) < ht.get(key)) return false;
        }

        return true;
    }
    
    public static String minWindow(String s, String t) {

        Hashtable<Character, Integer> ht = new Hashtable<>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(ht.containsKey(ch)) ht.put(ch, ht.get(ch) + 1);
            else ht.put(ch, 1);
        }

        Hashtable<Character, Integer> ht1 = new Hashtable<>();

        int n = s.length();

        int left = 0;
        int right = 0;
        int i = 0;
        int j = 0;
        int len = Integer.MAX_VALUE;

        while(i < n || j < n) {
            if(contains(ht1, ht)) {
                if(len > j - i) {
                    len = j - i;
                    left = i;
                    right = j;
                }
                char ch = s.charAt(i);
                ht1.put(ch, ht1.get(ch) - 1);
                if(ht1.get(ch) == 0) ht1.remove(ch);
                i++;
            }
            else {
                if(j >= n) break;
                char ch = s.charAt(j);
                if(ht1.containsKey(ch)) ht1.put(ch, ht1.get(ch) + 1);
                else ht1.put(ch, 1);
                j++;
            } 
        }

        String ans = "";
        for(int idx = left; idx < right; idx++) ans += s.charAt(idx);

        return ans;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
