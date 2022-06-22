import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
	
	static int N;
	static List<Path>[] list;
	static List<Path>[] rList;
	static int[] distance;
	static int[] rDistance;
	
	static class Path implements Comparable<Path> {
		int to;
		int time;
		
		public Path(int to, int time) {
			this.to = to;
			this.time = time;
		}
		
		@Override
		public int compareTo(Path o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		rList = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
			rList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			list[from].add(new Path(to, time));
			rList[to].add(new Path(from, time));
		}
		
		distance = new int[N+1];
		rDistance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(rDistance, Integer.MAX_VALUE);
		dijkstra(X, list, distance);
		dijkstra(X, rList, rDistance);
		
		int max = 0;
		for (int i = 1; i < N+1; i++) {
			int sum = distance[i] + rDistance[i];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
	
	private static void dijkstra(int X, List<Path>[] list, int[] distance) {
		PriorityQueue<Path> pq = new PriorityQueue<>();
		pq.offer(new Path(X, 0));
		distance[X] = 0;
		boolean[] visited = new boolean[N+1];
		
		while (!pq.isEmpty()) {
			Path cur = pq.poll();
			
			if (visited[cur.to]) continue;
			visited[cur.to] = true;
			
			for (int i = 0; i < list[cur.to].size(); i++) {
				Path temp = list[cur.to].get(i);
				if (distance[temp.to] > distance[cur.to] + temp.time) {
					distance[temp.to] = distance[cur.to] + temp.time;
					pq.offer(new Path(temp.to, distance[temp.to]));
				}
			}
		}
	}

}
