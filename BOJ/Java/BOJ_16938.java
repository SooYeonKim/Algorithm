import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16938 {
	
	static int N, L, R, X;
	static int[] array;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		array = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		System.out.println(result);
	}
	
	private static void subset(int cnt, int count, int sum, int max, int min) {
		if (cnt == N) {
			if (count >= 2 && sum >= L && sum <= R && max - min >= X) result++;
			return;
		}
		
		subset(cnt + 1, count, sum, max, min);
		subset(cnt + 1, count + 1, sum + array[cnt], Math.max(max, array[cnt]), Math.min(min, array[cnt]));
	}

}
