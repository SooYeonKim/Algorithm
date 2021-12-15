import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1094 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int result = 0;
		for (int i = 0; i <= 6; i++) {
			if ((X & 1 << i) != 0) result++;
		}
		
		System.out.println(result);
	}

}
