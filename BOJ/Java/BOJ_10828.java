import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10828 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[N];
		int size = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String cmd = st.nextToken();
			
			if (cmd.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack[size++] = num;
			} else if (cmd.equals("pop")) {
				if (size == 0) sb.append(-1 + "\n");
				else sb.append(stack[--size] + "\n");
			} else if (cmd.equals("size")) {
				sb.append(size + "\n");
			} else if (cmd.equals("empty")) {
				if (size == 0) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			} else if (cmd.equals("top")) {
				if (size == 0) sb.append(-1 + "\n");
				else sb.append(stack[size - 1] + "\n");
			}
		}
		
		System.out.println(sb);
	}

}
