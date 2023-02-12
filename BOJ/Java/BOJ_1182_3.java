import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_3 {
	
	static int N, S, result;
	static int[] array;

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
		
		subset(0, 0);
		
		if (S == 0) result--;
		System.out.println(result);
	}
	
	private static void subset(int cnt, int sum) {
		if (cnt == N) {
			if (sum == S) result++;
			return;
		}
		
		subset(cnt + 1, sum + array[cnt]);
		subset(cnt + 1, sum);
	}

}
