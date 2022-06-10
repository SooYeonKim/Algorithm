import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
	
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		recursion(N, r, c);
	}
	
	public static void recursion(int size, int r, int c) {
		if (size < 1) {
			System.out.println(cnt);
			return;
		}
		
		int temp = (int)Math.pow(2, size - 1);
		if (r < temp && c < temp) {
			recursion(size - 1, r, c);
		} else if (r < temp && c >= temp) {
			cnt += (temp * temp);
			recursion(size - 1, r, c - temp);
		} else if (r >= temp && c < temp) {
			cnt += (temp * temp * 2);
			recursion(size - 1, r - temp, c);
		} else {
			cnt += (temp * temp * 3);
			recursion(size - 1, r - temp, c - temp);
		}
	}

}
