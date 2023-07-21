public class WordDictionary {

    static class Node{
        Node[] children;
        boolean endOfWord;

        public Node(){
            children = new Node[26]; 
            for(int i = 0; i < 26; i++) children[i] = null; 
            endOfWord = false;
        }
    }

    static Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node currNode = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';  // Calculating the index of the character.

            if(currNode.children[idx] == null){
                // Add new node
                currNode.children[idx] = new Node();
            }
            // If the character is the last letter of the word then make endOfWord = true
            if(i == word.length() - 1){
                currNode.children[idx].endOfWord = true;
            }

            currNode = currNode.children[idx];
        }
    }

    public static boolean findWord(int idx, String word, Node currNode) {
        if(idx == word.length()) return true;
        if(currNode == null) return false;

        boolean ans = false;
        if(word.charAt(idx) == '.') {
            for(int i = 0; i < 26; i++) {
                if(currNode.children[i] != null) {
                    if(idx == word.length() - 1 && currNode.children[i].endOfWord == false) continue;
                    
                    ans = ans || findWord(idx + 1, word, currNode.children[i]);
                }
            }
        }
        else {
            int index = word.charAt(idx) - 'a';

            if(currNode.children[index] == null) return false;  // If the letter doesn't exit in the children
            if(idx == word.length() - 1 && currNode.children[index].endOfWord == false) return false;  // If the character is the last letter and endOfWord is not true

            ans = ans || findWord(idx + 1, word, currNode.children[index]);
        }

        return ans;
    }
    
    public boolean search(String word) {
        Node currNode = root;
        boolean ans = false;

        ans = ans || findWord(0, word, currNode);

        return ans;
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");

        System.out.println(obj.search("pad"));  // false
        System.out.println(obj.search("bad"));  // true
        System.out.println(obj.search(".ad"));  // true
        System.out.println(obj.search("b.."));  // true
    }
}
