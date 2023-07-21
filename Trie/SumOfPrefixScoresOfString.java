public class SumOfPrefixScoresOfString {

    static class Node{
        Node[] children;
        boolean endOfWord;
        int count;

        public Node(){
            children = new Node[26]; 
            for(int i = 0; i < 26; i++) children[i] = null; 
            endOfWord = false;
            count = 1;
        }
    }

    static Node root;

    public static void addWord(String word) {
        Node currNode = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';  // Calculating the index of the character.

            if(currNode.children[idx] == null){
                // Add new node
                currNode.children[idx] = new Node();
            }
            else currNode.children[idx].count += 1;


            // If the character is the last letter of the word then make endOfWord = true
            if(i == word.length() - 1){
                currNode.children[idx].endOfWord = true;
            }

            currNode = currNode.children[idx];
        }
    }

    public static int findScore(String word) {
        Node currNode = root;

        int score = 0;
        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            score += currNode.children[idx].count;

            currNode = currNode.children[idx];
        }

        return score;
    }

    public static int[] sumPrefixScores(String[] words) {
        int n = words.length;

        root = new Node();

        for(int i = 0; i < n; i++) {
            addWord(words[i]);
        }

        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = findScore(words[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"abc","ab","bc","b"};

        int[] ans = sumPrefixScores(words);

        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
