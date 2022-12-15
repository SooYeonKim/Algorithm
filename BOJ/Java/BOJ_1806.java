import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] array = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] pSum = new int[N+1];
		for (int i = 1; i <= N; i++) {
			pSum[i] = pSum[i-1] + array[i-1];
		}
		
		int ans = Integer.MAX_VALUE;
		int left = 1;
		int right = 1;
		while (left <= N && right <= N) {
			if (pSum[right] - pSum[left-1] >= S && ans > right-left+1) {
				ans = right-left+1;
			}
			
			if (pSum[right] - pSum[left-1] < S) right++;
			else left++;
		}
		
		if (ans == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(ans);
	}

}
