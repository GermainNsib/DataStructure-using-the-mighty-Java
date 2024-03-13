package com.company;

public class Main {

    public static void main(String[] args) {
        class TrieNode {
            char content;
            boolean isEnd;
            int count;
            TrieNode[] childList;

            public TrieNode(char c) {
                childList = new TrieNode[26];
                isEnd = false;
                content = c;
                count = 0;
            }

            public TrieNode subNode(char c) {
                if (childList != null) {
                    return childList[c - 'a'];
                } else {
                    return null;
                }
            }
        }

        public class Trie {
            private TrieNode root;

            public Trie() {
                root = new TrieNode(' ');
            }

            public void insert(String word) {
                TrieNode current = root;
                for (char c : word.toCharArray()) {
                    if (current.childList[c - 'a'] == null) {
                        current.childList[c - 'a'] = new TrieNode(c);
                    }
                    current = current.childList[c - 'a'];
                    current.count++;
                }
                current.isEnd = true;
            }

            public boolean search(String word) {
                TrieNode current = root;
                for (char c : word.toCharArray()) {
                    if (current.childList[c - 'a'] == null) {
                        return false;
                    }
                    current = current.childList[c - 'a'];
                }
                return current.isEnd;
            }

            public int wordsWithPrefix(String prefix) {
                TrieNode current = root;
                for (char c : prefix.toCharArray()) {
                    if (current.childList[c - 'a'] == null) {
                        return 0;
                    }
                    current = current.childList[c - 'a'];
                }
                return current.count;
            }

            public static void main(String[] args) {
                Trie trie = new Trie();
                trie.insert("hello");
                trie.insert("world");
                trie.insert("hi");
                trie.insert("hey");

                System.out.println("Search 'hello': " + trie.search("hello"));
                System.out.println("Search 'world': " + trie.search("world"));
                System.out.println("Search 'hi': " + trie.search("hi"));
                System.out.println("Search 'hey': " + trie.search("hey"));
                System.out.println("Search 'h': " + trie.search("h"));

                System.out.println("Words with prefix 'he': " + trie.wordsWithPrefix("he"));
                System.out.println("Words with prefix 'w': " + trie.wordsWithPrefix("w"));
                System.out.println("Words with prefix 'z': " + trie.wordsWithPrefix("z"));
            }
        }
    }
}
