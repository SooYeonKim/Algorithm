import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
	
	static int n, m, sx, sy;
	static int[][] array;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		array = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if (array[i][j] == 2) {
					sx = i;
					sy = j;
				} else if (array[i][j] == 1) {
					array[i][j] = -1;
				}
			}
		}
		
		bfs();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(array[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sx, sy, 0});
		boolean[][] visited = new boolean[n][m];
		visited[sx][sy] = true;
		array[sx][sy] = 0;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
				if (array[nx][ny] == -1) {
					q.offer(new int[] {nx, ny, cur[2] + 1});
					visited[nx][ny] = true;
					array[nx][ny] = cur[2] + 1;
				}
			}
		}
	}

}
