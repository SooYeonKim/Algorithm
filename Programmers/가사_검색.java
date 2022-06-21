
public class 가사_검색 {
    
    class Trie {
        Trie[] child = new Trie[26];
        int cnt;
        
        public void insert(String str) {
            Trie cur = this;
            char[] cArray = str.toCharArray();
            for (char c : cArray) {
                cur.cnt++;
                
                int idx = c - 'a';
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Trie();
                }
                cur = cur.child[idx];
            }
        }
        
        public int search(String str) {
            Trie cur = this;
            char[] cArray = str.toCharArray();
            for (char c : cArray) {
                if (c == '?') return cur.cnt;
                
                int idx = c - 'a';
                if (cur.child[idx] == null) return 0;
                cur = cur.child[idx];
            }
            
            return cur.cnt;
        }
    }
    
    Trie[] trieArr = new Trie[10000];
    Trie[] reTrieArr = new Trie[10000];
    
    public int[] solution(String[] words, String[] queries) {
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length() - 1;
            String str = words[i];
            
            if (trieArr[len] == null) {
                trieArr[len] = new Trie();
                reTrieArr[len] = new Trie();
            }
            
            trieArr[len].insert(str);
            str = new StringBuilder(str).reverse().toString();
            reTrieArr[len].insert(str);
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int len = queries[i].length() - 1;
            String str = queries[i];
            
            if (trieArr[len] == null) {
                continue;
            }
            
            if (queries[i].charAt(0) != '?') {
                answer[i] = trieArr[len].search(str);
            } else {
                str = new StringBuilder(str).reverse().toString();
                answer[i] = reTrieArr[len].search(str);
            }
        }
        return answer;
    }
}
