import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_2 {
	
	static int k;
	static int[] array;
	static int[] selected;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
			
			array = new int[k];
			selected = new int[k];
			for (int i = 0; i < k; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void combination(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < k; i++) {
			selected[cnt] = array[i];
			combination(cnt + 1, i + 1);
		}
	}

}
