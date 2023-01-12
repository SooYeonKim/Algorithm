import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2457 {
	
	static int N;
	static PriorityQueue<Flower> pq;
	static int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	static class Flower implements Comparable<Flower> {
		int s;
		int e;
		
		public Flower(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Flower o) {
			if (this.s == o.s) {
				return this.e - o.e;
			}
			return this.s - o.s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sm = Integer.parseInt(st.nextToken());
			int sd = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			
			int start = sd;
			for (int j = 1; j < sm; j++) {
				start += day[j];
			}
			int end = ed;
			for (int j = 1; j < em; j++) {
				end += day[j];
			}
			
			pq.offer(new Flower(start, end));
		}
		
		int result = 0;
		int temp = 60;
		while (!pq.isEmpty()) {
			boolean check = false;
			int c = temp;
			while (!pq.isEmpty() && pq.peek().s <= c) {
				temp = Math.max(temp, pq.poll().e);
				check = true;
			}
			
			if (check) result++;
			else break;
			
			if (temp > 334) break;
		}
		
		if (temp > 334) System.out.println(result);
		else System.out.println(0);
	}

}
