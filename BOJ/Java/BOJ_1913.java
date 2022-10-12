import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1913 {
	
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		int[][] array = new int[N][N];
		
		int nx = N/2;
		int ny = N/2;
		int idx = 1;
		int dir = 0;
		int r = 1;
		array[nx][ny] = idx++;
		here: while (true) {
			for (int t = 0; t < 2; t++) {
				for (int i = 0; i < r; i++) {
					nx += d[dir][0];
					ny += d[dir][1];
					array[nx][ny] = idx++;
					
					if (nx == 0 && ny == 0) break here;
				}
				dir = (dir + 1) % 4;
			}
			r++;
		}
		
		int rx = 0;
		int ry = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (array[i][j] == num) {
					rx = i + 1;
					ry = j + 1;
				}
				sb.append(array[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.append(rx + " " + ry);
		System.out.println(sb);
	}

}
