import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {
	
	static int R, C;
	static char[][] array;
	static int[][] d = {{-1, 1}, {0, 1}, {1, 1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		array = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] cArr = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				array[i][j] = cArr[j];
			}
		}
		
		int result = 0;
		for (int i = 0; i < R; i++) {
			if (recursion(i, 0)) result++;
		}
		
		System.out.println(result);
	}
	
	private static boolean recursion(int x, int y) {
		if (y == C-1) {
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			
			if (nx >= 0 && nx < R && array[nx][ny] == '.') {
				array[nx][ny] = 'x';
				if (recursion(nx, ny)) return true;
			}
		}
		
		return false;
	}

}
