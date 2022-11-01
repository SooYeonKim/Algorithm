import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_3 {
	
	static int V, E;
	static List<Edge>[] list;
	static int[] dist;
	
	static class Edge implements Comparable<Edge> {
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V+1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Edge(v, w));
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		
		dijkstra(K);
		
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}
	
	private static void dijkstra(int K) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(K, 0));
		boolean[] visited = new boolean[V+1];
		
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if (visited[edge.to]) continue;
			visited[edge.to] = true;
			
			for (int i = 0; i < list[edge.to].size(); i++) {
				Edge temp = list[edge.to].get(i);
				
				if (dist[temp.to] > dist[edge.to] + temp.weight) {
					dist[temp.to] = dist[edge.to] + temp.weight;
					pq.offer(new Edge(temp.to, dist[temp.to]));
				}
			}
		}
	}

}
