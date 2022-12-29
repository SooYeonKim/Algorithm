import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15681 {
	
	static List<Integer>[] list;
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			list[U].add(V);
			list[V].add(U);
		}
		
		cnt = new int[N+1];
		dfs(R, -1);
		
		for (int i = 0; i < Q; i++) {
			int U = Integer.parseInt(br.readLine());
			System.out.println(cnt[U]);
		}
	}
	
	private static void dfs(int cur, int prev) {
		cnt[cur] = 1;
		
		for (int num : list[cur]) {
			if (num == prev) continue;
			
			dfs(num, cur);
			cnt[cur] += cnt[num];
		}
	}

}
