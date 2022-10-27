import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15591 {
	
	static int N, Q;
	static List<Node>[] list;
	
	static class Node {
		int to;
		int usado;
		
		public Node(int to, int usado) {
			this.to = to;
			this.usado = usado;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			list[p].add(new Node(q, r));
			list[q].add(new Node(p, r));
		}
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			bfs(k, v);
		}
	}
	
	private static void bfs(int k, int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		boolean[] visited = new boolean[N+1];
		visited[v] = true;
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < list[cur].size(); i++) {
				Node temp = list[cur].get(i);
				if (visited[temp.to]) continue;
				if (temp.usado < k) continue;
				
				q.offer(temp.to);
				visited[temp.to] = true;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
