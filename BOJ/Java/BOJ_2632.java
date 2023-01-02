import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2632 {
	
	static int s, m, n, result;
	static int[] aArr, bArr, aSum, bSum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		aArr = new int[m*2];
		bArr = new int[n*2];
		aSum = new int[2000001];
		bSum = new int[2000001];
		
		int sum = 0;
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(br.readLine());
			aArr[i] = aArr[i+m] = num;
			sum += num;
		}
		aSum[0] = 1;
		aSum[sum] = 1;
		
		sum = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			bArr[i] = bArr[i+n] = num;
			sum += num;
		}
		bSum[0] = 1;
		bSum[sum] = 1;
		
		find(m, aArr, aSum);
		find(n, bArr, bSum);
		
		for (int i = 0; i <= s; i++) {
			result += (aSum[i] * bSum[s-i]);
		}
		
		System.out.println(result);
	}
	
	private static void find(int size, int[] arr, int[] sumArr) {
		for (int i = 0; i < size; i++) {
			int sum = 0;
			for (int j = i; j < i+size-1; j++) {
				sum += arr[j];
				sumArr[sum]++;
			}
		}
	}

}
