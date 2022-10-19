import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2310 {
	
	static int n;
	static Room[] array;
	static boolean[] visited;
	static boolean flag;
	
	static class Room {
		char type;
		int fee;
		List<Integer> list;
		
		public Room(char type, int fee, List<Integer> list) {
			this.type = type;
			this.fee = fee;
			this.list = list;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			
			array = new Room[n+1];
			visited = new boolean[n+1];
			flag = false;
			for (int i = 1; i <= n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				char type = st.nextToken().charAt(0);
				int fee = Integer.parseInt(st.nextToken());
				List<Integer> list = new ArrayList<>();
				while (true) {
					int k = Integer.parseInt(st.nextToken());
					if (k == 0) break;
					list.add(k);
				}
				
				array[i] = new Room(type, fee, list);
			}
			
			if (array[1].type == 'E') {
				visited[1] = true;
				recursion(1, 0);
			} else if (array[1].type == 'L') {
				visited[1] = true;
				int money = 0;
				if (money < array[1].fee) money = array[1].fee;
				recursion(1, money);
			}
			
			if (flag) System.out.println("Yes");
			else System.out.println("No");
		}
	}
	
	private static void recursion(int num, int money) {
		if (num == n) {
			flag = true;
			return;
		}
		
		for (int i = 0; i < array[num].list.size(); i++) {
			int temp = array[num].list.get(i);
			if (visited[temp]) continue;
			
			visited[temp] = true;
			if (array[temp].type == 'E') {
				recursion(temp, money);
			} else if (array[temp].type == 'L') {
				if (money < array[temp].fee) recursion(temp, array[temp].fee);
				else recursion(temp, money);
			} else {
				if (money >= array[temp].fee) {
					recursion(temp, money - array[temp].fee);
				}
			}
			visited[temp] = false;
			
			if (flag) break;
		}
	}

}
