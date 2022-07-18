import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005 {
	
	static int N, K, W;
	static int[] tArr;
	static int[] indegree;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			tArr = new int[N+1];
			indegree = new int[N+1];
			list = new ArrayList[N+1];
			for (int i = 0; i < N+1; i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < N+1; i++) {
				tArr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				list[X].add(Y);
				indegree[Y]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			topologicalSort();
		}
	}
	
	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			if (indegree[i] == 0) {
				result[i] = tArr[i];
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			Integer cur = q.poll();				
			
			for (Integer num : list[cur]) {
				indegree[num]--;
				result[num] = Math.max(result[num], result[cur] + tArr[num]);
				
				if (indegree[num] == 0) q.offer(num);
			}
		}
		
		System.out.println(result[W]);
	}

}
