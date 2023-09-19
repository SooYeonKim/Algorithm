import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int temp = 0;
		Stack<Integer> stack = new Stack<>();
		boolean flag = true;
		for (int tc = 0; tc < n; tc++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num > temp) {
				for (int i = temp + 1; i <= num; i++) {
					stack.push(i);
					sb.append("+\n");
				}
				temp = num;
			} else if (stack.isEmpty() || stack.peek() != num) {
				flag = false;
				break;
			}
			
			stack.pop();
			sb.append("-\n");
		}
		
		if (flag) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}

}
