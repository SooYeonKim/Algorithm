import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11060 {
	
	static int N;
	static int[] array;
	static int result = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		bfs();
		System.out.println(result);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		boolean[] visited = new boolean[N];
		visited[0] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (cur[0] == N-1) {
				result = cur[1];
				return;
			}
			
			for (int i = 1; i <= array[cur[0]]; i++) {
				int loc = cur[0] + i;
				if (loc >= N || visited[loc]) continue;
				q.offer(new int[] {loc, cur[1] + 1});
				visited[loc] = true;
			}
		}
	}

}
