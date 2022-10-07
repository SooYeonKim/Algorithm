import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_23291 {
	
	static int N, K;
	static int[][] array;
	static int[][] d = {{1, 0}, {0, 1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		array = new int[N+1][N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			array[N][i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		while (true) {
			result++;
			
			//물고기 추가
			addFish();
			
			//어항 쌓기
			buildBowl();
			
			//물고기 조절 작업
			moveFish();
			
			//어항 일렬로 놓기
			buildOneLine();
			
			//어항 접기
			foldBowl();
			
			//물고기 조절 작업
			moveFish();
			
			//어항 일렬로 놓기
			buildOneLine();
			
			//어항의 물고기 수 차이 계산
			int max = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (array[i][j] == 0) continue;
					max = Math.max(max, array[i][j]);
					min = Math.min(min, array[i][j]);
				}
			}
			
			if (max - min <= K) break;
		}
		
		System.out.println(result);
	}
	
	private static void addFish() {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			min = Math.min(min, array[N][i]);
		}
		
		for (int i = 1; i <= N; i++) {
			if (array[N][i] == min) array[N][i]++;
		}
	}
	
	private static void buildBowl() {
		int pivot, w, h;
		pivot = w = h = 1;
		int idx = 0;
		while (pivot - 1 + w + h <= N) {
			idx++;
			for (int i = N; i > N - h; i--) {
				for (int j = pivot; j < pivot + w; j++) {
					int nx = N - w + j - pivot;
					int ny = pivot + w + N - i;
					array[nx][ny] = array[i][j];
					array[i][j] = 0;
				}
			}
			
			pivot += w;
			if (idx % 2 == 0) w++;
			else h++;
		}
	}
	
	private static void moveFish() {
		int[][] temp = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (array[i][j] == 0) continue;
				for (int k = 0; k < 2; k++) {
					int nx = i + d[k][0];
					int ny = j + d[k][1];
					if (nx < 1 || nx > N || ny < 1 || ny > N || array[nx][ny] == 0) continue;
					
					int diff = Math.abs(array[i][j] - array[nx][ny]);
					if (diff / 5 > 0) {
						if (array[i][j] > array[nx][ny]) {
							temp[i][j] -= (diff / 5);
							temp[nx][ny] += (diff / 5);
						} else {
							temp[nx][ny] -= (diff / 5);
							temp[i][j] += (diff / 5);
						}
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				array[i][j] += temp[i][j];
			}
		}
	}
	
	private static void buildOneLine() {
		Queue<Integer> q = new LinkedList<>();
		for (int j = 1; j <= N; j++) {
			for (int i = N; i > 0; i--) {
				if (array[i][j] == 0) break;
				q.offer(array[i][j]);
				array[i][j] = 0;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			array[N][i] = q.poll();
		}
	}
	
	private static void foldBowl() {
		int quater = N / 4;
		for (int i = 0; i < quater; i++) {
			array[N-3][quater * 3 + 1 + i] = array[N][quater * 3 - i];
			array[N][quater * 3 - i] = 0;
			
			array[N-2][quater * 3 + 1 + i] = array[N][quater + i + 1];
			array[N][quater + i + 1] = 0;
			
			array[N-1][quater * 3 + 1 + i] = array[N][quater - i];
			array[N][quater - i] = 0;
		}
	}

}
