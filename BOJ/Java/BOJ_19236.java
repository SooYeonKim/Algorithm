import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19236 {
	
	static int[][] array;
	static Fish[] fishList;
	static int[][] dArray = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
	static int result;
	
	static class Fish {
		int x;
		int y;
		int d;
		boolean isAlive;
		
		public Fish(int x, int y, int d, boolean isAlive) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.isAlive = isAlive;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		array = new int[4][4];
		fishList = new Fish[17];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				fishList[a] = new Fish(i, j, b-1, true);
				array[i][j] = a;
			}
		}
		
		int sd = fishList[array[0][0]].d;
		int num = array[0][0];
		fishList[num].isAlive = false;
		array[0][0] = 0;
		recursion(0, 0, sd, num);
		
		System.out.println(result);
	}
	
	private static void recursion(int sx, int sy, int sd, int eatSum) {
		//array 복사
		int[][] tempArray = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tempArray[i][j] = array[i][j];
			}
		}
		
		//fishList 복사
		Fish[] tempFishList = new Fish[17];
		for (int i = 1; i < 17; i++) {
			Fish fish = fishList[i];
			tempFishList[i] = new Fish(fish.x, fish.y, fish.d, fish.isAlive);
		}
		
		result = Math.max(result, eatSum);
		
		//물고기 이동
		moveFish(sx, sy);
		
		//상어 이동
		for (int i = 1; i <= 3; i++) {
			int snx = sx + dArray[sd][0] * i;
			int sny = sy + dArray[sd][1] * i;
			
			if (snx < 0 || snx >= 4 || sny < 0 || sny >= 4) continue;
			if (array[snx][sny] == 0) continue;
			
			int num = array[snx][sny];
			fishList[num].isAlive = false;
			array[snx][sny] = 0;
			
			recursion(snx, sny, fishList[num].d, eatSum + num);
			
			fishList[num].isAlive = true;
			array[snx][sny] = num;
		}
		
		//원래대로 복원
		array = tempArray;
		fishList = tempFishList;
	}
	
	private static void moveFish(int sx, int sy) {
		for (int i = 1; i < 17; i++) {
			Fish fish = fishList[i];
			int x = fish.x;
			int y = fish.y;
			int d = fish.d;
			boolean isAlive = fish.isAlive;
			
			if (!isAlive) continue;
			
			for (int j = 0; j < 8; j++) {
				int nx = x + dArray[(d + j) % 8][0];
				int ny = y + dArray[(d + j) % 8][1];
				
				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) continue;
				if (nx == sx && ny == sy) continue;
				
				fishList[i] = new Fish(nx, ny, (d + j) % 8, true);
				array[x][y] = 0;
				if (array[nx][ny] != 0) {
					int num = array[nx][ny];
					fishList[num] = new Fish(x, y, fishList[num].d, true);
					array[x][y] = num;
				}
				array[nx][ny] = i;
				break;
			}
		}
	}

}
