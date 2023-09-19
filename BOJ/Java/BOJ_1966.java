import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1966 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
			}
			
			int order = 0;
			while (!q.isEmpty()) {
				int[] arr = q.poll();
				boolean isMax = true;
				
				for (int i = 0; i < q.size(); i++) {
					if (arr[1] < q.get(i)[1]) {
						q.offer(arr);
						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						isMax = false;
						break;
					}
				}
				
				if (!isMax) {
					continue;
				}
				
				order++;
				if (arr[0] == M) {
					System.out.println(order);
					break;
				}
			}
		}
	}

}
