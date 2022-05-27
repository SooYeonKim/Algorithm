import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1926 {
	
	static int n, m;
	static int[][] array;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		array = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] || array[i][j] == 0) continue;
				
				visited[i][j] = true;
				result = Math.max(result, dfs(i, j));
				cnt++;
			}
		}
		
		System.out.println(cnt);
		System.out.println(result);
	}
	
	private static int dfs(int x, int y) {
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
			if (visited[nx][ny] || array[nx][ny] == 0) continue;
			
			visited[nx][ny] = true;
			cnt += dfs(nx, ny);
		}
		
		return cnt;
	}

}
