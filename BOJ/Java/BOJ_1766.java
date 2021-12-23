import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1766 {
	
	static int N;
	static List<Integer>[] graph;
	static int[] indegree;
	static Queue<Integer> result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		indegree = new int[N+1];
		result = new LinkedList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			indegree[B]++;
		}
		
		topologicalSort();
		
		for (Integer i : result) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
	
	private static void topologicalSort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;
			}
		});
		
		for (int i = 1; i < N+1; i++) {
			if (indegree[i] == 0) pq.offer(i);
		}
		
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			result.offer(cur);
			
			for (int i = 0; i < graph[cur].size(); i++) {
				int temp = graph[cur].get(i);
				indegree[temp]--;
				
				if (indegree[temp] == 0) {
					pq.offer(temp);
				}
			}
		}
	}

}
