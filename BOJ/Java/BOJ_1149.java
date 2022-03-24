import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
			array[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			array[i][0] = array[i][0] + Math.min(array[i-1][1], array[i-1][2]);
			array[i][1] = array[i][1] + Math.min(array[i-1][0], array[i-1][2]);
			array[i][2] = array[i][2] + Math.min(array[i-1][0], array[i-1][1]);
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			result = Math.min(result, array[N-1][i]);
		}
		System.out.println(result);
	}

}
