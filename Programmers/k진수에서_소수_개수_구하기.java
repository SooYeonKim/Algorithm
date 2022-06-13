
public class k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        String temp = Integer.toString(n, k);
        String[] sArray = temp.split("0");
        int answer = 0;
        for (int i = 0; i < sArray.length; i++) {
            if (!sArray[i].equals("")) {
                long num = Long.parseLong(sArray[i]);
                if (isPrime(num)) answer++;
            }
        }        

        return answer;
    }
    
    private boolean isPrime(Long num) {
        if (num <= 1) return false;
        
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
}
