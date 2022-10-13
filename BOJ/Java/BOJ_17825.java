import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17825 {
	
	static int[] dice;
	static int[] order;
	static Node[] horse;
	static Node start;
	static int result;
	
	static class Node {
		int num;
		int score;
		boolean isFinish;
		boolean isExistHorse;
		Node red;
		Node blue;
		
		public Node(int num, int score) {
			this.num = num;
			this.score = score;
		}
		
		public Node getNode(int num) {
			Node temp = start;
			while (true) {
				if (temp.num == num) return temp;
				temp = temp.red;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		dice = new int[10];
		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		order = new int[10];
		horse = new Node[4];
		
		init();
		
		permutation(0);
		
		System.out.println(result);
	}
	
	private static void init() {
		start = new Node(0, 0);
		Node temp = start;
		for (int i = 1; i <= 20; i++) {
			temp.red = new Node(i, i * 2);
			temp = temp.red;
		}
		
		temp.red = new Node(21, 0);
		temp.red.isFinish = true;
		
		temp = start.getNode(5);
		temp.blue = new Node(22, 13);
		temp = temp.blue;
		temp.red = new Node(23, 16);
		temp = temp.red;
		temp.red = new Node(24, 19);
		temp = temp.red;
		
		Node middle = new Node(25, 25);
		temp.red = middle;
		
		temp = start.getNode(10);
		temp.blue = new Node(26, 22);
		temp = temp.blue;
		temp.red = new Node(27, 24);
		temp = temp.red;
		temp.red = middle;
		
		temp = start.getNode(15);
		temp.blue = new Node(28, 28);
		temp = temp.blue;
		temp.red = new Node(29, 27);
		temp = temp.red;
		temp.red = new Node(30, 26);
		temp = temp.red;
		temp.red = middle;
		
		temp = middle;
		temp.red = new Node(31, 30);
		temp = temp.red;
		temp.red = new Node(32, 35);
		temp = temp.red;
		temp.red = start.getNode(20);
	}
	
	private static void permutation(int cnt) {
		if (cnt == 10) {
			game();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			order[cnt] = i;
			permutation(cnt + 1);
		}
	}
	
	private static void game() {
		for (int i = 0; i < 4; i++) {
			horse[i] = start;
		}
		
		int score = 0;
		for (int i = 0; i < 10; i++) {
			horse[order[i]].isExistHorse = false;
			
			if (horse[order[i]].isFinish) {
				score = 0;
				break;
			} else {
				int r = dice[i];
				
				if (horse[order[i]].blue != null) {
					horse[order[i]] = horse[order[i]].blue;
					r--;
				}
				
				while (r-- > 0) {
					if (horse[order[i]].isFinish) break;
					horse[order[i]] = horse[order[i]].red;
				}
				
				if (!horse[order[i]].isFinish && horse[order[i]].isExistHorse) {
					score = 0;
					break;
				}
				
				score += horse[order[i]].score;
				horse[order[i]].isExistHorse = true;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			horse[i].isExistHorse = false;
		}
		
		result = Math.max(result, score);
	}

}
