import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2023 {
	
	static int N;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		
		list = new ArrayList<>();
		
		recursion(0, 2, 0);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static void recursion(int cnt, int start, int num) {
		if (cnt == N) {
			list.add(num);
			return;
		}
		
		for (int i = start; i <= 9; i++) {
			if (isPrime(num * 10 + i)) {
				recursion(cnt + 1, 1, num * 10 + i);
			}
		}
	}
	
	private static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}

}
