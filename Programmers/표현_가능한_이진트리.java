
public class 표현_가능한_이진트리 {
	class Solution {
	    public int[] solution(long[] numbers) {
	        int[] answer = new int[numbers.length];
	        for (int i = 0; i < numbers.length; i++) {
	            String str = Long.toBinaryString(numbers[i]);
	            
	            int h = 0;
	            while (Math.pow(2, h) - 1 < str.length()) {
	                h++;
	            }
	            
	            while (str.length() != Math.pow(2, h) - 1) {
	                str = "0" + str;
	            }
	            
	            if (dfs(str)) answer[i] = 1;
	        }
	        
	        return answer;
	    }
	    
	    private boolean dfs(String str) {
	        int mid = str.length() / 2;
	        String left = str.substring(0, mid);
	        String right = str.substring(mid + 1, str.length());
	        
	        if (str.charAt(mid) == '0' && (left.charAt(left.length() / 2) == '1' || right.charAt(right.length() / 2) == '1')) return false;
	        
	        if (left.length() >= 3) {
	            if (dfs(left)) {
	                if (!dfs(right)) return false;
	            } else {
	                return false;
	            }
	        }
	        
	        return true;
	    }
	}
}
