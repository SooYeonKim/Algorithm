import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {
	
	static int n;
	static int[] array;
	static boolean[] visited;
	static boolean[] finished;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			array = new int[n+1];
			visited = new boolean[n+1];
			finished = new boolean[n+1];
			cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= n; i++) {
				recursion(i);
			}
			
			sb.append((n - cnt) + "\n");
		}
		
		System.out.println(sb);
	}
	
	private static void recursion(int num) {
		if (visited[num]) return;
		visited[num] = true;
		
		int next = array[num];
		if (visited[next]) {
			if (!finished[next]) {
				cnt++;
				for (int i = next; i != num; i = array[i]) {
					cnt++;
				}
			}
		} else {
			recursion(next);
		}
		
		finished[num] = true;
	}

}
