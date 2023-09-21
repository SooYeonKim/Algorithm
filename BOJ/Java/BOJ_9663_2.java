import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9663_2 {
	
	static int N, result;
	static int[] array;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		
		recursion(0);
		System.out.println(result);
	}
	
	private static void recursion(int cnt) {
		if (cnt == N) {
			result++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			array[cnt] = i;
			
			if (isPossible(cnt)) {
				recursion(cnt + 1);
			}
		}
	}
	
	private static boolean isPossible(int cnt) {
		for (int i = 0; i < cnt; i++) {
			if (array[i] == array[cnt]) return false;
			if (Math.abs(i - cnt) == Math.abs(array[i] - array[cnt])) return false;
		}
		
		return true;
	}

}
