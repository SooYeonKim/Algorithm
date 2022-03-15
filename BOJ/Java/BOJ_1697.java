import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	
	static int N, K;
	static boolean[] visited;
	static int time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		
		bfs();
		System.out.println(time);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N, 0});
		visited[N] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (cur[0] == K) {
				time = cur[1];
				return;
			}
			
			if (cur[0] - 1 >= 0 && !visited[cur[0] - 1]) {
				q.offer(new int[] {cur[0] - 1, cur[1] + 1});
				visited[cur[0] - 1] = true;
			}
			
			if (cur[0] + 1 <= 100000 && !visited[cur[0] + 1]) {
				q.offer(new int[] {cur[0] + 1, cur[1] + 1});
				visited[cur[0] + 1] = true;
			}
			
			if (cur[0] * 2 <= 100000 && !visited[cur[0] * 2]) {
				q.offer(new int[] {cur[0] * 2, cur[1] + 1});
				visited[cur[0] * 2] = true;
			}
		}
	}

}
