import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1978 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		List<Integer> primeList = new ArrayList<>();
		boolean[] isPrime = new boolean[array[N-1] + 1];
		for (int i = 2; i < array[N-1] + 1; i++) {
			boolean check = true;
			for (int j = 0; j < primeList.size(); j++) {
				if (primeList.get(j) * primeList.get(j) > i) break;
				if (i % primeList.get(j) == 0) {
					check = false;
					break;
				}
			}
			
			if (check) {
				primeList.add(i);
				isPrime[i] = true;
			}
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (isPrime[array[i]]) result++;
		}
		System.out.println(result);
	}

}
