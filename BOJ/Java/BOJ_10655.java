import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10655 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N][2];
		int dist = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
			
			if (i != 0) {
				dist += Math.abs(array[i][0] - array[i-1][0]) + Math.abs(array[i][1] - array[i-1][1]);
			}
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 1; i < N-1; i++) {
			int subtract = Math.abs(array[i][0] - array[i-1][0]) + Math.abs(array[i][1] - array[i-1][1])
							+ Math.abs(array[i][0] - array[i+1][0]) + Math.abs(array[i][1] - array[i+1][1]);
			int add = Math.abs(array[i-1][0] - array[i+1][0]) + Math.abs(array[i-1][1] - array[i+1][1]);
			int temp = dist - subtract + add;
			result = Math.min(result, temp);
		}
		
		System.out.println(result);
	}

}
