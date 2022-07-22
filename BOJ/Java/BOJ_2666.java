import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2666 {
	
	static int N, M, result;
	static int[] array;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		result = Integer.MAX_VALUE;
		array = new int[M];
		for (int i = 0; i < M; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		recursion(A, B, 0, 0);
		System.out.println(result);
	}
	
	private static void recursion(int open1, int open2, int cnt, int move) {
		if (cnt == M) {
			result = Math.min(result, move);
			return;
		}
		
		recursion(array[cnt], open2, cnt + 1, move + Math.abs(open1 - array[cnt]));
		recursion(open1, array[cnt], cnt + 1, move + Math.abs(open2 - array[cnt]));
	}

}
