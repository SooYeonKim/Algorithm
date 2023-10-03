import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20056 {
	
	static int N, M, K;
	static Queue<Fireball>[][] list;
	static int[][] dArr = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	
	static class Fireball {
		int m;
		int d;
		int s;
		
		public Fireball(int m, int d, int s) {
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				list[i][j] = new LinkedList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list[r][c].offer(new Fireball(m, d, s));
		}
		
		for (int i = 0; i < K; i++) {
			move();
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = list[i][j].size();
				for (int k = 0; k < size; k++) {
					result += list[i][j].poll().m;
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static void move() {
		Queue<Fireball>[][] temp = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = new LinkedList<>();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = list[i][j].size();
				for (int k = 0; k < size; k++) {
					Fireball fireball = list[i][j].poll();
					int m = fireball.m;
					int d = fireball.d;
					int s = fireball.s;
					
					int nx = (N + i + dArr[d][0] * (s % N)) % N;
					int ny = (N + j + dArr[d][1] * (s % N)) % N;
					temp[nx][ny].offer(new Fireball(m, d, s));
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j].size() == 1) {
					Fireball fireball = temp[i][j].poll();
					list[i][j].offer(new Fireball(fireball.m, fireball.d, fireball.s));
				} else if (temp[i][j].size() >= 2) {
					int mSum = 0;
					int sSum = 0;
					int size = temp[i][j].size();
					int dOddCnt = 0;
					int dEvenCnt = 0;
					for (int k = 0; k < size; k++) {
						Fireball fireball = temp[i][j].poll();
						mSum += fireball.m;
						sSum += fireball.s;
						if (fireball.d % 2 == 0) dEvenCnt++;
						else dOddCnt++;
					}
					
					if (mSum / 5 == 0) continue;
					if (dOddCnt == 0 || dEvenCnt == 0) {
						list[i][j].offer(new Fireball(mSum / 5, 0, sSum / size));
						list[i][j].offer(new Fireball(mSum / 5, 2, sSum / size));
						list[i][j].offer(new Fireball(mSum / 5, 4, sSum / size));
						list[i][j].offer(new Fireball(mSum / 5, 6, sSum / size));
					} else {
						list[i][j].offer(new Fireball(mSum / 5, 1, sSum / size));
						list[i][j].offer(new Fireball(mSum / 5, 3, sSum / size));
						list[i][j].offer(new Fireball(mSum / 5, 5, sSum / size));
						list[i][j].offer(new Fireball(mSum / 5, 7, sSum / size));
					}
				}
			}
		}
	}

}
