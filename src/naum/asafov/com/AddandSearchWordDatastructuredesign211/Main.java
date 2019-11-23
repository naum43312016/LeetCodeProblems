package naum.asafov.com.AddandSearchWordDatastructuredesign211;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.


 */
public class Main {
    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("a");
        w.addWord("ab");
        System.out.println(w.search("..."));
        System.out.println(w.search("a."));
        System.out.println(w.search("ab"));
        System.out.println(w.search(".a"));



    }
}

class WordDictionary {

    private static final class Node {
        private final Node[] nodes = new Node[26];
        private boolean isWord;
    }

    private final Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            Node next = cur.nodes[c - 'a'] == null ? new Node() : cur.nodes[c - 'a'];
            cur.nodes[c - 'a'] = next;
            cur = next;
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        if (word == null)
            return false;
        char[] arr = word.toCharArray();
        return search(root, arr, 0);
    }

    private boolean search(Node node, char[] s, int pos) {
        if (node == null)
            return false;
        if (pos == s.length)
            return node.isWord;
        char c = s[pos];
        if (c != '.')
            return search(node.nodes[c - 'a'], s, pos + 1);
        for (char a = 'a'; a <= 'z'; a++) {
            if (search(node.nodes[a - 'a'], s, pos + 1))
                return true;
        }
        return false;
    }
}