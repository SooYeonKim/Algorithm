import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9663 {
	
	static int N;
	static boolean[] check1;
	static boolean[] check2;
	static boolean[] check3;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check1 = new boolean[N];
		check2 = new boolean[2 * N - 1];
		check3 = new boolean[2 * N - 1];
		
		recursion(0);
		System.out.println(result);
	}
	
	private static void recursion(int cnt) {
		if (cnt == N) {
			result++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (check1[i] || check2[cnt + i] || check3[N - 1 + cnt - i]) continue;
			
			check1[i] = true;
			check2[cnt + i] = true;
			check3[N - 1 + cnt - i] = true;
			recursion(cnt + 1);
			check1[i] = false;
			check2[cnt + i] = false;
			check3[N - 1 + cnt - i] = false;
		}
	}

}
