import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9095_2 {
	
	static int target;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			target = Integer.parseInt(br.readLine());
			result = 0;
			recursion(0);
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}
	
	private static void recursion(int sum) {
		if (sum >= target) {
			if (sum == target) result++;
			return;
		}
		
		recursion(sum + 1);
		recursion(sum + 2);
		recursion(sum + 3);
	}

}
