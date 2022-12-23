import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		}
		
		for (int i = 0; i < m; i++) {
			long x = pq.poll();
			long y = pq.poll();
			long sum = x + y;
			
			pq.offer(sum);
			pq.offer(sum);
		}
		
		long result = 0;
		while (!pq.isEmpty()) {
			result += pq.poll();
		}
		
		System.out.println(result);
	}

}
