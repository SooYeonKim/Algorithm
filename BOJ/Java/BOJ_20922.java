import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cnt = new int[100001];
		int left = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			while (cnt[array[i]] == K) {
				cnt[array[left++]]--;
			}
			
			cnt[array[i]]++;
			result = Math.max(result, i - left + 1);
		}
		
		System.out.println(result);
	}

}
