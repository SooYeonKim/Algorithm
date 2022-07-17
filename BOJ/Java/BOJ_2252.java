import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252 {
	
	static int N, M;
	static int[] indegree;
	static List<Integer>[] list;
	static List<Integer> result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N+1];
		list = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		result = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[A].add(B);
			indegree[B]++;
		}
		
		topologicalSort();
		
		for (Integer num : result) {
			System.out.print(num + " ");
		}
	}
	
	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < N+1; i++) {
			if (indegree[i] == 0) q.offer(i);
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			result.add(cur);
			
			for (Integer num : list[cur]) {
				indegree[num]--;
				
				if (indegree[num] == 0) q.offer(num);
			}
		}
	}

}
