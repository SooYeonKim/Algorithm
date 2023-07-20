import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10845 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		int f = 0;
		int b = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String cmd = st.nextToken();
			
			if (cmd.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				array[b++] = num;
			} else if (cmd.equals("pop")) {
				if (f == b) sb.append(-1 + "\n");
				else sb.append(array[f++] + "\n");
			} else if (cmd.equals("size")) {
				sb.append(((b-f) + "\n"));
			} else if (cmd.equals("empty")) {
				if (f == b) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			} else if (cmd.equals("front")) {
				if (f == b) sb.append(-1 + "\n");
				else sb.append(array[f] + "\n");
			} else if (cmd.equals("back")) {
				if (f == b) sb.append(-1 + "\n");
				else sb.append(array[b-1] + "\n");
			}
		}
		
		System.out.println(sb);
	}

}
