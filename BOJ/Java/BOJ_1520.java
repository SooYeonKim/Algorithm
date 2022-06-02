import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520 {
	
	static int N, M;
	static int[][] array;
	static int[][] dp;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

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
		
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(dfs(0, 0));
	}
	
	private static int dfs(int x, int y) {
		if (x == N - 1 && y == M - 1) return 1;
		if (dp[x][y] != -1) return dp[x][y];
		
		dp[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			
			if (array[x][y] > array[nx][ny]) {
				dp[x][y] += dfs(nx, ny);
			}
		}
		
		return dp[x][y];
	}

}
