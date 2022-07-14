import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15663 {
	
	static int N, M;
	static int[] array;
	static boolean[] visited;
	static Set<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		visited = new boolean[N];
		set = new HashSet<>();
		permutation(0, "");
	}
	
	private static void permutation(int cnt, String num) {
		if (cnt == M) {
			if (!set.contains(num)) {
				set.add(num);
				System.out.println(num);
			}
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			permutation(cnt + 1, num + array[i] + " ");
			visited[i] = false;
		}
	}

}
