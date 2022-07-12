import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2887 {
	
	static int N;
	static int[] parent;
	
	static class Tunnel implements Comparable<Tunnel> {
		int from;
		int to;
		int cost;
		
		public Tunnel(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Tunnel o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new int[] {i, x, y, z});
		}
		
		PriorityQueue<Tunnel> pq = new PriorityQueue<>();
		for (int i = 1; i <= 3; i++) {
			int idx = i;
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[idx] - o2[idx];
				}
			});
			
			for (int j = 0; j < N-1; j++) {
				int p1 = list.get(j)[0];
				int p2 = list.get(j+1)[0];
				int cost = Math.abs(list.get(j)[idx] - list.get(j+1)[idx]);
				pq.offer(new Tunnel(p1, p2, cost));
			}
		}
		
		parent = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			Tunnel cur = pq.poll();
			
			if (!union(cur.from, cur.to)) continue;
			result += cur.cost;
			if (++cnt == N-1) break;
		}
		
		System.out.println(result);
	}
	
	static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pa == pb) return false;
		
		parent[pb] = pa;
		return true;
	}

}
