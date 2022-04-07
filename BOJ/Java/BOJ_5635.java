import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5635 {
	
	static class Student implements Comparable<Student> {
		String name;
		int day;
		int month;
		int year;
		
		public Student(String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
		
		@Override
		public int compareTo(Student o) {
			if (this.year == o.year) {
				if (this.month == o.month) {
					return Integer.compare(this.day, o.day);
				}
				
				return Integer.compare(this.month, o.month);
			}
			
			return Integer.compare(this.year, o.year);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Student> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			list.add(new Student(name, day, month, year));
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(n-1).name);
		System.out.println(list.get(0).name);
	}

}
