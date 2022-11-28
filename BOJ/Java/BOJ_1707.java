import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707 {
	
	static int V, E;
	static List<Integer>[] list;
	static int[] color;
	static boolean[] visited;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < K; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			for (int i = 0; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				
				list[u].add(v);
				list[v].add(u);
			}
			
			color = new int[V+1];
			visited = new boolean[V+1];
			flag = true;
			for (int i = 1; i <= V; i++) {
				if (!visited[i]) isPossible(i);
				if (!flag) break;
			}
			
			if (flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
	private static void isPossible(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		color[num] = 1;
		visited[num] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < list[cur].size(); i++) {
				int temp = list[cur].get(i);
				
				if (visited[temp]) {
					if (color[temp] == color[cur]) {
						flag = false;
						return;
					}
				} else {
					q.offer(temp);
					color[temp] = color[cur] * (-1);
					visited[temp] = true;
				}
			}
		}
	}

}
