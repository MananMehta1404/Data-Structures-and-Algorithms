public class StringCompression {

    public static int compress(char[] chars) {
        int n = chars.length;
        String s = "";
        for(int i = 0; i < n; i++) {
            char ch = chars[i];
            int count = 1;
            int j = i + 1;
            while(j < n && ch == chars[j]) {
                count++;
                i++;
                j++;
            }
            if(count == 1) s += ch;
            else s = s + ch + count;
        }

        for(int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        return s.length();
    }

    public static void main(String[] args) {
        String str = "aaabbbccc";
        char[] chars = str.toCharArray();

        int ans = compress(chars);

        for(int i = 0; i < ans; i++) {
            System.out.print(chars[i] + " ");
        }
    }
}
