import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2458 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] check = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			check[a][b] = true;
		}
		
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					if (check[i][k] && check[k][j]) {
						check[i][j] = true;
					}
				}
			}
		}
		
		int result = 0;
		for (int i = 1; i < N+1; i++) {
			int cnt = 0;
			for (int j = 1; j < N+1; j++) {
				if (check[i][j] || check[j][i]) cnt++;
			}
			
			if (cnt == N-1) result++;
		}
		
		System.out.println(result);
	}

}
