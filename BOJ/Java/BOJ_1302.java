import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_1302 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		TreeMap<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}
		
		int max = 0;
		String result = "";
		for (String str : map.keySet()) {
			if (map.get(str) > max) {
				max = map.get(str);
				result = str;
			}
		}
		
		System.out.println(result);
	}

}
