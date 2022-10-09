import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15684 {
	
	static int N, M, H;
	static boolean[][] array;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		array = new boolean[H+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			array[a][b] = true;
		}
		
		flag = false;
		for (int i = 0; i <= 3; i++) {
			recursion(i, 0);
			
			if (flag) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
	}
	
	private static void recursion(int target, int cnt) {
		if (cnt == target) {
			isPossible();
			return;
		}
		
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (array[i][j-1] || array[i][j] || array[i][j+1]) continue;
				
				array[i][j] = true;
				recursion(target, cnt + 1);
				array[i][j] = false;
				
				if (flag) return;
			}
		}
	}
	
	private static void isPossible() {
		boolean check = true;
		for (int i = 1; i <= N; i++) {
			int r = 1;
			int c = i;
			
			while (r <= H) {
				if (array[r][c-1]) {
					c--;
				} else if (array[r][c]) {
					c++;
				}
				
				r++;
			}
			
			if (i != c) {
				check = false;
				break;
			}
		}
		
		if (check) flag = true;
	}

}
