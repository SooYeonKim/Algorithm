import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {
	
	static class Jewelry implements Comparable<Jewelry> {
		int weight;
		int price;
		
		public Jewelry(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
		
		@Override
		public int compareTo(Jewelry o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Jewelry> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			list.add(new Jewelry(w, p));
		}
		
		int[] bag = new int[K];
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		Collections.sort(list);
		Arrays.sort(bag);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		long sum = 0;
		int idx = 0;
		for (int i = 0; i < K; i++) {
			while (idx < N && list.get(idx).weight <= bag[i]) {
				pq.offer(list.get(idx).price);
				idx++;
			}
			
			if (!pq.isEmpty()) {
				sum += pq.poll();
			}
		}
		
		System.out.println(sum);
	}

}
