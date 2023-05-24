public class WordBreak {

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

    // Time Complexity -> O(L) where L is the length of the word to be searched
    public static boolean search(String key){
        Node currNode = root;
        for(int i = 0; i < key.length(); i++){
            int idx = key.charAt(i) - 'a';

            if(currNode.children[idx] == null) return false;  // If the letter doesn't exit in the children
            if(i == key.length() - 1 && currNode.children[idx].endOfWord == false) return false;  // If the character is the last letter and endOfWord is not true

            currNode = currNode.children[idx];
        }

        return true;
    }

    public static boolean wordBreak(String key){
        if(key.length() == 0) return true;

        for(int i = 1; i <= key.length(); i++){
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);

            if(search(firstPart) && wordBreak(secondPart)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // String words[] = {"i", "like", "sam", "samsung", "mobile"};
        // String key = "ilikesamsung";

        String words[] = {"b"};
        String key = "a";

        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }

        System.out.println(wordBreak(key));
    }
}
