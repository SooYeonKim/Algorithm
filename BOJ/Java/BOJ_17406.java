import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
	
	static int N, M, K, result;
	static int[][] A;
	static Node[] nArr;
	static int[] selected;
	static boolean[] visited;
	
	static class Node {
		int r;
		int c;
		int s;
		
		public Node(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		
		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		nArr = new Node[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			nArr[i] = new Node(r-1, c-1, s);
		}
		
		selected = new int[K];
		visited = new boolean[K];
		permutation(0);
		
		System.out.println(result);
	}
	
	private static void permutation(int cnt) {
		if (cnt == K) {
			int[][] temp = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = A[i][j];
				}
			}
			
			rotate(temp);
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (visited[i]) continue;
			
			visited[i] = true;
			selected[cnt] = i;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
	
	private static void rotate(int[][] temp) {
		for (int i = 0; i < K; i++) {
			int select = selected[i];
			int r = nArr[select].r;
			int c = nArr[select].c;
			int s = nArr[select].s;
			
			for (int j = 1; j <= s; j++) {
				int t = temp[r-j][c-j];
				
				for (int k = r-j; k < r+j; k++) {
					temp[k][c-j] = temp[k+1][c-j];
				}
				
				for (int k = c-j; k < c+j; k++) {
					temp[r+j][k] = temp[r+j][k+1];
				}
				
				for (int k = r+j; k > r-j; k--) {
					temp[k][c+j] = temp[k-1][c+j];
				}
				
				for (int k = c+j; k > c-j; k--) {
					temp[r-j][k] = temp[r-j][k-1];
				}
				
				temp[r-j][c-j+1] = t;
			}
		}
		
		findMin(temp);
	}
	
	private static void findMin(int[][] temp) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += temp[i][j];
			}
			
			min = Math.min(min, sum);
		}
		
		result = Math.min(result, min);
	}

}
