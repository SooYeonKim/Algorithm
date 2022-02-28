import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
	
	static int N;
	static int[][] array;
	static boolean[] check;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N+1][N+1];
		check = new boolean[N+1];
		result = Integer.MAX_VALUE;
		
		StringTokenizer st;
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N+1; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combination(0, 1);
		System.out.println(result);
	}
	
	private static void combination(int cnt, int start) {
		if (cnt == N/2) {
			calculate();
			return;
		}
		
		for (int i = start; i < N+1; i++) {
			check[i] = true;
			combination(cnt + 1, i + 1);
			check[i] = false;
		}
	}
	
	private static void calculate() {
		int sumStart = 0;
		int sumLink = 0;
		for (int i = 1; i < N+1; i++) {
			boolean flag = check[i];
			for (int j = 1; j < N+1; j++) {
				if (i == j) continue;
				if (check[j] == flag) {
					if (flag) {
						sumStart += array[i][j];
					} else {
						sumLink += array[i][j];
					}
				}
			}
		}
		
		result = Math.min(result, Math.abs(sumStart - sumLink));
	}

}
