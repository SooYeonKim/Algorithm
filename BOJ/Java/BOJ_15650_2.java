import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_2 {

	static int N, M;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		
		combination(0, 1);
		
		System.out.println(sb);
	}
	
	private static void combination(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= N; i++) {
			selected[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}

}
