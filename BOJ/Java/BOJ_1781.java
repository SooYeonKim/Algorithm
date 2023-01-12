import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1781 {
	
	static int N;
	static List<Cupramen> list;
	
	static class Cupramen implements Comparable<Cupramen> {
		int deadline;
		int cnt;
		
		public Cupramen(int deadline, int cnt) {
			this.deadline = deadline;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Cupramen o) {
			if (this.deadline == o.deadline) {
				return o.cnt - this.cnt;
			}
			return this.deadline - o.deadline;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int deadline = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			list.add(new Cupramen(deadline, cnt));
		}
		
		Collections.sort(list);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < list.size(); i++) {
			Cupramen cupramen = list.get(i);
			pq.offer(cupramen.cnt);
			
			if (pq.size() > cupramen.deadline) {
				pq.poll();
			}
		}
		
		int result = 0;
		for (int cnt : pq) {
			result += cnt;
		}
		System.out.println(result);
	}

}
