import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1135 {

	static int N;
	static List<Person>[] list;
	
	static class Person implements Comparable<Person> {
		int num;
		int time;
		
		public Person(int num, int time) {
			this.num = num;
			this.time = time;
		}

		@Override
		public int compareTo(Person o) {
			return o.time - this.time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		st.nextToken();
		for (int i = 1; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			list[num].add(new Person(i, 0));
		}
		
		System.out.println(recursion(0));
	}
	
	public static int recursion(int num) {
		for (int i = 0; i < list[num].size(); i++) {
			int temp = list[num].get(i).num;
			list[num].get(i).time = recursion(temp);
		}
		
		Collections.sort(list[num]);
		
		int result = 0;
		for (int i = 0; i < list[num].size(); i++) {
			list[num].get(i).time += (i + 1);
			result = Math.max(result, list[num].get(i).time);
		}
		
		return result;
	}

}
