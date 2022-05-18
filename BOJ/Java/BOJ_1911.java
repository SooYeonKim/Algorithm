import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1911 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] array = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		int loc = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			int start = array[i][0];
			int end = array[i][1];
			int temp = 0;
			
			if (start < loc) {
				if (end < loc) continue;
				
				temp = end - loc;
				int cnt = (temp / L);
				if (temp % L != 0) cnt++;
				result += cnt;
				loc += (L * cnt);
			} else {
				temp = end - start;
				int cnt = (temp / L);
				if (temp % L != 0) cnt++;
				result += cnt;
				loc = start + (L * cnt);
			}
		}
		
		System.out.println(result);
	}

}
