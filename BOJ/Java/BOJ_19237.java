import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19237 {
	
	static int N, M, k;
	static int[][] array;
	static int[] dShark;
	static int[][][] priority;
	static int[][][] smell;
	static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean flag;
	static int time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dShark = new int[M+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++) {
			dShark[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		priority = new int[M+1][4][4];
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				priority[i][j][0] = Integer.parseInt(st.nextToken()) - 1;
				priority[i][j][1] = Integer.parseInt(st.nextToken()) - 1;
				priority[i][j][2] = Integer.parseInt(st.nextToken()) - 1;
				priority[i][j][3] = Integer.parseInt(st.nextToken()) - 1;
			}
		}
		
		smell = new int[N][N][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				smell[i][j][0] = -1;
				smell[i][j][1] = -1;
			}
		}
		
		//냄새 뿌리기
		spreadSmell(0);
		
		while (time < 1000) {
			time++;
			
			//상어 이동
			moveShark();
			
			//냄새 뿌리기
			spreadSmell(time);
			
			//냄새 제거
			removeSmell();
			
			//1번 상어만 남았는지 확인
			checkOneShark();
			if (flag) break;
		}
		
		if (flag) System.out.println(time);
		else System.out.println(-1);
	}
	
	private static void spreadSmell(int time) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (array[i][j] != 0) {
					smell[i][j][0] = time;
					smell[i][j][1] = array[i][j];
				}
			}
		}
	}
	
	private static void moveShark() {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = array[i][j];
				array[i][j] = 0;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j] != 0) {
					int num = temp[i][j];
					int dir = dShark[num];
					
					boolean check = false;
					for (int k = 0; k < 4; k++) {
						int selectD = priority[num][dir][k];
						int nx = i + d[selectD][0];
						int ny = j + d[selectD][1];
						
						if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if (smell[nx][ny][0] != -1) continue;
						
						check = true;
						if (array[nx][ny] == 0 || num < array[nx][ny]) {
							array[nx][ny] = num;
							dShark[num] = selectD;
						}
						break;
					}
					
					if (!check) {
						for (int k = 0; k < 4; k++) {
							int selectD = priority[num][dir][k];
							int nx = i + d[selectD][0];
							int ny = j + d[selectD][1];
							
							if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
							if (smell[nx][ny][0] != -1 && smell[nx][ny][1] == num) {
								array[nx][ny] = num;
								dShark[num] = selectD;
								break;
							}
						}
					}
				}
			}
		}
	}
	
	private static void removeSmell() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (smell[i][j][0] != -1 && time - smell[i][j][0] >= k) {
					smell[i][j][0] = -1;
					smell[i][j][1] = -1;
				}
			}
		}
	}
	
	private static void checkOneShark() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (array[i][j] != 0) cnt++;
			}
		}
		
		if (cnt == 1) flag = true;
	}

}
