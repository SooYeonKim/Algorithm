import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21608 {
	
	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		int fCnt;
		int bCnt;
		
		public Pos(int x, int y, int fCnt, int bCnt) {
			this.x = x;
			this.y = y;
			this.fCnt = fCnt;
			this.bCnt = bCnt;
		}
		
		@Override
		public int compareTo(Pos o) {
			if (o.fCnt == this.fCnt) {
				if (o.bCnt == this.bCnt) {
					if (this.x == o.x) {
						return this.y - o.y;
					}
					return this.x - o.x;
				}
				return o.bCnt - this.bCnt;
			}
			return o.fCnt - this.fCnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N][N];
		List<Integer>[] list = new ArrayList[N * N + 1];
		for (int i = 0; i < N * N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(2, 10);
		map.put(3, 100);
		map.put(4, 1000);
		
		for (int t = 1; t < N * N + 1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int no = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 4; i++) {
				list[no].add(Integer.parseInt(st.nextToken()));
			}
			
			PriorityQueue<Pos> pq = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (array[i][j] != 0) continue;
					
					int fCnt = 0;
					int bCnt = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + d[k][0];
						int ny = j + d[k][1];
						
						if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						if (list[no].contains(array[nx][ny])) fCnt++;
						if (array[nx][ny] == 0) bCnt++;
						pq.offer(new Pos(i, j, fCnt, bCnt));
					}
				}
			}
			
			Pos cur = pq.poll();
			array[cur.x][cur.y] = no;
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + d[k][0];
					int ny = j + d[k][1];
					
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if (list[array[i][j]].contains(array[nx][ny])) cnt++;
				}
				
				result += map.get(cnt);
			}
		}
		
		System.out.println(result);
	}

}
