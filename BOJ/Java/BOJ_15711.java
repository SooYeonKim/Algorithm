import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15711 {
	
	private static List<Integer> primeList;
	private static boolean[] isPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		primeList = new ArrayList<>();
		isPrime = new boolean[2_000_001];
		Arrays.fill(isPrime, true);
		
		findPrime();
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long num = a + b;
			
			if (num < 4) {
				sb.append("NO\n");
			} else if (num % 2 == 0) {
				sb.append("YES\n");
			} else {
				if (checkPrime(num - 2)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}
		}
		
		System.out.println(sb);
	}
	
	private static boolean checkPrime(long num) {
		if (num <= 2_000_000) return isPrime[(int)num];
		
		boolean check = true;
		for (int i = 0; i < primeList.size(); i++) {
			int temp = primeList.get(i);
			if (temp * temp > num) break;
			if (num % temp == 0) {
				check = false;
				break;
			}
		}
		
		if (check) return true;
		else return false;
	}
	
	private static void findPrime() {
		for (int i = 3; i <= 2_000_000; i++) {
			boolean check = true;
			for (int j = 0; j < primeList.size(); j++) {
				long temp = primeList.get(j);
				if (temp * temp > i) break;
				if (i % temp == 0) {
					check = false;
					isPrime[i] = false;
					break;
				}
			}
			
			if (check) primeList.add(i);
		}
	}

}
