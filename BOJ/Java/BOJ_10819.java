import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819 {
	
	static int N;
	static int[] array;
	static int[] selected;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		selected = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		recursion(0);
		System.out.println(result);
	}
	
	public static void recursion(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(selected[i] - selected[i+1]);
			}
			
			result = Math.max(result, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			selected[cnt] = array[i];
			recursion(cnt + 1);
			visited[i] = false;
		}
	}

}
