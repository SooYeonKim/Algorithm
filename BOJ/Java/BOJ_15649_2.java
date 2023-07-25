import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_2 {
	
	static int N, M;
	static int[] selected;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
		permutation(0);
		
		System.out.println(sb);
	}
	
	private static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			selected[cnt] = i;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}

}
