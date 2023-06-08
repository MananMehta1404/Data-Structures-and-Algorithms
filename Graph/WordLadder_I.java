import java.util.*;

public class WordLadder_I {

    static class Pair {
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startWord, 1));

        Set<String> st = new HashSet<String>();
        int len = wordList.length;
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }
        st.remove(startWord);

        while(!queue.isEmpty()) {
            String word = queue.peek().word;
            int level = queue.peek().level;
            queue.remove();

            if (word.equals(targetWord)) return level;

            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    // String newWord = word.substring(0, i) + ch + word.substring(i + 1);  // this is slow method
                    char arr[] = word.toCharArray();
                    arr[i] = ch;
                    String newWord = new String(arr);

                    if (st.contains(newWord)) {
                        queue.add(new Pair(newWord, level + 1));
                        st.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(wordLadderLength(startWord, targetWord, wordList));
    }
}