import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939 {
	
	static int N, M;
	static List<Island>[] list;
	static int[] factory;
	
	static class Island {
		int to;
		int limit;
		
		public Island(int to, int limit) {
			this.to = to;
			this.limit = limit;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int max = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list[A].add(new Island(B, C));
			list[B].add(new Island(A, C));
			
			max = Math.max(max, C);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		factory = new int[2];
		factory[0] = Integer.parseInt(st.nextToken());
		factory[1] = Integer.parseInt(st.nextToken());
		
		int left = 0;
		int right = max;
		int result = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean flag = bfs(mid);
			
			if (flag) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean bfs(int mid) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(factory[0]);
		boolean[] visited = new boolean[N+1];
		visited[factory[0]] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			if (cur == factory[1]) return true;
			
			for (Island island : list[cur]) {
				if (visited[island.to] || island.limit < mid) continue;
				
				q.offer(island.to);
				visited[island.to] = true;
			}
		}
		
		return false;
	}

}
