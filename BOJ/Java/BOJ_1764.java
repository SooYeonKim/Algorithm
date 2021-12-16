import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1764 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		TreeSet<String> treeSet = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			treeSet.add(str);
		}
		
		TreeSet<String> result = new TreeSet<>();
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (treeSet.contains(str)) {
				result.add(str);
			}
		}
		
		sb.append(result.size() + "\n");
		for (String str : result) {
			sb.append(str + "\n");
		}
		System.out.println(sb);
	}

}
