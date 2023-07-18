import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2751 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i) + "\n");
		}
		System.out.println(sb);
	}

}
