import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9207 {
	
	static char[][] array;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int totalPin;
	static int resultPin;
	static int resultCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			array = new char[5][9];
			totalPin = 0;
			for (int i = 0; i < 5; i++) {
				String str = br.readLine();
				for (int j = 0; j < 9; j++) {
					array[i][j] = str.charAt(j);
					if (array[i][j] == 'o') totalPin++;
				}
			}
			
			br.readLine();
			resultPin = totalPin;
			resultCnt = 0;
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 9; j++) {
					if (array[i][j] == 'o') {
						dfs(i, j, totalPin, 0);
					}
				}
			}
			
			sb.append(resultPin + " " + resultCnt + "\n");
		}
		
		System.out.println(sb);
	}
	
	private static void dfs(int x, int y, int remainPin, int moveCnt) {
		if (remainPin < resultPin) {
			resultPin = remainPin;
			resultCnt = moveCnt;
		} else if (remainPin == resultPin && moveCnt < resultCnt) {
			resultCnt = moveCnt;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			int nnx = nx + d[i][0];
			int nny = ny + d[i][1];
			
			if (nx < 0 || nx >= 5 || ny < 0 || ny >= 9
					|| nnx < 0 || nnx >= 5 || nny < 0 || nny >= 9) continue;
			if (array[nx][ny] != 'o') continue;
			if (array[nnx][nny] != '.') continue;
			
			array[x][y] = '.';
			array[nx][ny] = '.';
			array[nnx][nny] = 'o';
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 9; k++) {
					if (array[j][k] == 'o') {
						dfs(j, k, remainPin - 1, moveCnt + 1);
					}
				}
			}
			array[x][y] = 'o';
			array[nx][ny] = 'o';
			array[nnx][nny] = '.';
		}
	}

}
