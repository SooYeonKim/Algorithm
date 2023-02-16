import java.util.*;

public class 파일명_정렬_2 {
    
    class Node implements Comparable<Node> {
        int idx;
        String HEAD;
        String NUMBER;
        String TAIL;
        
        public Node(int idx, String HEAD, String NUMBER, String TAIL) {
            this.idx = idx;
            this.HEAD = HEAD;
            this.NUMBER = NUMBER;
            this.TAIL = TAIL;
        }
        
        @Override
        public int compareTo(Node o) {
            if (this.HEAD.toLowerCase().compareTo(o.HEAD.toLowerCase()) == 0) {
                if (Integer.parseInt(this.NUMBER) == Integer.parseInt(o.NUMBER)) {
                    return this.idx - o.idx;
                }
                return Integer.parseInt(this.NUMBER) - Integer.parseInt(o.NUMBER);
            }
            return this.HEAD.toLowerCase().compareTo(o.HEAD.toLowerCase());
        }
    }
    
    public String[] solution(String[] files) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            int idx = 0;
            String str = files[i];
            String HEAD = "";
            while (idx < str.length() && (str.charAt(idx) < '0' || str.charAt(idx) > '9')) {
                HEAD += str.charAt(idx);
                idx++;
            }
            
            String NUMBER = "";
            while (idx < str.length() && (str.charAt(idx) >= '0' && str.charAt(idx) <= '9')) {
                NUMBER += str.charAt(idx);
                idx++;
            }
            
            String TAIL = "";
            while (idx < str.length()) {
                TAIL += str.charAt(idx);
                idx++;
            }
            
            list.add(new Node(i, HEAD, NUMBER, TAIL));
        }
        
        Collections.sort(list);
        
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            Node temp = list.get(i);
            answer[i] = temp.HEAD + temp.NUMBER + temp.TAIL;
        }
        return answer;
    }
}
