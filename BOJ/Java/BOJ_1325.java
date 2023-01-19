import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {
	
	static int N, M;
	static List<Integer>[] list;
	static int[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
		}
		result = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, result[i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (result[i] == max) System.out.print(i + " ");
		}
	}
	
	private static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		boolean[] visited = new boolean[N+1];
		visited[num] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < list[cur].size(); i++) {
				int temp = list[cur].get(i);
				
				if (visited[temp]) continue;
				q.offer(temp);
				visited[temp] = true;
				result[temp]++;
			}
		}
	}

}
