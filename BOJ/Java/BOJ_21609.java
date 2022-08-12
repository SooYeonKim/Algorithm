import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21609 {
	
	static int N, M, result;
	static int[][] array;
	static boolean[][] visited;
	static PriorityQueue<Block> pq;
	static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	static class Block implements Comparable<Block> {
		int x;
		int y;
		int cnt;
		int rCnt;
		
		public Block(int x, int y, int cnt, int rCnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.rCnt = rCnt;
		}
		
		@Override
		public int compareTo(Block o) {
			if (o.cnt == this.cnt) {
				if (o.rCnt == this.rCnt) {
					if (o.x == this.x) {
						return o.y - this.y;
					}
					return o.x - this.x;
				}
				return o.rCnt - this.rCnt;
			}
			return o.cnt - this.cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			visited = new boolean[N][N];
			pq = new PriorityQueue<>();
			
			//가장 큰 블록 그룹 찾기
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (array[i][j] != -1 && array[i][j] != 0
							&& array[i][j] != -2 && !visited[i][j]) {
						if (bfs(i, j)) flag = true;
					}
				}
			}
			
			if (!flag) break;
			
			//블록 제거 및 점수 획득
			remove();
			
			//중력 작용
			gravity();
			
			//90도 회전
			rotate();
			
			//중력 작용
			gravity();
		}
		
		System.out.println(result);
	}
	
	private static boolean bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		int cnt = 1;
		int rCnt = 0;
		int num = array[x][y];
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				if (array[nx][ny] == -2 || array[nx][ny] == -1) continue;
				
				if (array[nx][ny] == 0) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					cnt++;
					rCnt++;
				} else if (array[nx][ny] == num) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		
		if (cnt == 1) return false;
		pq.offer(new Block(x, y, cnt, rCnt));
		
		//무지개 블록 방문 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (array[i][j] == 0) visited[i][j] = false;
			}
		}
		
		return true;
	}
	
	private static void remove() {
		Block b = pq.poll();
		int x = b.x;
		int y = b.y;
		int cnt = b.cnt;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		boolean[][] check = new boolean[N][N];
		check[x][y] = true;
		int num = array[x][y];
		array[x][y] = -2;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || check[nx][ny]) continue;
				if (array[nx][ny] == -2 || array[nx][ny] == -1) continue;
				
				if (array[nx][ny] == 0 || array[nx][ny] == num) {
					q.offer(new int[] {nx, ny});
					check[nx][ny] = true;
					array[nx][ny] = -2;
				}
			}
		}
		
		result += Math.pow(cnt, 2);
	}
	
	private static void gravity() {
		for (int j = 0; j < N; j++) {
			for (int i = N-2; i >= 0; i--) {
				if (array[i][j] == -1) continue;
				
				int k = i+1;
				while (k < N) {
					if (array[k][j] != -2) break;
					k++;
				}
				
				int num = array[i][j];
				array[i][j] = -2;
				array[--k][j] = num;
			}
		}
	}
	
	private static void rotate() {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = array[i][j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				array[i][j] = temp[j][N-1-i];
			}
		}
	}

}
