import java.util.*;

public class 부대복귀 {
    
    int n;
    List<Integer>[] list;
    int[] dist;
    
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
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        this.n = n;
        list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        dijkstra(destination);
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            if (dist[sources[i]] != Integer.MAX_VALUE) answer[i] = dist[sources[i]];
            else answer[i] = -1;
        }
        return answer;
    }
    
    private void dijkstra(int target) {
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[target] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(target, 0));
        boolean[] visited = new boolean[n+1];
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            
            if (visited[node.to]) continue;
            visited[node.to] = true;
            
            for (int i = 0; i < list[node.to].size(); i++) {
                int temp = list[node.to].get(i);
                if (dist[temp] > node.weight + 1) {
                    dist[temp] = node.weight + 1;
                    pq.offer(new Node(temp, dist[temp]));
                }
            }
        }
    }
}
