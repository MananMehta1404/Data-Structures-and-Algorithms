public class CountUniqueSubStrings {

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

    public static int countNodes(Node root){
        if(root == null) return 0;
        
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(root.children[i] != null) count += countNodes(root.children[i]);
        }

        return count + 1;
    }

    public static void main(String[] args) {
        String str = "apple";

        // Insert all suffixes of the string in the Trie structure.
        for(int i = 0; i < str.length(); i++){
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println("No. of unique substrings are: " + countNodes(root));
    }
}
