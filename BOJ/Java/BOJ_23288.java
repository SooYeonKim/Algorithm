import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23288 {
	
	static int N, M, K, dir, result;
	static int[][] array;
	static int[] cur;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] dice = {{0, 2, 0}, {4, 1, 3}, {0, 5, 0}, {0, 6, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dir = 1;
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cur = new int[2];
		
		for (int i = 0; i < K; i++) {
			move();
		}
		
		System.out.println(result);
	}
	
	private static void move() {
		//주사위 굴리기
		int nx = cur[0] + d[dir][0];
		int ny = cur[1] + d[dir][1];
		if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
			dir = (dir + 2) % 4;
			nx = cur[0] + d[dir][0];
			ny = cur[1] + d[dir][1];
		}
		
		cur[0] = nx;
		cur[1] = ny;
		
		if (dir == 0) {
			int temp = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = temp;
		} else if (dir == 1) {
			int temp = dice[3][1];
			dice[3][1] = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = temp;
		} else if (dir == 2) {
			int temp = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = temp;
		} else {
			int temp = dice[3][1];
			dice[3][1] = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = temp;
		}
		
		//점수 획득
		getScore();
		
		//이동 방향 결정
		if (dice[3][1] > array[cur[0]][cur[1]]) {
			dir = (dir + 1) % 4;
		} else if (dice[3][1] < array[cur[0]][cur[1]]) {
			dir = (dir + 3) % 4;
		}
	}
	
	private static void getScore() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {cur[0], cur[1]});
		boolean[][] visited = new boolean[N][M];
		visited[cur[0]][cur[1]] = true;
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + d[i][0];
				int ny = temp[1] + d[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
				if (array[nx][ny] == array[cur[0]][cur[1]]) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		
		result += cnt * array[cur[0]][cur[1]];
	}

}
