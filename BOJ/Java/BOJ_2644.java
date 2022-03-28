import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
	
	static int n;
	static List<Integer>[] list;
	static int result = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		
		bfs(a, b);
		System.out.println(result);
	}
	
	private static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {a, 0});
		boolean[] visited = new boolean[n+1];
		visited[a] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (cur[0] == b) {
				result = cur[1];
				return;
			}
			
			for (int i = 0; i < list[cur[0]].size(); i++) {
				int temp = list[cur[0]].get(i);
				
				if (visited[temp]) continue;
				visited[temp] = true;
				q.offer(new int[] {temp, cur[1] + 1});
			}
		}
	}

}
