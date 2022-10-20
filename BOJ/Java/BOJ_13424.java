import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13424 {
	
	static int N, M;
	static int[][] array;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			array = new int[N+1][N+1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(array[i], Integer.MAX_VALUE);
				array[i][i] = 0;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				array[a][b] = c;
				array[b][a] = c;
			}
			
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if (array[i][k] == Integer.MAX_VALUE || array[k][j] == Integer.MAX_VALUE) continue;
						if (array[i][j] > array[i][k] + array[k][j]) {
							array[i][j] = array[i][k] + array[k][j];
						}
					}
				}
			}
			
			int K = Integer.parseInt(br.readLine());
			int[] friend = new int[K];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < K; i++) {
				friend[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 0; j < K; j++) {
					sum += array[friend[j]][i];
				}
				
				if (sum < min) {
					result = i;
					min = sum;
				}
			}
			
			System.out.println(result);
		}
	}

}
