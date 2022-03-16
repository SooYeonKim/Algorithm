import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2178 {
	
	static int N, M;
	static int[][] array;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int result;
	
	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		int cnt;
		
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
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
			char[] cArray = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				array[i][j] = cArray[j] - '0';
			}
		}
		
		bfs();
		System.out.println(result);
	}
	
	public static void bfs() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(0, 0, 1));
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		
		while (!pq.isEmpty()) {
			Pos cur = pq.poll();
			
			if (cur.x == N - 1 && cur.y == M - 1) {
				result = cur.cnt;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + d[i][0];
				int ny = cur.y + d[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
				if (array[nx][ny] == 0) continue;
				
				pq.offer(new Pos(nx, ny, cur.cnt + 1));
				visited[nx][ny] = true;
			}
		}
	}

}
