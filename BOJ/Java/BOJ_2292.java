import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2292 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int idx = 6;
		int result = 1;
		while (cnt < N) {
			cnt += idx;
			idx += 6;
			result++;
		}
		
		System.out.println(result);
	}

}
