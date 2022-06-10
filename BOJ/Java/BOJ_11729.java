import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11729 {
	
	static int cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		recursion(N, 1, 3, 2);
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	private static void recursion(int n, int from, int to, int other) {
		if (n < 1) return;
		
		recursion(n - 1, from, other, to);
		cnt++;
		sb.append(from + " " + to + "\n");
		recursion(n - 1, other, to, from);
	}

}
