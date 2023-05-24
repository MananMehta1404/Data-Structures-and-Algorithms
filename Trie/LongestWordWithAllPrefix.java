public class LongestWordWithAllPrefix {

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

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp){
        if(root == null) return;

        for(int i = 0; i < 26; i++){
            if(root.children[i] != null && root.children[i].endOfWord == true){
                temp.append((char)(i + 'a'));   // Step 1

                if(ans.length() < temp.length()) ans = temp.toString();  // Step 2

                longestWord(root.children[i], temp);   // Step 3

                temp.deleteCharAt(temp.length() - 1);   // Step 4
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        for(int i = 0; i < words.length; i++){
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println("Longest word with all prefixes is: " + ans);
    }
}
