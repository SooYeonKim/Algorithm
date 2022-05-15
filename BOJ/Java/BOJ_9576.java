import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9576 {
	
	static int N, M;
	static List<Integer>[] list;
	static boolean[] check;
	static int[] s;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[M+1];
			for (int j = 0; j < M+1; j++) {
				list[j] = new ArrayList<>();
			}
			
			for (int j = 1; j < M+1; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				for (int k = a; k <= b; k++) {
					list[j].add(k);
				}
			}
			
			check = new boolean[N+1];
			s = new int[N+1];
			
			int result = 0;
			for (int j = 1; j < M+1; j++) {
				Arrays.fill(check, false);
				if (dfs(j)) result++; 
			}
			
			System.out.println(result);
		}
	}
	
	private static boolean dfs(int student) {
		for (int i = 0; i < list[student].size(); i++) {
			int temp = list[student].get(i);
			if (!check[temp]) {
				check[temp] = true;
				if (s[temp] == 0 || dfs(s[temp])) {
					s[temp] = student;
					return true;
				}
			}
		}
		
		return false;
	}

}
