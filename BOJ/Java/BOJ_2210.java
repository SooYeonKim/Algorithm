import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2210 {
	
	static int[][] array;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static Set<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		array = new int[5][5];
		set = new HashSet<>();
		
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				recursion(0, i, j, array[i][j]);
			}
		}
		
		System.out.println(set.size());
	}
	
	public static void recursion(int cnt, int x, int y, int num) {
		if (cnt == 5) {
			set.add(num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + d[i][0];
			int ny = y + d[i][1];
			
			if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
				recursion(cnt + 1, nx, ny, num * 10 + array[nx][ny]);
			}
		}
	}

}
