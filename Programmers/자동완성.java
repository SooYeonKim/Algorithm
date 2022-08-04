import java.util.*;

public class 자동완성 {
    
    class Node {
        Map<Character, Node> child = new HashMap<>();
        int cnt;
    }
    
    class Trie {
        Node root;
        
        public Trie() {
            root = new Node();
        }
        
        public void insert(String str) {
            Node cur = this.root;
            char[] cArray = str.toCharArray();
            for (char c : cArray) {
                if (!cur.child.containsKey(c)) {
                    cur.child.put(c, new Node());
                }
                cur = cur.child.get(c);
                cur.cnt++;
            }
        }
        
        public int search(String str) {
            Node cur = this.root;
            char[] cArray = str.toCharArray();
            int cnt = 0;
            for (char c : cArray) {
                cur = cur.child.get(c);
                cnt++;
        
                if (cur.cnt == 1) return cnt;
            }
            
            return cnt;
        }
    }
    
    public int solution(String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            answer += trie.search(words[i]);
        }
        return answer;
    }
}
