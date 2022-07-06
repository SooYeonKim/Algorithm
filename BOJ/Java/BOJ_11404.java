import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] array = new int[n+1][n+1];
		for (int i = 0; i < n+1; i++) {
			Arrays.fill(array[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (array[a][b] > c) array[a][b] = c;
		}
		
		for (int k = 1; k < n+1; k++) {
			for (int i = 1; i < n+1; i++) {
				if (i == k) continue;
				for (int j = 1; j < n+1; j++) {
					if (i == j || j == k) continue;
					if (array[i][k] == Integer.MAX_VALUE || array[k][j] == Integer.MAX_VALUE) continue;
					if (array[i][j] > array[i][k] + array[k][j]) {
						array[i][j] = array[i][k] + array[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if (array[i][j] == Integer.MAX_VALUE) sb.append(0 + " ");
				else sb.append(array[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
