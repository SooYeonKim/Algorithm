import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		while (min != 0) {
			int r = max % min;
			max = min;
			min = r;
		}
		
		System.out.println(max);
		System.out.println(a * b / max);
	}

}
