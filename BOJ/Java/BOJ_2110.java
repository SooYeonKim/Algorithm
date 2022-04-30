import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		
		int left = 0;
		int right = array[N-1] - array[0];
		int result = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = 1;
			int loc = array[0];
			for (int i = 1; i < N; i++) {
				if (array[i] - loc >= mid) {
					cnt++;
					loc = array[i];
				}
			}
			
			if (cnt >= C) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(result);
	}

}
