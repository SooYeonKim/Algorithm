import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21610 {
	
	static int N, M;
	static int[][] array;
	static Queue<int[]> cloud;
	static Queue<int[]> temp;
	static boolean[][] check;
	static int[][] dArr = {{0, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	static int[][] dArr2 = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cloud = new LinkedList<>();
		cloud.offer(new int[] {N, 1});
		cloud.offer(new int[] {N, 2});
		cloud.offer(new int[] {N-1, 1});
		cloud.offer(new int[] {N-1, 2});
		
		temp = new LinkedList<>();
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			check = new boolean[N+1][N+1];
			move(d, s);
			
			//물복사버그 마법
			while (!temp.isEmpty()) {
				int[] cur = temp.poll();
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int nx = cur[0] + dArr2[i][0];
					int ny = cur[1] + dArr2[i][1];
					
					if (nx <= 0 || nx > N || ny <= 0 || ny > N) continue;
					if (array[nx][ny] >= 1) cnt++;
				}
				
				array[cur[0]][cur[1]] += cnt;
			}
			
			//바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어듦
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!check[i][j] && array[i][j] >= 2) {
						cloud.offer(new int[] {i, j});
						array[i][j] -= 2;
					}
				}
			}
		}
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				result += array[i][j];
			}
		}
		
		System.out.println(result);
	}
	
	private static void move(int d, int s) {
		while (!cloud.isEmpty()) {
			int[] cur = cloud.poll();
			int nx = cur[0] + dArr[d][0] * s;
			int ny = cur[1] + dArr[d][1] * s;
			
			while (nx > N) {
				nx -= N;
			}
			
			while (nx < 1) {
				nx += N;
			}
			
			while (ny > N) {
				ny -= N;
			}
			
			while (ny < 1) {
				ny += N;
			}
			
			array[nx][ny] += 1;
			temp.offer(new int[] {nx, ny});
			check[nx][ny] = true;
		}
	}

}
