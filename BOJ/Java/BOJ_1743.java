import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743 {
	
	static int N, M, K;
	static boolean[][] array;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new boolean[N+1][M+1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			array[r][c] = true;
		}
		
		visited = new boolean[N+1][M+1];
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (visited[i][j] || !array[i][j]) continue;
				
				int cnt = dfs(i, j);
				result = Math.max(result, cnt);
			}
		}
		
		System.out.println(result);
	}
	
	private static int dfs(int x, int y) {
		visited[x][y] = true;
		
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			
			if (nx <= 0 || nx > N || ny <= 0 || ny > M || visited[nx][ny]) continue;
			if (!array[nx][ny]) continue;
			
			cnt += dfs(nx, ny);
		}
		
		return cnt;
	}

}
