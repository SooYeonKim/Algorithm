import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10972 {
	
	static int N;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		if (np()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(numbers[i] + " ");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}
	
	private static boolean np() {
		int i = N-1;
		while (i > 0 && numbers[i-1] >= numbers[i]) i--;
		
		if (i == 0) return false;
		
		int j = N-1;
		while (numbers[i-1] >= numbers[j]) j--;
		
		swap(i-1, j);
		
		int k = N-1;
		while (i < k) {
			swap(i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
