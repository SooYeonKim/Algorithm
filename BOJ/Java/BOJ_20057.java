import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057 {
	
	static int N;
	static int[][] array;
	static int[][] d = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	static int[] percent = {5, 10, 10, 2, 7, 7, 2, 1, 1};
	static int[][] moveX = {{0, 1, -1, 2, 1, -1, -2, 1, -1},
							{2, 1, 1, 0, 0, 0, 0, -1, -1},
							{0, -1, 1, -2, -1, 1, 2, -1, 1},
							{-2, -1, -1, 0, 0, 0, 0, 1, 1}};
	static int[][] moveY = {{-2, -1, -1, 0, 0, 0, 0, 1, 1},
							{0, 1, -1, 2, 1, -1, -2, 1, -1},
							{2, 1, 1, 0 , 0, 0, 0, -1, -1},
							{0, -1, 1, -2, -1, 1, 2, -1, 1}};
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int nx = N/2;
		int ny = N/2;
		int dir = 0;
		int r = 1;
		here: while (true) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < r; j++) {
					nx += d[dir][0];
					ny += d[dir][1];
					
					int remain = array[nx][ny];
					for (int k = 0; k < 9; k++) {
						int nnx = nx + moveX[dir][k];
						int nny = ny + moveY[dir][k];
						int amount = array[nx][ny] * percent[k] / 100;
						remain -= amount;
						
						if (nnx < 0 || nnx >= N || nny < 0 || nny >= N) {
							result += amount;
							continue;
						}
						
						array[nnx][nny] += amount;
					}
					
					int nnx = nx + d[dir][0];
					int nny = ny + d[dir][1];
					if (nnx < 0 || nnx >= N || nny < 0 || nny >= N) {
						result += remain;
					} else {
						array[nnx][nny] += remain;
					}
					
					array[nx][ny] = 0;
					if (nx == 0 && ny == 0) break here;
				}
				
				dir = (dir + 1) % 4;
			}
			
			r++;
		}
		
		System.out.println(result);
	}

}
