import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
	
	static int N, M;
	static int[][] array;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int time;
	static int total;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if (array[i][j] == 1) total++;
			}
		}
		
		while (total != 0) {
			time++;
			bfs();
		}
		
		System.out.println(time);
		System.out.println(result);
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		List<int[]> list = new ArrayList<>();
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
				if (array[nx][ny] == 0) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				} else {
					visited[nx][ny] = true;
					list.add(new int[] {nx, ny});
				}
			}
		}
		
		if (total == list.size()) {
			result = total;
		}
		
		for (int i = 0; i < list.size(); i++) {
			int[] temp = list.get(i);
			array[temp[0]][temp[1]] = 0;
		}
		
		total -= list.size();
	}

}
