import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3665 {
	
	static int n;
	static int[] array, indegree;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			array = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			indegree = new int[n+1];
			list = new ArrayList[n+1];
			for (int i = 0; i < n+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					list[array[i]].add(array[j]);
					indegree[array[j]]++;
				}
			}
			
			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (list[a].contains(b)) {
					list[a].remove(Integer.valueOf(b));
					indegree[b]--;
					list[b].add(a);
					indegree[a]++;
				} else {
					list[b].remove(Integer.valueOf(a));
					indegree[a]--;
					list[a].add(b);
					indegree[b]++;
				}
			}
			
			topologicalSort();
		}
	}
	
	private static void topologicalSort() {
		int[] result = new int[n];
		int idx = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < n+1; i++) {
			if (indegree[i] == 0) q.offer(i);
		}
		
		while (!q.isEmpty()) {
			if (q.size() > 1) {
				System.out.println("?");
				return;
			}
			
			int cur = q.poll();
			result[idx++] = cur;
			
			for (int i = 0; i < list[cur].size(); i++) {
				int temp = list[cur].get(i);
				indegree[temp]--;
				
				if (indegree[temp] == 0) q.offer(temp);
			}
		}
		
		if (idx == n) {
			for (int i = 0; i < n; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}

}
