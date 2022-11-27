import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9935 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String boom = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			
			if (sb.length() >= boom.length()) {
				boolean flag = true;
				for (int j = 0; j < boom.length(); j++) {
					if (sb.charAt(sb.length() - boom.length() + j) != boom.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				if (flag) {
					sb.setLength(sb.length() - boom.length());
				}
			}
		}
		
		if (sb.length() == 0) System.out.println("FRULA");
		else System.out.println(sb);
	}

}
