import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1052 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int result = 0;
		while (true) {
			int cnt = 0;
			int tempN = N;
			while (tempN != 0) {
				if (tempN % 2 == 1) cnt++;
				tempN /= 2;
			}
			
			if (cnt <= K) break;
			N++;
			result++;
		}
		
		System.out.println(result);
	}

}
