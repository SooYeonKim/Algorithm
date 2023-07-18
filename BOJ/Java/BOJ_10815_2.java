import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_2 {
	
	static int N;
	static int[] array;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = N-1;
			int result = 0;
			
			while (left <= right) {
				int mid = (left + right) / 2;
				
				if (array[mid] == num) {
					result = 1;
					break;
				} else if (array[mid] > num) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			
			sb.append(result + " ");
		}
		
		System.out.println(sb);
	}

}
