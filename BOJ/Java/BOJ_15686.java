import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {
	
	static int N, M;
	static List<int[]> house;
	static List<int[]> chicken;
	static int[][] selected;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		selected = new int[M][2];
		result = Integer.MAX_VALUE;
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N+1; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					house.add(new int[] {i, j});
				} else if (temp == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		
		combination(0, 0);
		System.out.println(result);
	}
	
	private static void combination(int cnt, int start) {
		if (cnt == M) {
			calculate();
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			selected[cnt][0] = chicken.get(i)[0];
			selected[cnt][1] = chicken.get(i)[1];
			combination(cnt + 1, i + 1);
		}
	}
	
	private static void calculate() {
		int sum = 0;
		for (int[] h : house) {
			int min = Integer.MAX_VALUE;
			for (int[] s : selected) {
				int temp = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
				min = Math.min(min, temp);
			}
			sum += min;
		}
		
		result = Math.min(result, sum);
	}

}
