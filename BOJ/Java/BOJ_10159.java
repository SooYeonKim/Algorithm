import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10159 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[][] array = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			array[a][b] = true;
		}
		
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				if (i == k) continue;
				for (int j = 1; j < N+1; j++) {
					if (i == j || j == k) continue;
					if (!array[i][k] || !array[k][j]) continue;
					
					array[i][j] = true;
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			int cnt = 0;
			for (int j = 1; j < N+1; j++) {
				if (i == j) continue;
				if (!array[i][j] && !array[j][i]) cnt++;
			}
			
			System.out.println(cnt);
		}
	}

}
