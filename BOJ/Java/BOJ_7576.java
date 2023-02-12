import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	
	static int N, M, total, result;
	static int[][] array;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if (array[i][j] == 0) total++;
			}
		}
		
		bfs();
		
		if (total != 0) System.out.println(-1);
		else System.out.println(result);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (array[i][j] == 1) {
					q.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		int time = 0;
		
		while (!q.isEmpty()) {
			if (total == 0) {
				result = time;
				break;
			}
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = cur[0] + d[j][0];
					int ny = cur[1] + d[j][1];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
					if (array[nx][ny] == 0) {
						q.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
						total--;
					}
				}
			}
			
			time++;
		}
	}

}
