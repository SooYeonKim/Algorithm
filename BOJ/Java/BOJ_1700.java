import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1700 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] array = new int[K];
		int max = 0;
		for (int i = 0; i < K; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, array[i]);
		}
		
		int cnt = 0;
		int result = 0;
		boolean[] check = new boolean[max+1];
		for (int i = 0; i < K; i++) {
			if (check[array[i]]) continue;
			
			if (cnt < N) {
				check[array[i]] = true;
				cnt++;
			} else {
				List<Integer> temp = new ArrayList<>();
				for (int j = i+1; j < K; j++) {
					if (check[array[j]] && !temp.contains(array[j])) {
						temp.add(array[j]);
					}
				}
				
				if (temp.size() == N) {
					check[temp.get(temp.size() - 1)] = false;
				} else {
					for (int j = 0; j < check.length; j++) {
						if (check[j] && !temp.contains(j)) {
							check[j] = false;
							break;
						}
					}
				}
						
				check[array[i]] = true;
				result++;
			}
		}
		
		System.out.println(result);
	}

}
