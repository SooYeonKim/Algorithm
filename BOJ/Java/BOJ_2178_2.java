import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_2 {

	static int N, M;
	static int[][] array;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] cArray = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				array[i][j] = cArray[j] - '0';
			}
		}
		
		bfs();
		
		System.out.println(result);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 1});
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (cur[0] == N-1 && cur[1] == M-1) {
				result = cur[2];
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
				if (array[nx][ny] == 1) {
					q.offer(new int[] {nx, ny, cur[2] + 1});
					visited[nx][ny] = true;
				}
			}
		}
	}

}
