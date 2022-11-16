import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_2 {
	
	static int N, M, X;
	static List<Road>[] list1;
	static List<Road>[] list2;
	static int[] dist1;
	static int[] dist2;
	
	static class Road implements Comparable<Road> {
		int to;
		int time;
		
		public Road(int to, int time) {
			this.to = to;
			this.time = time;
		}
		
		@Override
		public int compareTo(Road o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		list1 = new ArrayList[N+1];
		list2 = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list1[i] = new ArrayList<>();
			list2[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			list1[from].add(new Road(to, time));
			list2[to].add(new Road(from, time));
		}
		
		dist1 = new int[N+1];
		dist2 = new int[N+1];
		Arrays.fill(dist1, Integer.MAX_VALUE);
		Arrays.fill(dist2, Integer.MAX_VALUE);
		
		dijkstra(list1, dist1, X);
		dijkstra(list2, dist2, X);
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (dist1[i] + dist2[i] > result) {
				result = dist1[i] + dist2[i];
			}
		}
		
		System.out.println(result);
	}
	
	private static void dijkstra(List<Road>[] list, int[] dist, int X) {
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.offer(new Road(X, 0));
		boolean[] visited = new boolean[N+1];
		dist[X] = 0;
		
		while (!pq.isEmpty()) {
			Road road = pq.poll();
			
			if (visited[road.to]) continue;
			visited[road.to] = true;
			
			for (int i = 0; i < list[road.to].size(); i++) {
				Road temp = list[road.to].get(i);
				
				if (dist[temp.to] > dist[road.to] + temp.time) {
					dist[temp.to] = dist[road.to] + temp.time;
					pq.offer(new Road(temp.to, dist[temp.to]));
				}
			}
		}
	}

}
