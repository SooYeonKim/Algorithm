import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1929 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		List<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < N+1; i++) {
			boolean check = true;
			for (int j = 0; j < primeList.size(); j++) {
				int temp = primeList.get(j);
				if (temp * temp > i) break;
				if (i % temp == 0) {
					check = false;
					break;
				}
			}
			
			if (check) primeList.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < primeList.size(); i++) {
			int temp = primeList.get(i);
			if (temp >= M && temp <= N) {
				sb.append(temp + "\n");
			}
		}
		System.out.println(sb);
	}

}
