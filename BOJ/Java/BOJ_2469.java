import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2469 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		char[] cArray = new char[k];
		cArray = br.readLine().toCharArray();
		char[][] ladder = new char[n][k-1];
		int line = 0;
		for (int i = 0; i < n; i++) {
			ladder[i] = br.readLine().toCharArray();
			if (ladder[i][0] == '?') line = i;
		}
		
		char[] startArr = new char[k];
		for (char i = 0; i < k; i++) {
			int row = 0;
			int idx = i;
			while (true) {
				if (row == line) break;
				
				if (idx > 0 && ladder[row][idx-1] == '-') {
					idx--;
				} else if (idx < k-1 && ladder[row][idx] == '-') {
					idx++;
				}
				row++;
			}
			
			startArr[idx] = (char)('A' + i);
		}
		
		char[] endArr = new char[k];
		for (int i = 0; i < k; i++) {
			int row = n-1;
			int idx = i;
			while (true) {
				if (row == line) break;
				
				if (idx > 0 && ladder[row][idx-1] == '-') {
					idx--;
				} else if (idx < k-1 && ladder[row][idx] == '-') {
					idx++;
				}
				row--;
			}
			
			endArr[idx] = cArray[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k-1; i++) {
			if (startArr[i] == endArr[i]) {
				sb.append('*');
			} else if (startArr[i] == endArr[i+1] && startArr[i+1] == endArr[i]) {
				sb.append('-');
				if (i < k-2) {
					sb.append('*');
					i++;
				}
			} else {
				sb.setLength(0);
				for (int j = 0; j < k-1; j++) {
					sb.append('x');
				}
				break;
			}
		}
		
		System.out.println(sb);
	}

}
