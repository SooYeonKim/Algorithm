import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667 {
	
	static int N;
	static int[][] array;
	static boolean[][] visited;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] cArray = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				array[i][j] = cArray[j] - '0';
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (array[i][j] != 1 || visited[i][j]) continue;
				
				int cnt = bfs(i, j);
				list.add(cnt);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				if (array[nx][ny] != 1) continue;
				
				q.offer(new int[] {nx, ny});
				visited[nx][ny] = true;
				cnt++;
			}
		}
		
		return cnt;
	}

}
