import java.util.*;

public class WordLadder_II {

    public static List<List<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        // Push all values of wordList into a set to make deletion from it easier and in less time complexity.
        Set<String> st = new HashSet<String>();
        int len = wordList.length;
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }

        // Creating a queue ds which stores the words in a sequence which is required to reach the targetWord after successive transformations.
        Queue<List<String>> q = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;

        // This list will store all the sequences which are required to reach the targetWord.
        List<List<String>> ans = new ArrayList<>();

        // BFS traversal with pushing the new formed sequence in queue when after a transformation, a word is found in wordList.
        while (!q.isEmpty()) {
            List<String> vec = q.peek();
            q.remove();

             // Now, erase all words that have been used in the previous levels to transform
             if (vec.size() > level) {
                level++;
                for (String it: usedOnLevel) {
                    st.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);

            // Store the answers if the end word matches with targetWord.
            if (word.equals(targetWord)) {
                // The first sequence where we reached the end.
                if (ans.size() == 0) ans.add(vec);
                else if (ans.get(0).size() == vec.size()) ans.add(vec);
            }

            for (int i = 0; i < word.length(); i++) {
                // Now, replace each character of ‘word’ with char from a-z then check if ‘word’ exists in wordList.
                for (char c = 'a'; c <= 'z'; c++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);

                    if (st.contains(replacedWord) == true) {
                        vec.add(replacedWord);
                        // Java works by reference, so enter the copy of vec otherwise if you remove word from vec in next lines, it will remove from everywhere. 
                        List<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        // Mark as visited on the level 
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String startWord = "der";
        String targetWord = "dfs";
        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};

        List<List<String>> res = findSequences(startWord, targetWord, wordList);

        if(res.size() == 0) {
            System.out.println("No sequence found");
        }
        else {
            for (List<String> lst : res) {
                for (String str : lst) {
                    System.out.print(str + " ");
                }
                System.out.println();
            }
        }
    }
}
