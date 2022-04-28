import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] array = new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, array[i]);
		}
		
		int left = 0;
		int right = max;
		long result = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (array[i] > mid) {
					sum += (array[i] - mid);
				}
			}
			
			if (sum >= M) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(result);
	}

}
