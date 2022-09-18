import java.util.*;

public class 등산코스_정하기 {
    
    class Node implements Comparable<Node> {
        int to;
        int weight;
        
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Node>[] list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < paths.length; i++) {
            int a = paths[i][0];
            int b = paths[i][1];
            int c = paths[i][2];
            
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] intensity = new int[n+1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n+1];
        
        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            intensity[gate] = 0;
        }
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            for (int i = 0; i < summits.length; i++) {
                if (summits[i] == cur.to) {
                    visited[cur.to] = true;
                    break;
                }
            }
            
            if (visited[cur.to]) continue;
            visited[cur.to] = true;
            
            for (int i = 0; i < list[cur.to].size(); i++) {
                Node temp = list[cur.to].get(i);
                if (intensity[temp.to] > Math.max(intensity[cur.to], temp.weight)) {
                    intensity[temp.to] = Math.max(intensity[cur.to], temp.weight);
                    pq.offer(new Node(temp.to, Math.max(intensity[cur.to], temp.weight)));
                }
            }
        }
        
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for (int s : summits) {
            if (intensity[s] < min) {
                answer[0] = s;
                answer[1] = min = intensity[s];
            }
        }
        return answer;
    }
}
