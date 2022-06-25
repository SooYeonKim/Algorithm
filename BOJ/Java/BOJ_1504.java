import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
	
	static int N;
	static List<Path>[] list;
	static int[] dist1;
	static int[] dist2;
	static int[] dist3;
	
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
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Path(b, c));
			list[b].add(new Path(a, c));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		dist1 = new int[N+1];
		Arrays.fill(dist1, Integer.MAX_VALUE);
		dist2 = new int[N+2];
		Arrays.fill(dist2, Integer.MAX_VALUE);
		dist3 = new int[N+3];
		Arrays.fill(dist3, Integer.MAX_VALUE);
		
		dijkstra(1, dist1);
		dijkstra(v1, dist2);
		dijkstra(N, dist3);
		
		int result = Integer.MAX_VALUE;
		if (dist1[v1] != Integer.MAX_VALUE
				&& dist2[v2] != Integer.MAX_VALUE
				&& dist3[v2] != Integer.MAX_VALUE) {
			result = dist1[v1] + dist2[v2] + dist3[v2];
		}
		if (dist1[v2] != Integer.MAX_VALUE
				&& dist2[v2] != Integer.MAX_VALUE
				&& dist3[v1] != Integer.MAX_VALUE) {
			result = Math.min(result, dist1[v2] + dist2[v2] + dist3[v1]);
		}
		
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
	
	private static void dijkstra(int start, int[] dist) {
		PriorityQueue<Path> pq = new PriorityQueue<>();
		pq.offer(new Path(start, 0));
		boolean[] visited = new boolean[N+1];
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Path cur = pq.poll();
			
			if (visited[cur.to]) continue;
			visited[cur.to] = true;
			
			for (int i = 0; i < list[cur.to].size(); i++) {
				Path temp = list[cur.to].get(i);
				if (dist[temp.to] > dist[cur.to] + temp.weight) {
					dist[temp.to] = dist[cur.to] + temp.weight;
					pq.offer(new Path(temp.to, dist[temp.to]));
				}
			}
		}
	}

}
