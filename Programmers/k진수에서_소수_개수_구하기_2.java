
public class k진수에서_소수_개수_구하기_2 {
    public int solution(int n, int k) {
        String str = Integer.toString(n, k);
        String[] array = str.split("0");
        
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("")) continue;
            
            long num = Long.parseLong(array[i]);
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    
    private boolean isPrime(long num) {
        if (num <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}
