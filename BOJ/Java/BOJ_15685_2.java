import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15685_2 {
	
	static int[][] dArr = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] array = new boolean[101][101];
		for (int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			List<Integer> list = new ArrayList<>();
			list.add(d);
			for (int i = 0; i < g; i++) {
				int size = list.size();
				for (int j = size - 1; j >= 0; j--) {
					list.add((list.get(j) + 1) % 4);
				}
			}
			
			array[x][y] = true;
			int nx = x;
			int ny = y;
			for (int i = 0; i < list.size(); i++) {
				nx += dArr[list.get(i)][0];
				ny += dArr[list.get(i)][1];
				
				if (nx < 0 || nx > 100 || ny < 0 | ny > 100) continue;
				array[nx][ny] = true;
			}
		}
		
		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (array[i][j] && array[i+1][j] && array[i][j+1] && array[i+1][j+1]) result++;
			}
		}
		
		System.out.println(result);
	}

}
