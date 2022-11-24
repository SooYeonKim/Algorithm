import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20006 {
	
	static int p, m;
	
	static class User implements Comparable<User> {
		int level;
		String nickname;
		
		public User(int level, String nickname) {
			this.level = level;
			this.nickname = nickname;
		}
		
		@Override
		public int compareTo(User o) {
			return this.nickname.compareTo(o.nickname);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		List<List<User>> list = new ArrayList<>();
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int level = Integer.parseInt(st.nextToken());
			String nickname = st.nextToken();
			
			boolean flag = false;
			for (int j = 0; j < list.size(); j++) {
				User user = list.get(j).get(0);
				int fLevel = user.level;
				
				if (list.get(j).size() < m && level >= fLevel - 10 && level <= fLevel + 10) {
					flag = true;
					list.get(j).add(new User(level, nickname));
					break;
				}
			}
			
			if (!flag) {
				List<User> temp = new ArrayList<>();
				temp.add(new User(level, nickname));
				list.add(temp);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			List<User> temp = list.get(i);
			if (temp.size() == m) System.out.println("Started!");
			else System.out.println("Waiting!");
			
			Collections.sort(temp);
			
			for (User user : temp) {
				System.out.println(user.level + " " + user.nickname);
			}
		}
	}

}
