import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_1655 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (pq1.size() == pq2.size()) {
				pq1.offer(num);
			} else {
				pq2.offer(num);
			}
			
			if (!pq1.isEmpty() && !pq2.isEmpty() && (pq1.peek() > pq2.peek())) {
				int temp = pq1.poll();
				pq1.offer(pq2.poll());
				pq2.offer(temp);
			}
			
			sb.append(pq1.peek() + "\n");
		}
		
		System.out.println(sb);
	}

}
