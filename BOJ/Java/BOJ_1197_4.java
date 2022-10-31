import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1197_4 {
	
	static class Edge {
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Edge>[] list = new ArrayList[V+1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list[A].add(new Edge(B, C));
			list[B].add(new Edge(A, C));
		}
		
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		boolean[] visited = new boolean[V+1];
		long result = 0;
		for (int i = 0; i < V; i++) {
			int idx = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= V; j++) {
				if (!visited[j] && dist[j] < min) {
					idx = j;
					min = dist[j];
				}
			}
			
			visited[idx] = true;
			result += min;
			
			for (int j = 0; j < list[idx].size(); j++) {
				Edge temp = list[idx].get(j);
				if (!visited[temp.to] && dist[temp.to] > temp.weight) {
					dist[temp.to] = temp.weight;
				}
			}
		}
		
		System.out.println(result);
	}

}
