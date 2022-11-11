import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1374 {
	
	static class Subject implements Comparable<Subject> {
		int sTime;
		int eTime;
		
		public Subject(int sTime, int eTime) {
			this.sTime = sTime;
			this.eTime = eTime;
		}
		
		@Override
		public int compareTo(Subject o) {
			return this.sTime - o.sTime;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Subject> subjectList = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int sTime = Integer.parseInt(st.nextToken());
			int eTime = Integer.parseInt(st.nextToken());
			
			subjectList.offer(new Subject(sTime, eTime));
		}
		
		PriorityQueue<Integer> roomList = new PriorityQueue<>();
		roomList.offer(subjectList.poll().eTime);
		while (!subjectList.isEmpty()) {
			Subject subject = subjectList.poll();
			int sTime = subject.sTime;
			int eTime = subject.eTime;
			
			if (sTime >= roomList.peek()) {
				roomList.poll();
			}
			
			roomList.offer(eTime);
		}
		
		System.out.println(roomList.size());
	}

}
