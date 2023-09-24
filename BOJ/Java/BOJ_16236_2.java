import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_2 {
	
	static int N, sharkSize, eatFishCnt, time;
	static int[][] array;
	static int[] sharkPos;
	static int[][] dArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sharkSize = 2;
		eatFishCnt = 0;
		time = 0;
		array = new int[N][N];
		sharkPos = new int[2];
		flag = true;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				
				if (array[i][j] == 9) {
					array[i][j] = 0;
					sharkPos[0] = i;
					sharkPos[1] = j;
				}
			}
		}
		
		while (flag) {
			move();
		}
		
		System.out.println(time);
	}
	
	static void move() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sharkPos[0], sharkPos[1], 0});
		boolean[][] visited = new boolean[N][N];
		visited[sharkPos[0]][sharkPos[1]] = true;
		List<int[]> list = new ArrayList<>();
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dArr[i][0];
				int ny = cur[1] + dArr[i][1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				if (array[nx][ny] > sharkSize) continue;
				if (array[nx][ny] != 0 && array[nx][ny] < sharkSize) {
					list.add(new int[] {nx, ny, cur[2] + 1});
				}
				
				q.offer(new int[] {nx, ny, cur[2] + 1});
				visited[nx][ny] = true;
			}
		}
		
		if (list.size() == 0) {
			flag = false;
		} else {
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[2] == o2[2]) {
						if (o1[0] == o2[0]) {
							return o1[1] - o2[1];
						}
						return o1[0] - o2[0];
					}
					return o1[2] - o2[2];
				}
			});
			
			sharkPos[0] = list.get(0)[0];
			sharkPos[1] = list.get(0)[1];
			array[sharkPos[0]][sharkPos[1]] = 0;
			
			if (++eatFishCnt == sharkSize) {
				sharkSize++;
				eatFishCnt = 0;
			}
			
			time += list.get(0)[2];
		}
	}

}
