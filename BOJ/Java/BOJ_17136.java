import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136 {
	
	static int[][] array;
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		array = new int[10][10];
		result = Integer.MAX_VALUE;
		
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 10; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursion(0, 0, 0);
		
		if (result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
	static void recursion(int x, int y, int cnt) {
		if (cnt >= result) return;
		
		if (x == 9 && y == 10) {
			result = Math.min(result, cnt);
			return;
		}
		
		if (y == 10) {
			recursion(x+1, 0, cnt);
			return;
		}
		
		if (array[x][y] == 1) {
			for (int i = 1; i <= 5; i++) {
				if (paper[i] > 0 && check(x, y, i)) {
					paper[i]--;
					change(x, y, i, 0);
					recursion(x, y+i, cnt+1);
					paper[i]++;
					change(x, y, i, 1);
				}
			}
		} else {
			recursion(x, y+1, cnt);
		}
	}
	
	static boolean check(int x, int y, int size) {
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if (i == 10 || j == 10 || array[i][j] == 0) return false;
			}
		}
		
		return true;
	}
	
	static void change(int x, int y, int size, int num) {
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				array[i][j] = num;
			}
		}
	}

}
