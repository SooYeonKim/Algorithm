import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1446 {
	
	static class Road implements Comparable<Road> {
		int s;
		int e;
		int l;
		
		public Road(int s, int e, int l) {
			this.s = s;
			this.e = e;
			this.l = l;
		}
		
		@Override
		public int compareTo(Road o) {
			return this.s - o.s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		List<Road> list = new ArrayList<>();
		int[] dist = new int[D+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if (e > D || e-s <= d) continue;
			
			list.add(new Road(s, e, d));
		}
		
		Collections.sort(list);
		
		int idx = 0;
		int loc = 0;
		while (loc < D) {
			if (idx < list.size()) {
				Road r = list.get(idx);
				if (r.s == loc) {
					dist[r.e] = Math.min(dist[r.e], dist[r.s] + r.l);
					idx++;
				} else {
					dist[loc+1] = Math.min(dist[loc+1], dist[loc] + 1);
					loc++;
				}
			} else {
				dist[loc+1] = Math.min(dist[loc+1], dist[loc] + 1);
				loc++;
			}
		}
		
		System.out.println(dist[D]);
	}

}
