import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086 {

	static int N, M;
	static int[][] array;
	static int[][] d = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}}; 
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (array[i][j] == 0) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y, 0, 0});
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (cur[3] == 1) {
				result = Math.max(result, cur[2]);
				return;
			}
			
			for (int i = 0; i < 8; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
				
				q.offer(new int[] {nx, ny, cur[2] + 1, array[nx][ny]});
				visited[nx][ny] = true;
			}
		}
	}

}
