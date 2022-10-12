import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23288_2 {
	
	static int N, M, K;
	static int[][] map;
	static int[][] dice;
	static int[] loc;
	static int dir;
	static int[][] dArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dice = new int[4][3];
		dice[0][1] = 2;
		dice[1][0] = 4;
		dice[1][1] = 1;
		dice[1][2] = 3;
		dice[2][1] = 5;
		dice[3][1] = 6;
		
		loc = new int[2];
		loc[0] = 1;
		loc[1] = 1;
		
		dir = 1;
		
		for (int i = 0; i < K; i++) {
			//주사위 굴리기
			roll();
			
			//점수 획득
			getScore();
			
			//이동 방향 결정
			setDir();
		}
		
		System.out.println(result);
	}
	
	private static void roll() {
		int nx = loc[0] + dArr[dir][0];
		int ny = loc[1] + dArr[dir][1];
		if (nx < 1 || nx > N || ny < 1 || ny > M) {
			dir = (dir + 2) % 4;
			nx = loc[0] + dArr[dir][0];
			ny = loc[1] + dArr[dir][1];
		}
		
		if (dir == 0) {
			int temp = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = temp;
		} else if (dir == 1) {
			int temp = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = dice[3][1];
			dice[3][1] = temp;
		} else if (dir == 2) {
			int temp = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = temp;
		} else if (dir == 3) {
			int temp = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = temp;
		}
		
		loc[0] = nx;
		loc[1] = ny;
	}
	
	private static void getScore() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {loc[0], loc[1]});
		boolean[][] visited = new boolean[N+1][M+1];
		visited[loc[0]][loc[1]] = true;
		int cnt = 1;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dArr[i][0];
				int ny = cur[1] + dArr[i][1];
				
				if (nx < 1 || nx > N || ny < 1 || ny > M || visited[nx][ny]) continue;
				if (map[nx][ny] == map[loc[0]][loc[1]]) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		
		result += (map[loc[0]][loc[1]] * cnt);
	}
	
	private static void setDir() {
		if (dice[3][1] > map[loc[0]][loc[1]]) {
			dir = (dir + 1) % 4;
		} else if (dice[3][1] < map[loc[0]][loc[1]]) {
			dir = (dir + 3) % 4;
		}
	}

}
