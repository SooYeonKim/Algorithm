import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16198 {
	
	static int N;
	static List<Integer> list;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		recursion(0, 0);
		System.out.println(result);
	}
	
	private static void recursion(int cnt, int energe) {
		if (N - cnt == 2) {
			result = Math.max(result, energe);
			return;
		}
		
		for (int i = 1; i < N - cnt - 1; i++) {
			int temp = list.get(i);
			list.remove(i);
			recursion(cnt + 1, energe + (list.get(i-1) * list.get(i)));
			list.add(i, temp);
		}
	}

}
