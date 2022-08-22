import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2531 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		int[] cArray = new int[d+1];
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (cArray[array[i]]++ == 0) cnt++;
		}
		
		int result = cnt;
		for (int i = 0; i < N; i++) {
			if (--cArray[array[i]] == 0) cnt--;
			if (cArray[array[(i + k) % N]]++ == 0) cnt++;
			if (cArray[c] == 0) {
				result = Math.max(result, cnt + 1);
			} else {
				result = Math.max(result, cnt);
			}
		}
		
		System.out.println(result);
	}

}
