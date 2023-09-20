import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_4 {
	
	static int k;
	static int[] arr, selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
			
			arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
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
		
		for (int i = start; i < k; i++) {
			selected[cnt] = arr[i];
			combination(cnt + 1, i + 1);
		}
	}

}
