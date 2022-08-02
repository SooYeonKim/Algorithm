import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184 {
	
	static int R, C;
	static char[][] array;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int rSheep, rWolf;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		array = new char[R][C];
		for (int i = 0; i < R; i++) {
			array[i] = br.readLine().toCharArray();
		}
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[i][j] || array[i][j] == '#') continue;
				
				bfs(i, j);
			}
		}
		
		System.out.println(rSheep + " " + rWolf);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		int sheep = 0;
		int wolf = 0;
		if (array[x][y] == 'o') sheep++;
		else if (array[x][y] == 'v') wolf++;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if (array[nx][ny] == '#' || visited[nx][ny]) continue;
				
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
				
				if (array[nx][ny] == 'o') sheep++;
				else if (array[nx][ny] == 'v') wolf++;
			}
		}
		
		if (sheep > wolf) rSheep += sheep;
		else rWolf += wolf;
	}

}
