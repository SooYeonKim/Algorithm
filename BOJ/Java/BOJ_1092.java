import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1092 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] crane = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] box = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(crane);
		Arrays.sort(box);
		
		if (crane[N-1] < box[M-1]) {
			System.out.println(-1);
			return;
		}
		
		int result = 0;
		int[] idx = new int[N];
		Arrays.fill(idx, M-1);
		while (M > 0) {
			for (int i = N-1; i >= 0; i--) {
				if (M == 0) break;
				for (int j = idx[i]; j >= 0; j--) {
					if (box[j] == 0 || box[j] > crane[i]) {
						idx[i]--;
						continue;
					}
					
					box[j] = 0;
					M--;
					break;
				}
			}
			
			result++;
		}
		
		System.out.println(result);
	}

}
