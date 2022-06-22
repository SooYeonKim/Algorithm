import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_2 {
	
	static int V;
	static List<Path>[] list;
	static int[] distance;
	
	static class Path implements Comparable<Path> {
		int to;
		int weight;
		
		public Path(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Path o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V+1];
		for (int i = 0; i < V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[u].add(new Path(v, w));
		}
		
		distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		dijkstra(K);
		
		for (int i = 1; i < V+1; i++) {
			if (distance[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
	}
	
	private static void dijkstra(int K) {
		PriorityQueue<Path> pq = new PriorityQueue<>();
		pq.offer(new Path(K, 0));
		distance[K] = 0;
		boolean[] visited = new boolean[V+1];
		
		while (!pq.isEmpty()) {
			Path cur = pq.poll();
			
			if (visited[cur.to]) continue;
			visited[cur.to] = true;
			
			for (int i = 0; i < list[cur.to].size(); i++) {
				Path temp = list[cur.to].get(i);
				if (distance[temp.to] > distance[cur.to] + temp.weight) {
					distance[temp.to] = distance[cur.to] + temp.weight;
					pq.offer(new Path(temp.to, distance[temp.to]));
				}
			}
		}
	}

}
