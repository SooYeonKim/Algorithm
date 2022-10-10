import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21611 {
	
	static int N, M;
	static int[][] array;
	static Node[] nList;
	static int[][] dArr = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] d = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	static boolean flag;
	static int[] result;
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

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
		
		make();
		
		result = new int[4];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			//구슬 파괴
			destroy(d, s);
			
			//구슬 이동
			move();
			
			flag = true;
			while (flag) {
				//구슬 폭발
				explode();
				
				//구슬 이동
				move();
			}
			
			//구슬 변화
			change();
		}
		
		System.out.println(result[1] + result[2] * 2 + result[3] * 3);
	}
	
	private static void make() {
		nList = new Node[N*N];
		int nx = (N+1)/2;
		int ny = (N+1)/2;
		int dir = 0;
		int r = 1;
		int idx = 1;
		
		while (true) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < r; j++) {
					nx += d[dir][0];
					ny += d[dir][1];
					
					nList[idx++] = new Node(nx, ny);
					
					if (nx == 1 && ny == 1) return;
				}
				
				dir = (dir + 1) % 4;
			}
			
			r++;
		}
	}
	
	private static void destroy(int d, int s) {
		int nx = (N+1)/2;
		int ny = (N+1)/2;
		for (int i = 0; i < s; i++) {
			nx += dArr[d][0];
			ny += dArr[d][1];
			
			array[nx][ny] = 0;
		}
	}
	
	private static void move() {
		for (int i = 1; i < N*N - 1; i++) {
			int x = nList[i].x;
			int y = nList[i].y;
			
			if (array[x][y] == 0) {
				int idx = 1;
				Node nextNode = nList[i + idx];
				while (array[nextNode.x][nextNode.y] == 0) {
					idx++;
					if (i + idx >= N*N) return;
					nextNode = nList[i + idx];
				}
				
				array[x][y] = array[nextNode.x][nextNode.y];
				array[nextNode.x][nextNode.y] = 0;
			}
		}
	}
	
	private static void explode() {
		List<Integer> list = new ArrayList<>();
		int num = -1;
		boolean check = false;
		
		for (int i = 1; i < N*N; i++) {
			Node node = nList[i];
			if (array[node.x][node.y] != num) {
				if (array[node.x][node.y] == 0) break;
				
				//폭발 확인
				if (list.size() >= 4) {
					for (int j = 0; j < list.size(); j++) {
						Node temp = nList[list.get(j)];
						array[temp.x][temp.y] = 0;
					}
					check = true;
					result[num] += list.size();
				}
				
				list = new ArrayList<>();
				num = array[node.x][node.y];
			}
			
			list.add(i);
		}
		
		if (list.size() >= 4) {
			for (int j = 0; j < list.size(); j++) {
				Node temp = nList[list.get(j)];
				array[temp.x][temp.y] = 0;
			}
			check = true;
			result[num] += list.size();
		}
		
		if (!check) flag = false;
	}
	
	private static void change() {
		List<Integer> list = new ArrayList<>(); 
		int num = -1;
		int cnt = 0;
		for (int i = 1; i < N*N; i++) {
			Node node = nList[i];
			if (array[node.x][node.y] == 0) break;
			if (array[node.x][node.y] != num) {
				if (i != 1) {
					list.add(cnt);
					list.add(num);
				}
				
				num = array[node.x][node.y];
				cnt = 1;
			} else {
				cnt++;
			}
		}
		
		if (num != -1) {
			list.add(cnt);
			list.add(num);
		}
		
		for (int i = 1; i < N*N; i++) {
			if (i <= list.size()) {
				Node node = nList[i];
				array[node.x][node.y] = list.get(i - 1);
			} else {
				Node node = nList[i];
				array[node.x][node.y] = 0;
			}
		}
	}

}
