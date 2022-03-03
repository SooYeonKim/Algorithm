import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987 {
	
	static int[][] array;
	static int[][] game = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}
							, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}
							, {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}};
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		array = new int[6][3];
		for (int tc = 0; tc < 4; tc++) {
			flag = false;
			int sum = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					array[i][j] = Integer.parseInt(st.nextToken());
					sum += array[i][j];
				}
			}
			
			if (sum != 30) {
				sb.append("0 ");
			} else {
				recursion(0);
				if (flag) sb.append("1 ");
				else sb.append("0 ");
			}
		}
		
		System.out.println(sb);
	}
	
	private static void recursion(int cnt) {
		if (cnt == 15) {
			flag = true;
			return;
		}
		
		int a = game[cnt][0];
		int b = game[cnt][1];
		
		if (array[a][0] > 0 && array[b][2] > 0) {
			array[a][0]--;
			array[b][2]--;
			recursion(cnt + 1);
			array[a][0]++;
			array[b][2]++;
		}
		
		if (array[a][1] > 0 && array[b][1] > 0) {
			array[a][1]--;
			array[b][1]--;
			recursion(cnt + 1);
			array[a][1]++;
			array[b][1]++;
		}
		
		if (array[a][2] > 0 && array[b][0] > 0) {
			array[a][2]--;
			array[b][0]--;
			recursion(cnt + 1);
			array[a][2]++;
			array[b][0]++;
		}
		
		if (flag) return;
	}

}
