import java.util.*;

public class 길_찾기_게임 {
    
    Node[] nArr;
    int[][] answer;
    int preIdx, postIdx;
    
    class Node {
        int x;
        int y;
        int value;
        Node left;
        Node right;
        
        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        nArr = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nArr[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null);
        }
        
        Arrays.sort(nArr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y == o2.y) {
                    return o1.x - o2.x;
                }
                return o2.y - o1.y;
            }
        });
        
        Node root = nArr[0];
        for (int i = 1; i < nodeinfo.length; i++) {
            connectNode(root, nArr[i]);
        }
        
        answer = new int[2][nodeinfo.length];
        preOrder(root);
        postOrder(root);
        return answer;
    }
    
    private void connectNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                connectNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                connectNode(parent.right, child);
            }
        }
    }
    
    private void preOrder(Node node) {
        answer[0][preIdx++] = node.value;
        if (node.left != null) preOrder(node.left);
        if (node.right != null) preOrder(node.right);
    }
    
    private void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        answer[1][postIdx++] = node.value;
    }
}
