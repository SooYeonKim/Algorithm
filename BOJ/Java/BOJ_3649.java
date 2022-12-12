import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3649 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if (str == null || str.equals("")) break;
			
			int x = Integer.parseInt(str) * 10000000;
			int n = Integer.parseInt(br.readLine());
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(array);
			
			int left = 0;
			int right = n-1;
			boolean flag = false;
			while (left < right) {
				int temp = array[right] + array[left];
				
				if (temp == x) {
					flag = true;
					break;
				} else if (temp < x) {
					left++;
				} else {
					right--;
				}
			}
			
			if (flag) {
				System.out.println("yes " + array[left] + " " + array[right]);
			} else {
				System.out.println("danger");
			}
		}
	}

}
