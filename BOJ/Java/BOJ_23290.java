import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23290 {
	
	static Queue<Integer>[][] list;
	static int[] shark;
	static int[][] smell;
	static boolean[][] visited;
	static int maxEatFish;
	static int[] sharkMove;
	static int[][] dArrShark = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int[][] dArrFish = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		list = new LinkedList[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				list[i][j] = new LinkedList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int fx = Integer.parseInt(st.nextToken());
			int fy = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list[fx-1][fy-1].offer(d-1);
		}
		
		shark = new int[2];
		st = new StringTokenizer(br.readLine(), " ");
		shark[0] = Integer.parseInt(st.nextToken()) - 1;
		shark[1] = Integer.parseInt(st.nextToken()) - 1;
		
		smell = new int[4][4];
		
		for (int t = 1; t <= S; t++) {
			//물고기 복제
			Queue<Integer>[][] temp = new LinkedList[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					temp[i][j] = new LinkedList<>();
					for (Integer k : list[i][j]) {
						temp[i][j].add(k);
					}
				}
			}
			
			//물고기 이동
			moveFish();
			
			//상어 이동
			moveShark(t);
			
			//물고기 냄새 제거
			removeSmell(t);
			
			//복제된 물고기 포함시키기
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					for (Integer k : temp[i][j]) {
						list[i][j].add(k);
					}
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				result += list[i][j].size();
			}
		}
		System.out.println(result);
	}
	
	private static void moveFish() {
		Queue<Integer>[][] temp = new LinkedList[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				temp[i][j] = new LinkedList<>();
				int size = list[i][j].size();
				for (int k = 0; k < size; k++) {
					temp[i][j].offer(list[i][j].poll());
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int size = temp[i][j].size();
				for (int k = 0; k < size; k++) {
					int dir = temp[i][j].poll();
					
					boolean flag = false;
					for (int l = 0; l < 8; l++) {
						int nx = i + dArrFish[(dir - l + 8) % 8][0];
						int ny = j + dArrFish[(dir - l + 8) % 8][1];
						
						if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
						if (smell[nx][ny] != 0 || (nx == shark[0] && ny == shark[1])) continue;
						
						flag = true;
						list[nx][ny].offer((dir - l + 8) % 8);
						break;
					}
					
					if (!flag) list[i][j].offer(dir);
				}
			}
		}
	}
	
	private static void moveShark(int t) {
		maxEatFish = -1;
		sharkMove = new int[3];
		visited = new boolean[4][4];
		calSharkMove(0, shark[0], shark[1], 0, new int[3]);
		
		int nx = shark[0];
		int ny = shark[1];

		for (int i = 0; i < sharkMove.length; i++) {
			nx += dArrShark[sharkMove[i]][0];
			ny += dArrShark[sharkMove[i]][1];

			if (list[nx][ny].size() != 0) {
				smell[nx][ny] = t;
				list[nx][ny] = new LinkedList<>();
			}
		}

		shark[0] = nx;
		shark[1] = ny;
	}
	
	private static void calSharkMove(int cnt, int sx, int sy, int eatFish, int[] arr) {
		if (cnt == 3) {
			if (eatFish > maxEatFish) {
				maxEatFish = eatFish;
				for (int i = 0; i < 3; i++) {
					sharkMove[i] = arr[i];
				}
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = sx + dArrShark[i][0];
			int ny = sy + dArrShark[i][1];
			
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
			arr[cnt] = i;
			
			if (visited[nx][ny]) {
				calSharkMove(cnt + 1, nx, ny, eatFish, arr);
			} else {
				visited[nx][ny] = true;
				calSharkMove(cnt + 1, nx, ny, eatFish + list[nx][ny].size(), arr);
				visited[nx][ny] = false;
			}
		}
	}
	
	private static void removeSmell(int t) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (smell[i][j] == t - 2) {
					smell[i][j] = 0;
				}
			}
		}
	}

}
