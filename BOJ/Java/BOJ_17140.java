import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17140 {
	
	static int rLength, cLength;
	static int[][] array;
	
	static class Num implements Comparable<Num> {
		int no;
		int cnt;
		
		public Num(int no, int cnt) {
			this.no = no;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Num o) {
			if (this.cnt == o.cnt) {
				return this.no - o.no;
			}
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		rLength = 3;
		cLength = 3;
		array = new int[101][101];
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 3; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		while (true) {
			if (array[r][c] == k) break;
			if (++time > 100) break;
			if (rLength >= cLength) {
				for (int i = 1; i <= rLength; i++) {
					rCal(i);
				}
			} else {
				for (int i = 1; i <= cLength; i++) {
					cCal(i);
				}
			}
		}
		
		if (time <= 100) System.out.println(time);
		else System.out.println(-1);
	}
	
	private static void rCal(int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= cLength; i++) {
			if (array[k][i] == 0) continue;
			map.put(array[k][i], map.getOrDefault(array[k][i], 0) + 1);
		}
		
		PriorityQueue<Num> pq = new PriorityQueue<>();
		for (Integer i : map.keySet()) {
			pq.offer(new Num(i, map.get(i)));
		}
		
		int idx = 0;
		while (!pq.isEmpty()) {
			Num num = pq.poll();
			array[k][++idx] = num.no;
			array[k][++idx] = num.cnt;
			
			if (idx == 100) break;
		}
		
		cLength = Math.max(cLength, idx);
		
		for (int i = idx + 1; i <= cLength; i++) {
			array[k][i] = 0;
		}
	}
	
	private static void cCal(int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= rLength; i++) {
			if (array[i][k] == 0) continue;
			map.put(array[i][k], map.getOrDefault(array[i][k], 0) + 1);
		}
		
		PriorityQueue<Num> pq = new PriorityQueue<>();
		for (Integer i : map.keySet()) {
			pq.offer(new Num(i, map.get(i)));
		}
		
		int idx = 0;
		while (!pq.isEmpty()) {
			Num num = pq.poll();
			array[++idx][k] = num.no;
			array[++idx][k] = num.cnt;
			
			if (idx == 100) break;
		}
		
		rLength = Math.max(rLength, idx);
		
		for (int i = idx + 1; i <= rLength; i++) {
			array[i][k] = 0;
		}
	}

}
