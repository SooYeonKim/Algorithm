import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190 {
	
	static int N, K, L, d, time;
	static boolean[][] isApple;
	static List<int[]> snake;
	static Queue<DirInfo> dChange;
	static int[][] dArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	static class DirInfo {
		int X;
		char C;
		
		public DirInfo(int X, char C) {
			this.X = X;
			this.C = C;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isApple = new boolean[N + 1][N + 1];
		snake = new ArrayList<>();
		dChange = new LinkedList<>();
		
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			isApple[a][b] = true;
		}
		
		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			
			dChange.offer(new DirInfo(X, C));
		}
		
		d = 1;
		snake.add(new int[] {1, 1});
		here: while (true) {
			time++;
			
			//머리를 다음칸에 위치
			int nx = snake.get(snake.size() - 1)[0] + dArr[d][0];
			int ny = snake.get(snake.size() - 1)[1] + dArr[d][1];
			
			//벽이나 자기자신의 몸과 부딪히면 게임 종료
			if (nx < 1 || nx > N || ny < 1 || ny > N) {
				break;
			}
			
			for (int i = 0; i < snake.size(); i++) {
				if (nx == snake.get(i)[0] && ny == snake.get(i)[1]) {
					break here;
				}
			}
			
			snake.add(new int[] {nx, ny});
			
			//이동한 칸에 사과가 있다면, 사과 없어짐
			//이동한 칸에 사과가 없다면, 꼬리가 위치한 칸을 비워줌
			if (isApple[nx][ny]) {
				isApple[nx][ny] = false;
			} else {
				snake.remove(0);
			}
			
			//방향 전환
			if (!dChange.isEmpty() && dChange.peek().X == time) {
				DirInfo dirInfo = dChange.poll();
				
				if (dirInfo.C == 'L') {
					d = (d + 3) % 4;
				} else {
					d = (d + 1) % 4;
				}
			}
		}
		
		System.out.println(time);
	}

}
