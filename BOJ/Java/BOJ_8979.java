import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_8979 {
	
	static int N, K;
	
	static class Nation implements Comparable<Nation> {
		int num;
		int gold;
		int silver;
		int bronze;
		
		public Nation(int num, int gold, int silver, int bronze) {
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		
		@Override
		public int compareTo(Nation o) {
			if (o.gold == this.gold) {
				if (o.silver == this.silver) {
					if (o.bronze == this.bronze) {
						if (this.num == K) return -1;
					}
					return o.bronze - this.bronze;
				}
				return o.silver - this.silver;
			}
			return o.gold - this.gold;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		List<Nation> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			list.add(new Nation(num, gold, silver, bronze));
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < N; i++) {
			if (list.get(i).num == K) {
				System.out.println(i + 1);
				break;
			}
		}
	}

}
