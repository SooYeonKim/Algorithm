import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_2179 {
	
	static class Word {
		int idx;
		String str;
		
		public Word(int idx, String str) {
			this.idx = idx;
			this.str = str;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Word> list = new ArrayList<>();
		Map<Integer, String> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			list.add(new Word(i, s));
			map.put(i, s);
		}
		
		int len = -1;
		List<int[]> temp = new ArrayList<>();
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j <  N; j++) {
				if (i == j) continue;
				
				String str1 = list.get(i).str;
				String str2 = list.get(j).str;
				
				int cnt = 0;
				for (int k = 0; k < Math.min(str1.length(), str2.length()); k++) {
					if (str1.charAt(k) == str2.charAt(k)) cnt++;
					else break;
				}
				
				if (cnt > len) {
					len = cnt;
					temp = new ArrayList<>();
					temp.add(new int[] {list.get(i).idx, list.get(j).idx});
				} else if (cnt == len) {
					temp.add(new int[] {list.get(i).idx, list.get(j).idx});
				}
			}
		}
		
		for (int i = 0; i < temp.size(); i++) {
			Arrays.sort(temp.get(i));
		}
		
		Collections.sort(temp, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		System.out.println(map.get(temp.get(0)[0]));
		System.out.println(map.get(temp.get(0)[1]));
	}

}
