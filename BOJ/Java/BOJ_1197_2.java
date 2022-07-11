import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1197_2 {
	
	static class Node {
		int to;
		int weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Node>[] list = new ArrayList[V+1];
		for (int i = 0; i < V+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list[A].add(new Node(B, C));
			list[B].add(new Node(A, C));
		}
		
		boolean[] visited = new boolean[V+1];
		int[] minEdge = new int[V+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		int result = 0;
		
		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for (int j = 1; j < V+1; j++) {
				if (!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					idx = j;
				}
			}
			
			visited[idx] = true;
			result += min;
			
			for (int j = 0; j < list[idx].size(); j++) {
				Node temp = list[idx].get(j);
				if (!visited[temp.to] && minEdge[temp.to] > temp.weight) {
					minEdge[temp.to] = temp.weight;
				}
			}
		}
		
		System.out.println(result);
	}

}
