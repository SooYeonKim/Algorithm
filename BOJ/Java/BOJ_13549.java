import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {

	static int N, K;
	static int[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		System.out.println(visited[K]);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {N, 0});
		visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[N] = 0;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (cur[0] - 1 >= 0 && visited[cur[0] - 1] > cur[1] + 1) {
				q.offer(new int[] {cur[0] - 1, cur[1] + 1});
				visited[cur[0] - 1] = cur[1] + 1;
			}
			
			if (cur[0] + 1 <= 100000 && visited[cur[0] + 1] > cur[1] + 1) {
				q.offer(new int[] {cur[0] + 1, cur[1] + 1});
				visited[cur[0] + 1] = cur[1] + 1;
			}
			
			if (cur[0] * 2 <= 100000 && visited[cur[0] * 2] > cur[1]) {
				q.offer(new int[] {cur[0] * 2, cur[1]});
				visited[cur[0] * 2] = cur[1];
			}
		}
	}

}
