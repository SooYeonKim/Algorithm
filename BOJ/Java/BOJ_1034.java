import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1034 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] sArray = new String[N];
		int[][] array = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			sArray[i] = str;
			char[] cArray = str.toCharArray();
			for (int j = 0; j < M; j++) {
				array[i][j] = cArray[j] - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[N];
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < M; j++) {
				if (array[i][j] == 0) cnt++;
			}
			
			if (cnt <= K && cnt % 2 == K % 2) check[i] = true;
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (!check[i]) continue;
			
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (sArray[i].equals(sArray[j])) cnt++;
			}
			
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
	}

}
