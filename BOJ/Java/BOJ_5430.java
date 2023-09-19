import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_5430 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			char[] cmd = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String[] sArr = str.substring(1, str.length() - 1).split(",");
			
			Deque<Integer> dq = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				dq.offerLast(Integer.parseInt(sArr[i]));
			}
			
			boolean flag = true;
			boolean isLeft = true;
			for (int i = 0; i < cmd.length; i++) {
				if (cmd[i] == 'R') {
					isLeft = !isLeft;
				} else {
					if (dq.isEmpty()) {
						sb.append("error\n");
						flag = false;
						break;
					}
					
					if (isLeft) {
						dq.pollFirst();
					} else {
						dq.pollLast();
					}
				}
			}
			
			if (flag) {
				sb.append("[");
				int size = dq.size();
				if (isLeft) {
					for (int i = 0; i < size; i++) {
						sb.append(dq.pollFirst()).append(",");
					}
				} else {
					for (int i = 0; i < size; i++) {
						sb.append(dq.pollLast()).append(",");
					}
				}
				if (size > 0) sb.setLength(sb.length() - 1);
				sb.append("]\n");
			}
		}
		
		System.out.println(sb);
	}

}
