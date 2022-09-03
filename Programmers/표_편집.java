import java.util.*;

public class 표_편집 {
    class Node {
        Node prev;
        Node next;
        int data;
        
        public Node(int data) {
            this.prev = null;
            this.next = null;
            this.data = data;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        Stack<Node> stack = new Stack<>();
        Node root = new Node(0);
        Node prev = root;
        Node next = null;
        Node now = null;
        for (int i = 1; i < n; i++) {
            Node node = new Node(i);
            prev.next = node;
            node.prev = prev;
            prev = node;
            if (i == k) now = node;
        }
        
        for (String str : cmd) {
            String[] sArray = str.split(" ");
            if (sArray[0].equals("U")) {
                int num = Integer.parseInt(sArray[1]);
                for (int i = 0; i < num; i++) {
                    now = now.prev;
                }
            } else if (sArray[0].equals("D")) {
                int num = Integer.parseInt(sArray[1]);
                for (int i = 0; i < num; i++) {
                    now = now.next;
                }
            } else if (sArray[0].equals("C")) {
                stack.push(now);
                prev = now.prev;
                next = now.next;
                
                if (prev == null) {
                    root = next;
                    now = next;
                } else if (next == null) {
                    prev.next = null;
                    now = prev;
                } else {
                    prev.next = next;
                    next.prev = prev;
                    now = next;
                }
            } else if (sArray[0].equals("Z")) {
                Node node = stack.pop();
                if (node.prev != null) {
                    node.prev.next = node;
                }
                if (node.next != null) {
                    node.next.prev = node;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('O');
        }
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop().data, 'X');
        }
        
        return sb.toString();
    }
}
