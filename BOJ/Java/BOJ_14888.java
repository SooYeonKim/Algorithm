import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
	
	static int N;
	static int[] array;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] op = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		recursion(1, array[0], op[0], op[1], op[2], op[3]);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void recursion(int cnt, int result, int op1, int op2, int op3, int op4) {
		if (cnt == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		if (op1 > 0) {
			recursion(cnt + 1, result + array[cnt], op1 - 1, op2, op3, op4);
		}
		
		if (op2 > 0) {
			recursion(cnt + 1, result - array[cnt], op1, op2 - 1, op3, op4);
		}
		
		if (op3 > 0) {
			recursion(cnt + 1, result * array[cnt], op1, op2, op3 - 1, op4);
		}
		
		if (op4 > 0) {
			recursion(cnt + 1, result / array[cnt], op1, op2, op3, op4 - 1);
		}
	}

}
