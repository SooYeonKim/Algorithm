import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {
	
	static int N;
	static List<Bus>[] list;
	static int start;
	static int end;
	static int[] distance;
	
	static class Bus implements Comparable<Bus> {
		int to;
		int cost;
		
		public Bus(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		public int compareTo(Bus o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Bus(to, cost));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		dijkstra();
		
		System.out.println(distance[end]);
	}
	
	public static void dijkstra() {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.offer(new Bus(start, 0));
		boolean[] visited = new boolean[N+1];
		
		while (!pq.isEmpty()) {
			Bus cur = pq.poll();
			
			if (cur.to == end) break;
			if (visited[cur.to]) continue;
			visited[cur.to] = true;
			
			for (int i = 0; i < list[cur.to].size(); i++) {
				Bus temp = list[cur.to].get(i);
				if (distance[temp.to] > distance[cur.to] + temp.cost) {
					distance[temp.to] = distance[cur.to] + temp.cost;
					pq.offer(new Bus(temp.to, distance[temp.to]));
				}
			}
		}
	}

}
