public class StartsWith {

    static class Node{
        Node[] children;
        boolean endOfWord;

        public Node(){
            children = new Node[26];  // a - z
            for(int i = 0; i < 26; i++) children[i] = null;  // Initializing the array with null values
            endOfWord = false;
        }
    }

    static Node root = new Node();

    // Time Complexity -> O(L) where L is the length of the word to be inserted
    public static void insert(String word){
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

    public static boolean startsWith(String prefix){
        Node currNode = root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';

            if(currNode.children[idx] == null) return false;

            currNode = currNode.children[idx];
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "app", "mango", "man", "woman"};
        String prefix = "moon";

        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }

        System.out.println("Prefix exists: " + startsWith(prefix));
    }
}
