import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {
	
	static int w, h;
	static char[][] array;
	static int[] start;
	static Queue<int[]> fireList;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			array = new char[h][w];
			start = new int[2];
			fireList = new LinkedList<>();
			result = Integer.MAX_VALUE;
			
			for (int i = 0; i < h; i++) {
				char[] cArray = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					array[i][j] = cArray[j];
					
					if (array[i][j] == '@') {
						start[0] = i;
						start[1] = j;
						array[i][j] = '.';
					} else if (array[i][j] == '*') {
						fireList.offer(new int[] {i, j});
					}
				}
			}
			
			bfs();
			
			if (result != Integer.MAX_VALUE) {
				sb.append(result + "\n");
			} else {
				sb.append("IMPOSSIBLE\n");
			}
		}
		
		System.out.println(sb);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {start[0], start[1]});
		boolean[][] visited = new boolean[h][w];
		visited[start[0]][start[1]] = true;
		int time = 0;
		
		while (!q.isEmpty()) {
			time++;
			
			int size = fireList.size();
			for (int i = 0; i < size; i++) {
				int[] cur = fireList.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = cur[0] + d[j][0];
					int ny = cur[1] + d[j][1];
					
					if (nx < 0 || nx >= h || ny < 0 || ny >= w || array[nx][ny] != '.') continue;
					
					array[nx][ny] = '*';
					fireList.offer(new int[] {nx, ny});
				}
			}
				
			size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = cur[0] + d[j][0];
					int ny = cur[1] + d[j][1];
					
					if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
						result = time;
						return;
					}
					if (visited[nx][ny] || array[nx][ny] != '.') continue;
					
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}

}
