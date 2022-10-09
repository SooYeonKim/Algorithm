import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238 {
	
	static int N, M, F;
	static int[][] array;
	static int[] taxi;
	static int[][] startMap;
	static List<Integer>[][] endMap;
	static int[][] d = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		array = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		taxi = new int[2];
		st = new StringTokenizer(br.readLine(), " ");
		taxi[0] = Integer.parseInt(st.nextToken());
		taxi[1] = Integer.parseInt(st.nextToken());
		
		startMap = new int[N+1][N+1];
		endMap = new ArrayList[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				endMap[i][j] = new ArrayList<>();
			}
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			startMap[sx][sy] = i;
			endMap[ex][ey].add(i);
		}
		
		flag = true;
		while (M > 0) {
			//최단거리가 가장 짧은 승객 찾기
			int[] pos; //x, y, 거리, 승객번호
			if (startMap[taxi[0]][taxi[1]] != 0) {
				pos = new int[] {taxi[0], taxi[1], 0, startMap[taxi[0]][taxi[1]]};
				startMap[taxi[0]][taxi[1]] = 0;
			}
			else {
				pos = findPassenger();
			}
			
			if (!flag) break;
			
			//승객을 목적지로 이동시키기(연료 증가 or 업무 끝내기)
			movePassenger(pos);
			
			if (!flag) break;
		}
		
		if (M == 0) System.out.println(F);
		else System.out.println(-1);
	}
	
	private static int[] findPassenger() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {taxi[0], taxi[1], 0, 0});
		boolean[][] visited = new boolean[N+1][N+1];
		visited[taxi[0]][taxi[1]] = true;
		List<int[]> list = new ArrayList<>();
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (cur[3] != 0) {
				list.add(new int[] {cur[0], cur[1], cur[2], cur[3]});
			}
			
			if (cur[2] > F) break;
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 1 || nx > N || ny < 1 || ny > N || visited[nx][ny]) continue;
				if (array[nx][ny] == 1) continue;
				
				q.offer(new int[] {nx, ny, cur[2] + 1, startMap[nx][ny]});
				visited[nx][ny] = true;
			}
		}
		
		if (list.size() == 0) {
			flag = false;
			return new int[] {};
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
			int[] temp = list.get(0);
			taxi[0] = temp[0];
			taxi[1] = temp[1];
			F -= temp[2];
			startMap[temp[0]][temp[1]] = 0;
			return new int[] {temp[0], temp[1], temp[2], temp[3]};
		}
	}
	
	private static void movePassenger(int[] pos) {
		int num = pos[3];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {taxi[0], taxi[1], 0, 0});
		boolean[][] visited = new boolean[N+1][N+1];
		visited[taxi[0]][taxi[1]] = true;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			if (cur[3] == num) {
				taxi[0] = cur[0];
				taxi[1] = cur[1];
				M--;
				F += cur[2];
				return;
			}
			
			if (cur[2] > F) break;
			
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + d[i][0];
				int ny = cur[1] + d[i][1];
				
				if (nx < 1 || nx > N || ny < 1 || ny > N || visited[nx][ny]) continue;
				if (array[nx][ny] == 1) continue;
				
				if (endMap[nx][ny].size() == 0) {
					q.offer(new int[] {nx, ny, cur[2] + 1, 0});
					visited[nx][ny] = true;
				} else {
					for (int j = 0; j < endMap[nx][ny].size(); j++) {
						q.offer(new int[] {nx, ny, cur[2] + 1, endMap[nx][ny].get(j)});
						visited[nx][ny] = true;
					}
				}
			}
		}
		
		flag = false;
		return;
	}

}
