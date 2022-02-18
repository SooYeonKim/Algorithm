import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10974 {
	
	static int N;
	static int[] selected;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		selected = new int[N];
		visited = new boolean[N];
		
		permutation(0);
		System.out.println(sb);
	}
	
	private static void permutation(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			selected[cnt] = (i + 1);
			permutation(cnt + 1);
			visited[i] = false;
		}
	}

}
