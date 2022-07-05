import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 {
	
	static int N, M;
	static Bus[] array;
	static long[] dist;
	
	static class Bus {
		int A, B, C;
		
		public Bus(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new Bus[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			array[i] = new Bus(A, B, C);
		}
		
		dist = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		if (bellmanFord()) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= N; i++) {
				System.out.println(dist[i] == Long.MAX_VALUE ? -1 : dist[i]);
			}
		}
	}
	
	private static boolean bellmanFord() {
		dist[1] = 0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < M; j++) {
				int A = array[j].A;
				int B = array[j].B;
				int C = array[j].C;
				
				if (dist[A] == Long.MAX_VALUE) continue;
				if (dist[A] + C < dist[B]) dist[B] = dist[A] + C;
			}
		}
		
		for (int j = 0; j < M; j++) {
			int A = array[j].A;
			int B = array[j].B;
			int C = array[j].C;
			
			if (dist[A] == Long.MAX_VALUE) continue;
			if (dist[A] + C < dist[B]) return true;
		}
		
		return false;
	}

}
