import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9095_3 {
	
	static int n, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			result = 0;
			
			recursion(0);
			System.out.println(result);
		}
	}
	
	private static void recursion(int sum) {
		if (sum >= n) {
			if (sum == n) result++;
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			recursion(sum + i);
		}
	}

}
