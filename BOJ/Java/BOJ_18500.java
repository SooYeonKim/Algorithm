import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18500 {
	
	static int R, C;
	static char[][] array;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		array = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				array[i][j] = str.charAt(j);
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int t = 0; t < N; t++) {
			int H = Integer.parseInt(st.nextToken());
			destroy(t, R-H);
			
			visited = new boolean[R][C];
			for (int i = 0; i < C; i++) {
				check(R-1, i);
			}
			
			gravity();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
	
	private static void destroy(int idx, int h) {
		if (idx % 2 == 0) {
			int y = 0;
			while (y < C) {
				if (array[h][y] == 'x') {
					array[h][y] = '.';
					break;
				}
				
				y++;
			}
		} else {
			int y = C-1;
			while (y >= 0) {
				if (array[h][y] == 'x') {
					array[h][y] = '.';
					break;
				}
				
				y--;
			}
		}
	}
	
	private static void check(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) continue;
				if (array[nx][ny] == 'x') {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	private static void gravity() {
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (array[i][j] == 'x' && !visited[i][j]) {
					list.add(new int[] {i, j});
					array[i][j] = '.';
				}
			}
		}
		
		if (list.size() == 0) return;
		
		boolean flag = true;
		while (flag) {
			for (int[] temp : list) {
				if (temp[0] + 1 >= R || array[temp[0] + 1][temp[1]] == 'x') {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				for (int i = 0; i < list.size(); i++) {
					list.get(i)[0] += 1;
				}
			}
		}
		
		for (int[] temp : list) {
			array[temp[0]][temp[1]] = 'x';
		}
	}

}
