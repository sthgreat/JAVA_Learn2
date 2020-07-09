package LeetCode;

class Trie {
    private TrieNode head;
    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = head;
        for(int i = 0;i<word.length();i++){
            if(node.arr[word.charAt(i) - 'a'] == null){
                node.arr[word.charAt(i) - 'a'] = new TrieNode();
            }
            node = node.arr[word.charAt(i) - 'a'];
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = head;
        for(int i = 0;i<word.length();i++){
            node = node.arr[word.charAt(i) - 'a'];
            if(node == null){
                return false;
            }
        }
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = head;
        for(int i = 0;i<prefix.length();i++){
            node = node.arr[prefix.charAt(i) - 'a'];
            if(node == null){
                return false;
            }
        }
        return node != null;
    }
}


class TrieNode{
    private final int size = 26;
    public TrieNode[] arr;
    boolean isEnd;

    public TrieNode(){
        arr = new TrieNode[size];
    }

    public void setEnd(){
        isEnd = true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
