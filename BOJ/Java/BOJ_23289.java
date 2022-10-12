import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23289 {
	
	static int R, C, K;
	static List<Heater> list;
	static int[][] array;
	static int[][] plus;
	static boolean[][][][] wall;
	static int[][] dArr = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int[][] spreadX = {{0, 0, 0}, {-1, 0, 1}, {-1, 0, 1}, {-1, -1, -1}, {1, 1, 1}};
	static int[][] spreadY = {{0, 0, 0}, {1, 1, 1}, {-1, -1, -1}, {-1, 0, 1}, {-1, 0, 1}};
	static int chocolate;
	
	static class Heater {
		int x;
		int y;
		int d;
		
		public Heater(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		array = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num != 0) {
					list.add(new Heater(i, j, num));
				}
			}
		}
		
		wall = new boolean[R][C][R][C];
		int W = Integer.parseInt(br.readLine());
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			x--;
			y--;
			
			if (t == 0) {
				wall[x][y][x-1][y] = true;
				wall[x-1][y][x][y] = true;
			} else {
				wall[x][y][x][y+1] = true;
				wall[x][y+1][x][y] = true;
			}
		}
		
		while (chocolate <= 100) {
			//온풍기에서 바람이 나옴
			wind();
			
			//온도가 조절됨
			adjust();
			
			//바깥쪽 칸의 온도가 1씩 감소
			decrease();
			
			//초콜릿 먹기
			chocolate++;
			
			//모든 칸의 온도가 K 이상이 되었는지 검사
			if (check()) break;
		}
		
		System.out.println(chocolate);
	}
	
	private static void wind() {
		plus = new int[R][C];
		for (int i = 0; i < list.size(); i++) {
			Heater heater = list.get(i);
			int x = heater.x;
			int y = heater.y;
			int d = heater.d;
			
			if (d == 5) continue;
			spreadWind(x, y, d);
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				array[i][j] += plus[i][j];
			}
		}
	}
	
	private static void spreadWind(int x, int y, int d) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		int nx = x + dArr[d][0];
		int ny = y + dArr[d][1];
		q.offer(new int[] {nx, ny, 5});
		visited[nx][ny] = true;
		plus[nx][ny] += 5;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (cur[2] == 1) break;
			
			for (int i = 0; i < 3; i++) {
				nx = cur[0] + spreadX[d][i];
				ny = cur[1] + spreadY[d][i];
				
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny]) continue;
				if (isWall(cur[0], cur[1], nx, ny, d)) continue;
				
				q.offer(new int[] {nx, ny, cur[2] - 1});
				visited[nx][ny] = true;
				plus[nx][ny] += (cur[2] - 1);
			}
		}
	}
	
	private static boolean isWall(int x, int y, int nx, int ny, int d) {
		if (x == nx || y == ny) {
			return wall[x][y][nx][ny];
		} else {
			if (d == 1 || d == 2) {
				return (wall[x][y][nx][y] || wall[nx][y][nx][ny]);
			} else {
				return (wall[x][y][x][ny] || wall[x][ny][nx][ny]);
			}
		}
	}
	
	private static void adjust() {
		plus = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (array[i][j] != 0) {
					for (int k = 1; k <= 4; k++) {
						int nx = i + dArr[k][0];
						int ny = j + dArr[k][1];
						
						if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
						if (isWall(i, j, nx, ny, k)) continue;
						if (array[i][j] > array[nx][ny]) {
							int diff = (array[i][j] - array[nx][ny]) / 4;
							plus[i][j] -= diff;
							plus[nx][ny] += diff;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				array[i][j] += plus[i][j];
			}
		}
	}
	
	private static void decrease() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i == 0 || i == R-1 || j == 0 || j == C-1) {
					if (array[i][j] >= 1) array[i][j]--;
				}
			}
		}
	}
	
	private static boolean check() {
		boolean flag = true;
		for (int i = 0; i < list.size(); i++) {
			Heater heater = list.get(i);
			if (heater.d == 5) {
				if (array[heater.x][heater.y] < K) {
					flag = false;
					break;
				}
			}
		}
		
		return flag;
	}

}
