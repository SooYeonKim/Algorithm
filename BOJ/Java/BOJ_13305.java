import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long[] dist = new long[N-1];
		for (int i = 0; i < N-1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		long[] cost = new long[N];
		for (int i = 0; i < N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = 1; i < N; i++) {
			if (cost[i] > cost[i-1]) {
				cost[i] = cost[i-1];
			}
		}
		
		long result = 0;
		for (int i = 0; i < N-1; i++) {
			result += (dist[i] * cost[i]);
		}
		
		System.out.println(result);
	}

}
