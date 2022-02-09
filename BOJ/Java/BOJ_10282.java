import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10282 {
	
	static int n;
	static List<Computer>[] list;
	static int[] distance;
	
	static class Computer implements Comparable<Computer> {
		int num;
		int time;
		
		public Computer(int num, int time) {
			this.num = num;
			this.time = time;
		}
		
		@Override
		public int compareTo(Computer o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n+1];
			for (int j = 0; j < n+1; j++) {
				list[j] = new ArrayList<>();
			}
			for (int j = 0; j < d; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				list[b].add(new Computer(a, s));
			}
			
			distance = new int[n+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[c] = 0;
			
			dijkstra(c);
			
			int cnt = 0;
			int max = 0;
			for (int j = 1; j < n+1; j++) {
				if (distance[j] != Integer.MAX_VALUE) {
					cnt++;
					max = Math.max(max, distance[j]);
				}
			}
			sb.append(cnt + " " + max + "\n");
		}
		System.out.println(sb);
	}
	
	private static void dijkstra(int c) {
		PriorityQueue<Computer> pq = new PriorityQueue<>();
		pq.offer(new Computer(c, 0));
		boolean[] visited = new boolean[n+1];
		
		while (!pq.isEmpty()) {
			Computer cur = pq.poll();
			
			if (visited[cur.num]) continue;
			visited[cur.num] = true;
			
			for (int i = 0; i < list[cur.num].size(); i++) {
				Computer temp = list[cur.num].get(i);
				if (distance[temp.num] > distance[cur.num] + temp.time) {
					distance[temp.num] = distance[cur.num] + temp.time;
					pq.offer(new Computer(temp.num, distance[temp.num]));
				}
			}
		}
	}

}
