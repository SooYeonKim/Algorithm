import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1644 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> primeList = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			boolean isPrime = true;
			for (int j = 0; j < primeList.size(); j++) {
				int temp = primeList.get(j);
				if (temp * temp > i) break;
				if (i % temp == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) primeList.add(i);
		}
		
		int result = 0;
		for (int i = 0; i < primeList.size(); i++) {
			int sum = 0;
			for (int j = i; j < primeList.size(); j++) {
				sum += primeList.get(j);
				if (sum >= N) break;
			}
			
			if (sum == N) result++;
		}
		System.out.println(result);
	}

}
