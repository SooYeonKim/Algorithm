import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] array = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < i+1; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i+1; j++) {
				if (j == 0 ) {
					array[i][0] = array[i][0] + array[i-1][0];
				} else if (j == i) {
					array[i][i] = array[i][i] + array[i-1][i-1];
				} else {
					array[i][j] = array[i][j] + Math.max(array[i-1][j-1], array[i-1][j]);
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, array[n-1][i]);
		}
		System.out.println(result);
	}

}
