import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_3 {
	
	static int N;
	static int[] array;
	static int[] selected;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N == 0) break;
			
			array = new int[N];
			for (int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			selected = new int[6];
			combination(0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void combination(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			selected[cnt] = array[i];
			combination(cnt + 1, i + 1);
		}
	}

}
