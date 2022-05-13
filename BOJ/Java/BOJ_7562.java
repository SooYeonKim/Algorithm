import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
	
	static int l;
	static int[] start;
	static int[] end;
	static int[][] d = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
						{1, -2}, {2, -1}, {2, 1}, {1, 2}};
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			l = Integer.parseInt(br.readLine());
			start = new int[2];
			end = new int[2];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			
			bfs();
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start[0], start[1], 0});
		boolean[][] visited = new boolean[l][l];
		visited[start[0]][start[1]] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (cur[0] == end[0] && cur[1] == end[1]) {
				result = cur[2];
				return;
			}
			
			for (int i = 0; i < 8; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 0 || nx >= l || ny < 0 || ny >= l || visited[nx][ny]) continue;
				
				q.offer(new int[] {nx, ny, cur[2] + 1});
				visited[nx][ny] = true;
			}
		}
	}

}
