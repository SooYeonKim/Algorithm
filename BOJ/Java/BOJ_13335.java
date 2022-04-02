import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Queue<Integer> truck = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}
		
		Queue<Integer> q = new LinkedList<>();
		int time = 0;
		int weight = 0;
		for (int i = 0; i < w; i++) {
			q.offer(0);
		}
		
		while (!q.isEmpty()) {
			time++;
			weight -= q.poll();
			
			if (!truck.isEmpty()) {
				int t = truck.peek();
				if (weight + t <= L) {
					weight += t;
					q.offer(truck.poll());
				} else {
					q.offer(0);
				}
			}
		}
		
		System.out.println(time);
	}

}
