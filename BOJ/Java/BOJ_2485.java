import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2485 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		int[] distance = new int[N-1];
		for (int i = 0; i < N-1; i++) {
			distance[i] = array[i+1] - array[i];
		}
		
		for (int i = 0; i < N-2; i++) {
			distance[i+1] = getGCD(distance[i], distance[i+1]);
		}
		
		int GCD = distance[N-2];
		System.out.println((array[N-1] - array[0]) / GCD + 1 - N);
	}
	
	private static int getGCD(int num1, int num2) {
		int a = Math.max(num1, num2);
		int b = Math.min(num1, num2);
		
		while (b > 0) {
			int r = a % b;
			
			a = b;
			b = r;
		}
		
		return a;
	}

}
