import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429 {
	
	static int N, K;
	static int[] array;
	static int[] selected;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		selected = new int[N];
		visited = new boolean[N];
		permutation(0);
		
		System.out.println(result);
	}
	
	private static void permutation(int cnt) {
		if (cnt == N) {
			recursion(0, 500);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			selected[cnt] = array[i];
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
	
	private static void recursion(int cnt, int weight) {
		if (weight < 500) return;
		if (cnt == N) {
			result++;
			return;
		}
		
		recursion(cnt + 1, weight + selected[cnt] - K);
	}

}
