import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20061 {
	
	static boolean[][] green;
	static boolean[][] blue;
	static int score;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		green = new boolean[6][4];
		blue = new boolean[4][6];
		int N = Integer.parseInt(br.readLine());
		for (int k = 0; k < N; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//초록색 보드에 블록 놓기
			putGreenBoard(t, x, y);
			
			//파란색 보드에 블록 놓기
			putBlueBoard(t, x, y);
			
			//초록색 보드 타일 지우기
			removeGreenBoard();
			
			//파란색 보드 타일 지우기
			removeBlueBoard();
			
			//초록색 보드 연한색 칸 처리
			moveLightGreenBoard();
			
			//파란색 보드 연한색 칸 처리
			moveLightBlueBoard();
		}
		
		System.out.println(score);
		
		int cnt = 0;
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 3; j++) {
				if (green[i][j]) cnt++;
				if (blue[j][i]) cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	private static void putGreenBoard(int t, int x, int y) {
		if (t == 1) {
			green[0][y] = true;
			int idx = 1;
			while (idx <= 5 && !green[idx][y]) {
				green[idx-1][y] = false;
				green[idx][y] = true;
				idx++;
			}
		} else if (t == 2) {
			green[0][y] = true;
			green[0][y+1] = true;
			int idx = 1;
			while (idx <= 5 && !green[idx][y] && !green[idx][y+1]) {
				green[idx-1][y] = false;
				green[idx-1][y+1] = false;
				green[idx][y] = true;
				green[idx][y+1] = true;
				idx++;
			}
		} else {
			green[0][y] = true;
			green[1][y] = true;
			int idx = 2;
			while (idx <= 5 && !green[idx][y]) {
				green[idx-2][y] = false;
				green[idx][y] = true;
				idx++;
			}
		}
	}
	
	private static void putBlueBoard(int t, int x, int y) {
		if (t == 1) {
			blue[x][0] = true;
			int idx = 1;
			while (idx <= 5 && !blue[x][idx]) {
				blue[x][idx-1] = false;
				blue[x][idx] = true;
				idx++;
			}
		} else if (t == 2) {
			blue[x][0] = true;
			blue[x][1] = true;
			int idx = 2;
			while (idx <= 5 && !blue[x][idx]) {
				blue[x][idx-2] = false;
				blue[x][idx] = true;
				idx++;
			}
		} else {
			blue[x][0] = true;
			blue[x+1][0] = true;
			int idx = 1;
			while (idx <= 5 && !blue[x][idx] && !blue[x+1][idx]) {
				blue[x][idx-1] = false;
				blue[x+1][idx-1] = false;
				blue[x][idx] = true;
				blue[x+1][idx] = true;
				idx++;
			}
		}
	}
	
	private static void removeGreenBoard() {
		for (int i = 5; i >= 2; i--) {
			if (green[i][0] && green[i][1] && green[i][2] && green[i][3]) {
				score++;
				for (int j = i; j > 0; j--) {
					for (int k = 0; k < 4; k++) {
						green[j][k] = green[j-1][k];
						green[j-1][k] = false;
					}
				}
				i++;
			}
		}
	}
	
	private static void removeBlueBoard() {
		for (int i = 5; i >= 2; i--) {
			if (blue[0][i] && blue[1][i] && blue[2][i] && blue[3][i]) {
				score++;
				for (int j = i; j > 0; j--) {
					for (int k = 0; k < 4; k++) {
						blue[k][j] = blue[k][j-1];
						blue[k][j-1] = false;
					}
				}
				i++;
			}
		}
	}
	
	private static void moveLightGreenBoard() {
		int cnt = 0;
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j < 4; j++) {
				if (green[i][j]) {
					cnt++;
					break;
				}
			}
		}
		
		if (cnt == 0) return;
		
		for (int i = 5; i >= 2; i--) {
			for (int j = 0; j < 4; j++) {
				green[i][j] = green[i-cnt][j];
				green[i-cnt][j] = false;
			}
		}
	}
	
	private static void moveLightBlueBoard() {
		int cnt = 0;
		for (int j = 0; j <= 1; j++) {
			for (int i = 0; i < 4; i++) {
				if (blue[i][j]) {
					cnt++;
					break;
				}
			}
		}
		
		if (cnt == 0) return;
		
		for (int j = 5; j >= 2; j--) {
			for (int i = 0; i < 4; i++) {
				blue[i][j] = blue[i][j-cnt];
				blue[i][j-cnt] = false;
			}
		}
	}

}
