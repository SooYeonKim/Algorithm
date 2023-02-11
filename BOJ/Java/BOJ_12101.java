import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12101 {
	
	static int N, M, order;
	static boolean flag;
	static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		recursion(0, "");
		
		if (result == null) System.out.println(-1);
		else System.out.println(result);
	}
	
	private static void recursion(int sum, String str) {
		if (sum > N) return;
		if (sum == N) {
			if (++order == M) {
				result = str.substring(0, str.length() - 1);
			}
			
			return;
		}
		
		for (int i = 1; i <= 3; i++) {
			recursion(sum + i, str + i + "+");
			
			if (flag) return;
		}
	}

}
