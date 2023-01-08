import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17141 {
	
	static int N, M, cntZero, result;
	static int[][] array;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static List<Pos> list;
	static int[] selected;
	
	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][N];
		list = new ArrayList<>();
		selected = new int[M];
		result = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if (array[i][j] == 2) {
					list.add(new Pos(i, j));
					array[i][j] = 0;
				}
				if (array[i][j] == 0) {
					cntZero++;
				}
			}
		}
		
		combination(0, 0);
		
		if (result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
	private static void combination(int cnt, int start) {
		if (cnt == M) {
			spread();
			return;
		}
		
		for (int i = start; i < list.size(); i++) {
			selected[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
	
	private static void spread() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			q.offer(new int[] {list.get(selected[i]).x, list.get(selected[i]).y});
			visited[list.get(selected[i]).x][list.get(selected[i]).y] = true;
		}
		int cnt = M;
		int time = 0;
		
		while (!q.isEmpty()) {
			if (cnt == cntZero) {
				result = Math.min(result, time);
				break;
			}
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = cur[0] + d[j][0];
					int ny = cur[1] + d[j][1];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
					if (array[nx][ny] == 0) {
						q.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
						cnt++;
					}
				}
			}
			
			time++;
		}
	}

}
