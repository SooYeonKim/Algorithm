import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10775 {
	
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		parent = new int[G+1];
		for (int i = 1; i < G+1; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		for (int i = 0; i < P; i++) {
			int num = find(Integer.parseInt(br.readLine()));
			if (num == 0) break;
			
			result++;
			union(num);
		}
		
		System.out.println(result);
	}
	
	private static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	private static void union(int a) {
		parent[a] = a - 1;
	}

}
