import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17615 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] array = br.readLine().toCharArray();
		int result = Integer.MAX_VALUE;
		
		//왼쪽으로 빨간색 볼 모으기
		int cnt = 0;
		boolean check = false;
		for (int i = 0; i < N; i++) {
			if (check && array[i] == 'R') {
				cnt++;
				continue;
			}
			
			if (array[i] == 'B') check = true;
		}
		
		result = Math.min(result, cnt);
		
		//왼쪽으로 파란색 볼 모으기
		cnt = 0;
		check = false;
		for (int i = 0; i < N; i++) {
			if (check && array[i] == 'B') {
				cnt++;
				continue;
			}
			
			if (array[i] == 'R') check = true;
		}
		
		result = Math.min(result, cnt);
		
		//오른쪽으로 빨간색 볼 모으기
		cnt = 0;
		check = false;
		for (int i = N-1; i >= 0; i--) {
			if (check && array[i] == 'R') {
				cnt++;
				continue;
			}
			
			if (array[i] == 'B') check = true;
		}
		
		result = Math.min(result, cnt);
		
		//오른쪽으로 파란색 볼 모으기
		cnt = 0;
		check = false;
		for (int i = N-1; i >= 0; i--) {
			if (check && array[i] == 'B') {
				cnt++;
				continue;
			}
			
			if (array[i] == 'R') check = true;
		}
		
		result = Math.min(result, cnt);
		
		System.out.println(result);
	}

}
