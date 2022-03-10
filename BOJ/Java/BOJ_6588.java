import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_6588 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] isPrime = new boolean[1000001];
		for (int i = 2; i < 1000001; i++) {
			boolean flag = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
				if (j * j > i) break;
			}
			
			if (flag) isPrime[i] = true;
		}
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			
			boolean flag = false;
			int a = 0;
			int b = 0;
			for (int i = n-3; i >= n/2; i--) {
				if (!isPrime[i]) continue;
				b = i;
				
				if (!isPrime[n-i]) continue;
				a = n-i;
				flag = true;
				break;
			}
			
			if (flag) {
				sb.append(n + " = " + a + " + " + b + "\n");
			} else {
				sb.append("Goldbach's conjecture is wrong.\n");
			}
		}
		
		System.out.println(sb);
	}

}
