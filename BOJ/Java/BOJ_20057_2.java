import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057_2 {
	
	static int N;
	static int[][] array;
	static int[][] dArr = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	static int[][] moveX = {{0, 1, -1, 2, 1, -1, -2, 1, -1},
							{2, 1, 1, 0, 0, 0, 0, -1, -1},
							{0, -1, 1, -2, -1, 1, 2, -1, 1},
							{-2, -1, -1, 0, 0, 0, 0, 1, 1}};
	static int[][] moveY = {{-2, -1, -1, 0, 0, 0, 0, 1, 1},
							{0, 1, -1, 2, 1, -1, -2, 1, -1},
							{2, 1, 1, 0, 0, 0, 0, -1, -1},
							{0, -1, 1, -2, -1, 1, 2, -1, 1}};
	static int[] percent = {5, 10, 10, 2, 7, 7, 2, 1, 1};
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int x = N/2;
		int y = N/2;
		int d = 0;
		int r = 1;
		here: while (true) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < r; j++) {
					x = x + dArr[d][0];
					y = y + dArr[d][1];
					
					int total = array[x][y];
					for (int k = 0; k < 9; k++) {
						int nx = x + moveX[d][k];
						int ny = y + moveY[d][k];
						int amount = array[x][y] * percent[k] / 100;
						
						if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
							result += amount;
						} else {
							array[nx][ny] += amount;
						}
						
						total -= amount;
					}
					
					int nx = x + dArr[d][0];
					int ny = y + dArr[d][1];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
						result += total;
					} else {
						array[nx][ny] += total;
					}
					
					array[x][y] = 0;
					if (x == 0 && y == 0) break here;
				}
				
				d = (d + 1) % 4;
			}
			
			r++;
		}
		
		System.out.println(result);
	}

}
