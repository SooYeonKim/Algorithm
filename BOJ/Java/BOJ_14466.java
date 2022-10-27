import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14466 {
	
	static int N, K, R;
	static boolean[][][][] road;
	static List<int[]> cowList;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		road = new boolean[N+1][N+1][N+1][N+1];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			road[r1][c1][r2][c2] = true;
			road[r2][c2][r1][c1] = true;
		}
		
		cowList = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			cowList.add(new int[] {x, y});
		}
		
		for (int i = 0; i < K; i++) {
			bfs(i);
		}
		
		System.out.println(cnt);
	}
	
	private static void bfs(int idx) {
		int x = cowList.get(idx)[0];
		int y = cowList.get(idx)[1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		boolean[][] visited = new boolean[N+1][N+1];
		visited[x][y] = true;
		boolean[] isPossible = new boolean[K];
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < K; i++) {
				int tx = cowList.get(i)[0];
				int ty = cowList.get(i)[1];
				
				if (cur[0] == tx && cur[1] == ty) {
					isPossible[i] = true;
					break;
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 1 || nx > N || ny < 1 || ny > N || visited[nx][ny]) continue;
				if (road[cur[0]][cur[1]][nx][ny]) continue;
				
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
		
		for (int i = idx+1; i < K; i++) {
			if (!isPossible[i]) cnt++;
		}
	}

}
