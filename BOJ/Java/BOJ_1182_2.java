import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_2 {
	
	static int N, S;
	static int[] array;
	static int target;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			target = i;
			combination(0, 0, 0);
		}
		
		System.out.println(result);
	}
	
	private static void combination(int cnt, int start, int sum) {
		if (cnt == target) {
			if (sum == S) result++;
			return;
		}
		
		for (int i = start; i < N; i++) {
			combination(cnt + 1, i + 1, sum + array[i]);
		}
	}

}
