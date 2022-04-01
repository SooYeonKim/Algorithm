import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2206 {
	
	static int N, M;
	static int[][] array;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int result = -1;
	
	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		int cnt;
		boolean crash;
		
		public Pos(int x, int y, int cnt, boolean crash) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.crash = crash;
		}
		
		@Override
		public int compareTo(Pos o) {
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				array[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
		System.out.println(result);
	}
	
	private static void bfs() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(0, 0, 1, false));
		boolean[][][] visited = new boolean[N][M][2];
		visited[0][0][0] = true;
		
		while (!pq.isEmpty()) {
			Pos cur = pq.poll();
			
			if (cur.x == N-1 && cur.y == M-1) {
				result = cur.cnt;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + d[i][0];
				int ny = cur.y + d[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (array[nx][ny] == 1) {
					if (cur.crash || visited[nx][ny][1]) continue;
					pq.offer(new Pos(nx, ny, cur.cnt + 1, true));
					visited[nx][ny][1] = true;
				} else {
					if (cur.crash) {
						if (visited[nx][ny][1]) continue;
						pq.offer(new Pos(nx, ny, cur.cnt + 1, cur.crash));
						visited[nx][ny][1] = true;
					} else {
						if (visited[nx][ny][0]) continue;
						pq.offer(new Pos(nx, ny, cur.cnt + 1, cur.crash));
						visited[nx][ny][0] = true;
					}
				}
			}
		}
	}

}
