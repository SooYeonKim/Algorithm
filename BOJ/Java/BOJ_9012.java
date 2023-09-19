import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			char[] cArr = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			
			boolean flag = true;
			for (int i = 0; i < cArr.length; i++) {
				if (cArr[i] == '(') {
					stack.push('(');
				} else {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				}
			}
			
			if (flag && stack.isEmpty()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb);
	}

}
