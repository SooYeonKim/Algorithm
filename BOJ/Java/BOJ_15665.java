import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_15665 {
	
	static int N, M;
	static int[] array;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> treeSet = new TreeSet<>(); 
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			treeSet.add(Integer.parseInt(st.nextToken()));
		}
		
		array = new int[treeSet.size()];
		int idx = 0;
		for (Integer num : treeSet) {
			array[idx++] = num;
		}
		
		selected = new int[M];
		permutation(0);
		
		System.out.println(sb);
	}
	
	private static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < array.length; i++) {
			selected[cnt] = array[i];
			permutation(cnt + 1);
		}
	}

}
