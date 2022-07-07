import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1613 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean[][] array = new boolean[n+1][n+1];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			array[a][b] = true;
		}
		
		for (int t = 1; t < n+1; t++) {
			for (int i = 1; i < n+1; i++) {
				if (i == t) continue;
				for (int j = 1; j < n+1; j++) {
					if (i == j || j == t) continue;
					if (!array[i][t] || !array[t][j]) continue;
					
					array[i][j] = true;
				}
			}
		}
		
		int s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (array[a][b]) {
				System.out.println(-1);
			} else if (array[b][a]) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

}
