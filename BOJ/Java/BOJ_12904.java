import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12904 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder goal = new StringBuilder(br.readLine());
		StringBuilder word = new StringBuilder(br.readLine());
		
		int result = 0;
		while (word.length() > goal.length()) {
			if (word.charAt(word.length()-1) == 'A') {
				word.setLength(word.length()-1);
			} else if (word.charAt(word.length()-1) == 'B') {
				word.setLength(word.length()-1);
				word.reverse();
			}

			if (word.toString().equals(goal.toString())) result = 1;
		}

		System.out.println(result);
	}

}
