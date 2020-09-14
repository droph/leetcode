package trees_and_graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Trie {

    /** Initialize your data structure here. */
    private Node root;

    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        var node = root;
        for(char currentChar : word.toCharArray()){
            if(!node.containsKey(currentChar)) {
                node.put(currentChar, new Node());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        var node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private Node searchPrefix(String word){
        var node = root;
        for(char currentChar : word.toCharArray()){
            if(node.containsKey(currentChar)){
                node = node.get(currentChar);
            } else {
                node = null;
                return null;
            }
        }
        return node;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        var node = searchPrefix(prefix);
        return node != null;
    }

    public static class Node{
        private Node[] links = new Node[26];
        private boolean isEnd;

        public Node(){
        }

        public boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, Node node){
            links[ch - 'a'] = node;
        }

        public void setEnd(){
            isEnd = true;
        }
        public boolean isEnd(){
            return isEnd;
        }
    }
}

