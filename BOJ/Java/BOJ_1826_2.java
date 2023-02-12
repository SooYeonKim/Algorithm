import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1826_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> gasStation = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		PriorityQueue<Integer> fuel = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			gasStation.offer(new int[] {a, b});
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int result = 0;
		while (P < L) {
			while (!gasStation.isEmpty() && gasStation.peek()[0] <= P) {
				fuel.offer(gasStation.poll()[1]);
			}
			
			if (fuel.isEmpty()) break;
			
			P += fuel.poll();
			result++;
		}
		
		if (P < L) System.out.println(-1);
		else System.out.println(result);
	}

}
