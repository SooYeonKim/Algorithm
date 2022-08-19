import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1719 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] array = new int[n+1][n+1];
		for (int i = 1; i < n+1; i++) {
			Arrays.fill(array[i], Integer.MAX_VALUE);
			array[i][i] = 0;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			array[a][b] = c;
			array[b][a] = c;
		}
		
		int[][] result = new int[n+1][n+1];
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				result[i][j] = j;
			}
		}
		for (int k = 1; k < n+1; k++) {
			for (int i = 1; i < n+1; i++) {
				if (i == k) continue;
				for (int j = 1; j < n+1; j++) {
					if (i == j || j == k) continue;
					if (array[i][k] == Integer.MAX_VALUE || array[k][j] == Integer.MAX_VALUE) continue;
					if (array[i][j] > array[i][k] + array[k][j]) {
						array[i][j] = array[i][k] + array[k][j];
						result[i][j] = result[i][k];
					}
				}
			}
		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if (i == j) System.out.print("-" + " ");
				else System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

}
