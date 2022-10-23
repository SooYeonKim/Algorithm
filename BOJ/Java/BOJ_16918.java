import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16918 {
	
	static int R, C, N;
	static int[][] array;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		array = new int[R][C];
		for (int i = 0; i < R; i++) {
			char[] cArray = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (cArray[j] == 'O') {
					array[i][j] = 2;
				} else {
					array[i][j] = -1;
				}
			}
		}
		
		for (int t = 2; t <= N; t++) {
			//폭탄 시간 감소
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (array[i][j] != -1) {
						array[i][j]--;
					}
				}
			}
			
			//폭탄 설치
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (array[i][j] == -1) {
						array[i][j] = 3;
					}
				}
			}
			
			//폭탄 폭발
			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (array[i][j] == 0) {
						list.add(new int[] {i, j});
						for (int k = 0; k < 4; k++) {
							int nx = i + d[k][0];
							int ny = j + d[k][1];
							if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
							list.add(new int[] {nx, ny});
						}
					}
				}
			}
			
			for (int[] loc : list) {
				array[loc[0]][loc[1]] = -1;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (array[i][j] == -1) {
					System.out.print('.');
				} else {
					System.out.print('O');
				}
			}
			System.out.println();
		}
	}

}
