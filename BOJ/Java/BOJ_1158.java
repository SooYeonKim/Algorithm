import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		sb.append("<");
		while (!q.isEmpty()) {
			for (int i = 1; i < K; i++) {
				int num = q.poll();
				q.offer(num);
			}
			sb.append(q.poll()).append(", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		
		System.out.println(sb);
	}

}
