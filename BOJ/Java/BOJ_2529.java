import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2529 {
	
	static int k;
	static boolean[] visited;
	static String[] array;
	static List<String> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		visited = new boolean[10];
		array = new String[k];
		list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < k; i++) {
			array[i] = st.nextToken();
		}
		
		permutation(0, "");
		Collections.sort(list);
		
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
	}
	
	private static void permutation(int cnt, String num) {
		if (cnt == k + 1) {
			list.add(num);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if (visited[i]) continue;
			
			if (cnt > 0) {
				if (array[cnt - 1].equals("<")) {
					if (num.charAt(cnt - 1) - '0' > i) continue;
				} else {
					if (num.charAt(cnt - 1) - '0' < i) continue;
				}
			}
			
			visited[i] = true;
			permutation(cnt + 1, num + i);
			visited[i] = false;
		}
	}

}
