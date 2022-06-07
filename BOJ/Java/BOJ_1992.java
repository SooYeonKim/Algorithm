import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992 {
	
	static int N;
	static char[][] array;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new char[N][N];
		for (int i = 0; i < N; i++) {
			array[i] = br.readLine().toCharArray();
		}
		
		recursion(N, 0, 0);
		System.out.println(sb);
	}
	
	public static void recursion(int size, int x, int y) {
		int cntZero = 0;
		int cntOne = 0;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (array[i][j] == '0') {
					cntZero++;
				} else {
					cntOne++;
				}
				
				if (cntZero != 0 && cntOne != 0) break;
			}
		}
		
		if (cntZero != 0 && cntOne != 0) {
			sb.append("(");
			recursion(size / 2, x, y);
			recursion(size / 2, x, y + size / 2);
			recursion(size / 2, x + size / 2, y);
			recursion(size / 2, x + size / 2, y + size / 2);
			sb.append(")");
		} else {
			if (cntZero != 0) {
				sb.append("0");
			} else {
				sb.append("1");
			}
		}
	}

}
