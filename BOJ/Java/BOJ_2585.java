import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2585 {
	
	static int n, k;
	static int[][] array;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		array = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = (int)Math.ceil(Math.sqrt(Math.pow((double)10000, 2) * 2) / 10);
		int result = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean flag = bfs(mid);
			
			if (flag) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(result);
	}
	
	private static boolean bfs(int mid) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 0});
		boolean[] visited = new boolean[n];
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if ((int)Math.ceil(Math.sqrt((Math.pow((double)(cur[0] - 10000), 2)) + Math.pow(cur[1] - 10000, 2)) / 10) <= mid) {
				if (cur[2] > k) return false;
				return true;
			}
			
			for (int i = 0; i < n; i++) {
				if (visited[i]) continue;
				
				int fuel = (int)Math.ceil(Math.sqrt((Math.pow((double)(cur[0] - array[i][0]), 2)) + Math.pow(cur[1] - array[i][1], 2)) / 10);
				if (fuel <= mid) {
					q.offer(new int[] {array[i][0], array[i][1], cur[2] + 1});
					visited[i] = true;
				}
			}
		}
		
		return false;
	}

}
