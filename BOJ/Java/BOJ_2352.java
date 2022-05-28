import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2352 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] LIS = new int[n];
		int size = 0;
		for (int i = 0; i < n; i++) {
			int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, array[i])) - 1;
			LIS[temp] = array[i];
			
			if (temp == size) size++;
		}
		
		System.out.println(size);
	}

}
