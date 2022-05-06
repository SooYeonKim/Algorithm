import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int cnt = 0;
		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			cnt += (a + b);
			pq.offer(a + b);
		}
		
		System.out.println(cnt);
	}

}
