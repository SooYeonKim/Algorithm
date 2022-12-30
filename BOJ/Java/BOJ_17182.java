import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17182 {
	
	static int N, K, result;
	static int[][] array;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (i == k) continue;
				for (int j = 0; j < N; j++) {
					if (i == j || j == k) continue;
					if (array[i][j] > array[i][k] + array[k][j]) {
						array[i][j] = array[i][k] + array[k][j];
					}
				}
			}
		}
		
		result = Integer.MAX_VALUE;
		visited = new boolean[N];
		visited[K] = true;
		dfs(0, 0, K);
		
		System.out.println(result);
	}
	
	private static void dfs(int cnt, int sum, int prev) {
		if (cnt == N-1) {
			result = Math.min(result, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			dfs(cnt + 1, sum + array[prev][i], i);
			visited[i] = false;
		}
	}

}
