import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1800 {
	
	static int N, P, K;
	static List<Node>[] list;
	static int[] dist;
	
	static class Node implements Comparable<Node> {
		int to;
		int price;
		
		public Node(int to, int price) {
			this.to = to;
			this.price = price;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.price - o.price;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int max = 0;
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
			
			max = Math.max(max, c);
		}
		
		dist = new int[N+1];
		
		int left = 0;
		int right = max;
		int result = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (dijkstra(mid)) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean dijkstra(int num) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (dist[cur.to] < cur.price) continue;
			
			for (int i = 0; i < list[cur.to].size(); i++) {
				Node temp = list[cur.to].get(i);
				
				int price = cur.price;
				if (temp.price > num) price++;
				
				if (dist[temp.to] > price) {
					dist[temp.to] = price;
					pq.offer(new Node(temp.to, price));
				}
			}
		}
		
		return dist[N] <= K;
	}

}
