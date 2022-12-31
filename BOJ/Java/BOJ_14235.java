import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14235 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		int n = Integer.parseInt(br.readLine());		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if (a == 0) {
				if (pq.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				for (int j = 0; j < a; j++) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
	}

}
