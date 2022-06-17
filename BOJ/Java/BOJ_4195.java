import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_4195 {
	
	static int[] parent;
	static int[] count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			HashMap<String, Integer> map = new HashMap<>();
			int F = Integer.parseInt(br.readLine());
			parent = new int[F * 2];
			for (int i = 0; i < F * 2; i++) {
				parent[i] = i;
			}
			count = new int[F * 2];
			Arrays.fill(count, 1);
			
			StringTokenizer st;
			int idx = 0;
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				
				if (!map.containsKey(f1)) {
					map.put(f1, idx++);
				}
				if (!map.containsKey(f2)) {
					map.put(f2, idx++);
				}
				
				System.out.println(union(map.get(f1), map.get(f2)));
			}
		}
	}
	
	private static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
	
	private static int union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		if (ra == rb) return count[ra];
		
		if (ra < rb) {
			parent[rb] = ra;
			count[ra] += count[rb];
			return count[ra];
		} else {
			parent[ra] = rb;
			count[rb] += count[ra];
			return count[rb];
		}
	}

}
