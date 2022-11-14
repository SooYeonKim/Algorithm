import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
	
	static int N;
	static int[] array;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		for (int i = 0; i < N; i++) {
			binarySearch(i);
		}
		
		System.out.println(result);
	}
	
	private static void binarySearch(int target) {
		int left = 0;
		int right = N-1;
		
		while (left < right) {
			if (left == target) {
				left++;
				continue;
			} else if (right == target) {
				right--;
				continue;
			}
			
			if (array[left] + array[right] == array[target]) {
				result++;
				return;
			} else if (array[left] + array[right] < array[target]) {
				left++;
			} else {
				right--;
			}
		}
	}

}
